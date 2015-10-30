package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
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

@WebServlet("/app-details")
public class AppDetailsServlet extends HttpServlet {
    
    @EJB
    ApplicationDAOLocal applicationDAO; 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        long id = Long.valueOf(req.getParameter("appId"));
        if(action.equalsIgnoreCase("edit")){
            
            Application app = applicationDAO.findById(id);
            req.setAttribute("app", app);
            
            req.getRequestDispatcher("/WEB-INF/pages/app-details.jsp").forward(req, resp);
        }else if(action.equalsIgnoreCase("disable")){
            Application app = applicationDAO.findById(id);
            app.setEnable(!app.isEnable());
            applicationDAO.update(app);
            req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String apiKey = req.getParameter("apiKey");
        Long idApiKey = Long.valueOf(req.getParameter("idApiKey"));
        Long id = Long.valueOf(req.getParameter("id"));
        HttpSession sess = req.getSession(false);
        
        User u = (User)sess.getAttribute("user");
        ApiKey key = new ApiKey(apiKey);
        key.setId(idApiKey);
        Application temp = new Application(key, u, name, description);
        temp.setId(id);

        applicationDAO.update(temp);
        resp.sendRedirect("dashboard");
    }
    
    
}
