package Controller.Command.PostCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAOUserInfo;
import Model.Exception.DAOException;
import Model.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginPostCommand implements Command {

    static final Logger logger = LogManager.getLogger("commands");

    @Override
    public String getPattern() {
        return "login";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        //logger.info("in LoginPostCommand");

        String forwardPage = "";

        UserInfo user = null;
        String login = request.getParameter("login_text");
        String password = request.getParameter("password_text");
        String type = request.getParameter("type_text");

        // user is guest type
        if (type.equals("guest"))
        {
            user = new UserInfo();
            user.setLogin(login);
            user.setPassword(password);
            user.setType(type);
            forwardPage = "/View/home.jsp";
        }
        else {
            // user is registered in db
            DAOUserInfo userInfoDAO = MainServlet.jpaDAOUserInfo;
            try {
                user = userInfoDAO.getUser(login, password, type);
            } catch (DAOException e)
            {
                forwardPage = "/View/home.jsp";
            }

            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                logger.info("loginPost type" + type);
                forwardPage = "/View/homeLogged.jsp";
            } else {
                forwardPage = "/View/home.jsp";
            }
        }

        logger.info("forwardPage - " + forwardPage + ", type - " + type);
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e)
        {
            //System.out.println("failed page forwarding to " + forwardPage + " " + e.getMessage());
            logger.info("failed page forwarding to " + forwardPage + " " + e.getMessage());
        }
    }

}
