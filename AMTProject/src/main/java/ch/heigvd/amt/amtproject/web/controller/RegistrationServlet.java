package ch.heigvd.amt.amtproject.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ch.heigvd.amt.amtproject.entities.Account;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;
import javax.ejb.EJB;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @EJB
    UserDAOLocal userDAO;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("password-confirm");
        
        if(password.equals(passwordConfirm)){
            Account u = new Account(email, firstName, lastName, password);
            System.out.println(u);
            userDAO.create(u);
            req.getSession().setAttribute("user", u);
            resp.sendRedirect("dashboard");
        }else{
            System.out.println(password + " != " + passwordConfirm );
            req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
        }
    }
    
    
}
