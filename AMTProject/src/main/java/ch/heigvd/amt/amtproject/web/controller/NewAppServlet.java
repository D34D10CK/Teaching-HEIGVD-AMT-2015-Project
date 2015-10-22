package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.User;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

@WebServlet("/new-app")
public class NewAppServlet extends HttpServlet {
    @EJB
    ApplicationDAOLocal applicationDAO;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("apiKey", applicationDAO.makeApiKey());
        req.getRequestDispatcher("/WEB-INF/pages/new-app.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String apiKey = req.getParameter("apiKey");
        HttpSession sess = req.getSession(false);
        if(sess == null){
            req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
        }else{
            User u = (User)sess.getAttribute("user");
            Application temp = new Application(apiKey, u, name, description);
            System.out.println(temp.getApiKey());
            applicationDAO.create(temp);
            /*req.setAttribute("apiKey", apiKey);
            req.getRequestDispatcher("/WEB-INF/pages/new-app.jsp").forward(req, resp);
                    */
            
        }
        req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
        
        
        
    }
    
    
}
