package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User[] allUsers = userDao.findAll();
        request.setAttribute("allUsers", allUsers);

        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    }
}