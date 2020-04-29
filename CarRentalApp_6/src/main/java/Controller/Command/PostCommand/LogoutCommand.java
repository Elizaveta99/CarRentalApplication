package Controller.Command.PostCommand;

import Controller.Command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {

    @Override
    public String getPattern() {
        return "logout";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/View/home.jsp");
        // try ??
        dispatcher.forward(request, response);
    }

}
