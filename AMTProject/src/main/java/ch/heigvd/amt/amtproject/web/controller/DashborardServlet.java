package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.services.AppsManagerLocal;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashborardServlet extends HttpServlet {
	@EJB
	AppsManagerLocal appsManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object model = appsManager.getAllApps();
		req.setAttribute("apps", model);
        req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
    }
}
