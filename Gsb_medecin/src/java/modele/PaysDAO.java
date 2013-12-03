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
import java.util.TreeSet;

/**
 *
 * @author ighembaza
 */
public class PaysDAO {

    public static Collection<Dep> getLesDeps() {
        Collection<Dep> lesDeps = new TreeSet<Dep>();
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rs = req.executeQuery("select distinct departement from medecin");


            String departement;

            while (rs.next()) {
                departement = rs.getString("departement");

                lesDeps.add(new Dep(departement));
            }

//            
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
        return lesDeps;
    }

    public static Collection<Spe> getLesSpes() {
        Collection<Spe> lesSpes = new TreeSet<Spe>();
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rs = req.executeQuery("select distinct specialitecomplementaire"
                    + " from medecin where specialitecomplementaire is not null;");

            //Parcours
            String spe;


            while (rs.next()) {
                spe = rs.getString("specialitecomplementaire");

                lesSpes.add(new Spe(spe));
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
        return lesSpes;
    }

    public static Collection<Med> getLesMeds() {
        Collection<Med> lesMeds = new TreeSet<Med>();
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rsP2 = req.executeQuery("select * from medecin;");

//            Parcours
            String id;
            String nom;
            String prenom;
            String adresse;
            String tel;
            String spe;
            String dep;

            while (rsP2.next()) {
                id = rsP2.getString("id");
                nom = rsP2.getString("nom");
                prenom = rsP2.getString("prenom");
                adresse = rsP2.getString("adresse");
                tel = rsP2.getString("tel");
                spe = rsP2.getString("specialitecomplementaire");
                dep = rsP2.getString("departement");

                lesMeds.add(new Med(nom, prenom, adresse, tel, spe, id, dep));
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
        return lesMeds;
    }
}
