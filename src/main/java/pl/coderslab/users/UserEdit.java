package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = userDao.read(Integer.parseInt(request.getParameter("userId")));
        request.setAttribute("user", user);


        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = userDao.read(Integer.parseInt(request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        if(request.getParameter("password")!=null) {
            user.setPassword(request.getParameter("password"));
        }
        userDao.update(user);
        response.sendRedirect("/user/list");



    }
}
