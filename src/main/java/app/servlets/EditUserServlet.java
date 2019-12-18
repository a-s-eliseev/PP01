package app.servlets;

import app.entities.User;
import app.service.UserServiceImpl;
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

    UserServiceImpl instance = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Long id = Long.parseLong(req.getParameter("id"));
            User existingUser = instance.selectUser(id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/editUser.jsp");
            req.setAttribute("user", existingUser);
            dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Long id = Long.parseLong(req.getParameter("id"));

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String mail = req.getParameter("mail");
        User editUser = new User(id, firstName, lastName, mail);
        try {
            instance.editUser(editUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }
}
