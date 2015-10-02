package ch.heigvd.amt.amtproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import modele.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

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
            User u = new User(email, firstName, lastName);
            System.out.println(u);
            req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
        }else{
            System.out.println(password + " != " + passwordConfirm );
            req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
        }
    }
    
    
}
