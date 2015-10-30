package ch.heigvd.amt.amtproject.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.amtproject.model.entities.User;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =  (User)req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.setAttribute("name", user.getEmail());
        req.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(req, resp);
    }
}
