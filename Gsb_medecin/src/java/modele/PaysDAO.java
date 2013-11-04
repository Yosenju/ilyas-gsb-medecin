/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author ighembaza
 */
public class PaysDAO {

    private static HashSet<Dep> b;

    public static void charge(Pays p) {
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rs = req.executeQuery("select * from medecin");

            //Parcours
            String id;
            String nom;
            String prenom;
            String adresse;
            String tel;
            String specialitecomplementaire;
            String departement;


            rs.next();
            id = rs.getString(1);
            nom = rs.getString(2);
            prenom = rs.getString(3);
            adresse = rs.getString(4);
            tel = rs.getString(5);
            specialitecomplementaire = rs.getString(6);
            departement = rs.getString(7);
            
            p.getLeDep(departement);

//            b.addType(null);

//                t = new HashSet <Type> ();
            Statement reqP = con.createStatement();
            ResultSet rsP = reqP.executeQuery(
                    "select id, description,prix "
                    + "from type order by prix");

            while (rsP.next()) {
                Statement reqP2 = con.createStatement();
                ResultSet rsP2 = reqP2.executeQuery(
                        "select code, idType, nomabo "
                        + "from emplacement where idType = " + rsP.getString("id"));
                Collection<Dep> e = new HashSet<Dep>();

                while (rsP2.next()) {
                    e.add(new Med(rsP2.getString(1), rsP2.getString(3)));
                }


                Med t = new Med(rsP.getString("id"), rsP.getString("description"),
                        rsP.getDouble("prix"), e);
                //b.add(new Brocante(rsP.getInt(1),rsP.getString(2),rsP.getString(3)));
                p.addType(t);
            }
            rsP.close();
//              
//                lesTypes.put(new String(nom), new Brocante(nom, lieu, dateb, t));
//                i++;
//            
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }

    }
