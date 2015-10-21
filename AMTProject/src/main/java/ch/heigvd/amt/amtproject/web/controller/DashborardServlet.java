package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.services.AppsManagerLocal;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.amtproject.model.entities.User;

@WebServlet("/dashboard")
public class DashborardServlet extends HttpServlet {
	@EJB
	AppsManagerLocal appsManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession(false) == null){
            req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
        }
        Object model = appsManager.getAllApps();
	req.setAttribute("apps", model);
        User u = (User)req.getSession().getAttribute("user");
        req.setAttribute("name", u.getEmail());
       
        req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
    }
}
