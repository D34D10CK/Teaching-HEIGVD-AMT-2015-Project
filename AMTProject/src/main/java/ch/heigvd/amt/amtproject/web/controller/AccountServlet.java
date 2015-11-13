package ch.heigvd.amt.amtproject.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.amtproject.model.entities.Account;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;
import javax.ejb.EJB;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    @EJB
    UserDAOLocal userDAO;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account user =  (Account)req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.setAttribute("name", user.getEmail());
        req.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------- DEBUT ----------");
        String email = req.getParameter("email");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("password-confirm");
        
        if(password.equals(passwordConfirm)){
            Account modifiedUser = new Account(email, firstName, lastName, password);
            Account currentUser = (Account)req.getSession().getAttribute("user");
            System.out.println("Current user ID : " + currentUser.getId());
            modifiedUser.setId(currentUser.getId());
            System.out.println("New user ID : " + modifiedUser.getId());
            
            userDAO.update(modifiedUser);
            req.getSession().setAttribute("user", modifiedUser);
            resp.sendRedirect("dashboard");
        }else{
            System.out.println(password + " != " + passwordConfirm );
            req.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(req, resp);
        }
    }
    
}
