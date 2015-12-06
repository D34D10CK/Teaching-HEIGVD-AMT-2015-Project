package ch.heigvd.amt.amtproject.web.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.amtproject.model.entities.Account;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashborardServlet extends HttpServlet {

    @EJB
    ApplicationDAOLocal applicationDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        Account u = (Account) session.getAttribute("user");
        

        List<Application> model = applicationDAO.getAppList(u);

        System.out.println("size: " + model.size());

        req.setAttribute("apps", model);
        req.setAttribute("name", u.getEmail());

        req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
    }
}
