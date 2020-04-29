package Controller.Command.GetCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAOCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginCommand implements Command {

    static final Logger logger = LogManager.getLogger("commands");

    @Override
    public String getPattern() {
        return "login";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/View/login.jsp");

        logger.info("in LoginCommand - Get");

        dispatcher.forward(request, response);
    }

}
