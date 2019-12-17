package app.servlets;

import app.DAO.UserDAO;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            userDAO.showEditForm(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String mail = req.getParameter("mail");
        User editUser = new User(id, firstName, lastName, mail);
        try {
            userDAO.updateUser(editUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }
}
