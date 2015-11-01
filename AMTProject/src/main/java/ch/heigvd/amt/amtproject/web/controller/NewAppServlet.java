package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.User;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.ApiKeyDAOLocal;
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
    
    @EJB
    ApiKeyDAOLocal apiKeyDAO;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("apiKey", new ApiKey().getApiKey());
        req.getRequestDispatcher("/WEB-INF/pages/new-app.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String apiKey = req.getParameter("apiKey");
        HttpSession sess = req.getSession(false);
        
        User u = (User)sess.getAttribute("user");
        ApiKey key = new ApiKey(apiKey);

        apiKeyDAO.create(key);
        Application temp = new Application(key, u, name, description, true);

        applicationDAO.create(temp);
        resp.sendRedirect("dashboard");
            
    
        
        
        
        
    }
    
    
}
