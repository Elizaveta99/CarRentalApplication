package Controller;

import Controller.Command.*;
import Controller.Command.GetCommand.*;
import Controller.Command.PostCommand.*;
import Model.JpaDAOCar;
import Model.JpaDAOClient;
import Model.JpaDAORequest;
import Model.JpaDAOUserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, Command> getCommands, postCommands;

    public static JpaDAOCar jpaDAOCar;
    public static JpaDAOClient jpaDAOClient;
    public static JpaDAORequest jpaDAORequest;
    public static JpaDAOUserInfo jpaDAOUserInfo;

    static final Logger logger = LogManager.getLogger("commands");

    public MainServlet() {
        super();
        this.getCommands = new HashMap<>();
        this.postCommands = new HashMap<>();
    }

    @Override
    public void init() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CarRental");

        jpaDAOCar = new JpaDAOCar();
        jpaDAOCar.setEntityManagerFactory(entityManagerFactory);
        jpaDAOClient = new JpaDAOClient();
        jpaDAORequest = new JpaDAORequest();
        jpaDAOUserInfo = new JpaDAOUserInfo();

        Command[] getCommands = {
                new HomeCommand(),
                new CarsCommand(),
                new RequestsCommand(),
                new InfoCommand(),
                new ReturnCarCommand(),
                new LoginCommand(),
                new RegisterCommand(),
                new HomeLoggedCommand(),

                new LeaveRequestCommand(),
                new HandleRequestCommand(),
                new LogoutCommand()
        };
        for (Command c : getCommands) {
            this.getCommands.put(c.getPattern(), c);
        }

        Command[] postCommands = {
                new HomeCommand(),
                new LeaveRequestCommand(),
                new LoginPostCommand(),
                new RegisterPostCommand(),
                new HandleRequestCommand(),
                new LogoutCommand(),
                new HomeLoggedCommand(),
                new InfoCommand(),
                new ReturnCarCommand()
        };
        for (Command c : postCommands) {
                this.postCommands.put(c.getPattern(), c);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("action");
        if (command == null)
        {
            createNewCookies(request, response);
            getCommands.get("home").execute(request, response, this.getServletContext());
        }
        else if (getCommands.containsKey(command))
        {
            getCommands.get(command).execute(request, response, this.getServletContext());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("action");
        logger.info("doPost MainServlet");
        if (command == null)
        {
            postCommands.get("home").execute(request, response, this.getServletContext());
        }
        else if (postCommands.containsKey(command))
        {
            logger.info("in MainServlet to " + command);
            postCommands.get(command).execute(request, response, this.getServletContext());
        }
    }


    private void createNewCookies(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        HttpSession session = request.getSession(true);
        Cookie lastEnterTime = new Cookie("lastEnterTime", new Date().toString());
        //Cookie lastEnterTime = new Cookie("lastEnterTime", URLEncoder.encode(new Date().toString(), "UTF-8"));
        lastEnterTime.setComment("Time and date of last usage,");
        Cookie usageCount = new Cookie("usageCount", "1");
        usageCount.setComment("Amount of visits.");

        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("usageCount"))
                {
                    int lastUsageCount = Integer.parseInt(cookie.getValue());
                    lastUsageCount += 1;
                    usageCount.setValue(Integer.toString(lastUsageCount));
                }
            }
        }
        response.addCookie(lastEnterTime);
        response.addCookie(usageCount);
    }
}
