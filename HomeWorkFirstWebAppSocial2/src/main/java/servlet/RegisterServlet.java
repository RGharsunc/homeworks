package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vardan on 27.06.2017.
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user=new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setAge(Integer.parseInt(age));
        user.setUsername(username);
        user.setPassword(password);

        UserManager userManager=new UserManager();
        try {
            userManager.addUser(user);
            HttpSession session=req.getSession();
            session.setAttribute("message","You have registered successfully");
            resp.sendRedirect("/index.jsp");
        }catch(SQLException e){e.printStackTrace();

        }

    }

}
