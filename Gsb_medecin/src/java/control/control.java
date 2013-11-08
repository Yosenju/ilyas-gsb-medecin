/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Dep;
import modele.Pays;
import modele.Med;

/**
 *
 * @author ighembaza
 */
@WebServlet(name = "control", urlPatterns = {"/control"})
public class control extends HttpServlet {
    
    private Pays p;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        p= new Pays(); //instancie les objets utiles
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
        String choix = request.getParameter("choix");
        if (choix != null) {
            Collection<Dep> p = p.getMed(choix).getP();
            request.setAttribute("listeProprio", p);
            request.setAttribute("nomClub", p.getClub(choix).getNom());
            request.setAttribute("numClub", p.getClub(choix).getNum());
            page = "listeProprio.jsp";
        } else {
            Map<Integer, Med> liste = p.listemedecin(); // récupère la collection
            request.setAttribute("listeClub", liste); // cet objet devient un attribut de request

            page = "listemedecin.jsp";
            //appel de la JSP
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
