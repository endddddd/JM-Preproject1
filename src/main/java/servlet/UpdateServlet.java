package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    UserService ussr = UserService.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("user", ussr.getUserById(Long.valueOf(id)));
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name.trim().length() == 0 || password.trim().length() == 0) {
            doGet(request, response);
        } else {
            ussr.updateUser(name, password, Long.valueOf(id));
            doGet(request, response);
        }

    }
}
