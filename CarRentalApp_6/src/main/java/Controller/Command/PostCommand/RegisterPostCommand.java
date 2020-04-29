package Controller.Command.PostCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAOUserInfo;
import Model.Exception.DAOException;
import Model.Exception.ViewException;
import Model.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPostCommand implements Command {

    static final Logger logger = LogManager.getLogger("commands");

    @Override
    public String getPattern() {
        return "register";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        // or to home_logined.jsp
        String forwardPage = "/View/login.jsp";

        DAOUserInfo userInfoDAO = MainServlet.jpaDAOUserInfo;
        UserInfo user = new UserInfo();

        // check params in RegisterFilter

        logger.info("in RegisterPost - before user set");

        user.setLogin(request.getParameter("login_text"));
        user.setPassword(request.getParameter("password_text"));
        user.setType("user");
        user.setName(request.getParameter("name_text"));
        user.setNumber(request.getParameter("number_text"));
        user.setId(getCntId() + 1);
        setCntId(getCntId() + 1);

        try {
            userInfoDAO.persist(user);
        } catch (ViewException e) {
            logger.info("in RegisterPost - error in persist");
            forwardPage = "/View/errorPage.jsp";
        } catch (DAOException e) {
            logger.info("in RegisterPost - error in persist");
            forwardPage = "/View/errorPage.jsp";
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
    }

    private int cntId = 1;

    public int getCntId() {
        return cntId;
    }

    public void setCntId(int cntId) {
        this.cntId = cntId;
    }
}
