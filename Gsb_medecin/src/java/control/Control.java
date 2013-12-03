/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Dep;
import modele.Pays;
import modele.Med;
import modele.Spe;

/**
 *
 * @author ighembaza
 */
@WebServlet(name = "control", urlPatterns = {"/control"})
public class Control extends HttpServlet {

    private Pays p;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        p = new Pays(); //instancie les objets utiles

    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page;

        if (request.getParameter("choix") == null) {
            page = "accueil.jsp";
        } else if (request.getParameter("choix").equals("dep")) {
            String choixDep = request.getParameter("choixDep");
            if (choixDep == null) {

                request.setAttribute("departements", p.getLesDeps());
                page = "liste_departement.jsp";
            } else {
                Dep d = p.getLeDep(choixDep);
                request.setAttribute("listemedecin", d.getLesMeds());
//                Map<Integer, Med> liste = m.getLesMeds(); // récupère la collection
//                request.setAttribute("listeNom", liste); // cet objet devient un attribut de request

                page = "listemedecin.jsp";
            }

        } else if (request.getParameter("choix").equals("nom")) {
            String choixNom = request.getParameter("choixNom");

            if (choixNom == null) {
                //Collection<Dep> d = p.getLesDeps();

                page = "choix_nom.jsp";
            } else {
                Collection<Med> med = new TreeSet<Med>();
                for (Dep d : p.getLesDeps()) {
                    for (Med m : d.getLesMeds()) {
                        if (m.getNom().startsWith(choixNom)) {
                            med.add(m);
                        }
                    }
                }
                request.setAttribute("listemedecin", med);
                page = "listemedecin.jsp";
                // appel de la JSP
            }




        } else if (request.getParameter("choix").equals("spe")) {
            String choixNom = request.getParameter("choixSpe");

            if (choixNom == null) {
                Collection<Spe> spe = p.getLesSpes();
                request.setAttribute("specialite", spe);
                page = "liste_specialite.jsp";
            } else {
                request.setAttribute("uneSpe", p.getLaSpe(choixNom));
                request.setAttribute("listemedecin", p.getLaSpe(choixNom).getLesMeds());
                page = "listemedecin.jsp";
            }

            
            // appel de la JSP
        } else {
            page = "accueil.jsp";
        }

        request.getRequestDispatcher(page).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
