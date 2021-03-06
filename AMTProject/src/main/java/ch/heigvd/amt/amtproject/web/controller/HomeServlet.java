package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.amtproject.entities.Account;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    
    @EJB
    UserDAOLocal userDAO;
    
    @EJB
    ApplicationDAOLocal appDAO;
    
    @EJB
    EndUserDAOLocal endUserDAO;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accountCreated", userDAO.count());
	req.setAttribute("applicationManaged", appDAO.count());
	req.setAttribute("userByApp", endUserDAO.count());
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Account u = userDAO.testConnection(username, password);
        if(u == null){
            req.setAttribute("accountCreated", userDAO.count());
            req.setAttribute("applicationManaged", appDAO.count());
            req.setAttribute("userByApp", endUserDAO.count());
            req.setAttribute("prevUsername", username);
            req.setAttribute("error", "Login failed");
            req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
        }else{
            req.getSession().setAttribute("user", u);
            resp.sendRedirect("dashboard");
        }
    }
    
    
}
