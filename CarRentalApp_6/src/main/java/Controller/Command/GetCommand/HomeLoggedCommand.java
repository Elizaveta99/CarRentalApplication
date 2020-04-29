package Controller.Command.GetCommand;

import Controller.Command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeLoggedCommand implements Command {
    @Override
    public String getPattern() {
        return "homeLogged";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/View/homeLogged.jsp"); // ??
        dispatcher.forward(request, response);
    }
}
