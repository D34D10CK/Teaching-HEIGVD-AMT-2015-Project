package ch.heigvd.amt.amtproject.web.controller;

import ch.heigvd.amt.amtproject.model.entities.Account;
import ch.heigvd.amt.amtproject.model.entities.EndUser;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.ejb.EJB;
import java.util.List;

@WebServlet("/list-users")
public class ListUsersServlet extends HttpServlet {

    @EJB
    EndUserDAOLocal endUserDAO;
    
    @EJB
    ApplicationDAOLocal appDAO;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final double NB_BY_PAGE = 5;
        
        Long appId = Long.valueOf(req.getParameter("appId"));
        int page = Integer.valueOf(req.getParameter("page"));
        Application app = appDAO.findById(appId);
        int nbEU = endUserDAO.getEndUserList(app).size();
        int nbPages = (int)Math.ceil(nbEU/NB_BY_PAGE) ;

        page = page > nbPages ? nbPages : page;
        List<EndUser> endUsers = endUserDAO.findByAppAndPage(app, (int)NB_BY_PAGE, page);
        
        Account u = (Account)req.getSession().getAttribute("user");
        
        req.setAttribute("appId", appId);
        req.setAttribute("appName", app.getName());
        req.setAttribute("name", u.getEmail());
        req.setAttribute("page", page);
        req.setAttribute("nbPages", nbPages);
       
        req.setAttribute("endUsers", endUsers);
        req.getRequestDispatcher("/WEB-INF/pages/list-users.jsp").forward(req, resp);
    }
}
