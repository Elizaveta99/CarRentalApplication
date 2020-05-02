package Controller.Filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterFilter implements Filter {

    static final Logger logger = LogManager.getLogger("filter");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("register filter enter " );

        String action = servletRequest.getParameter("action");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (action == null || !action.equals("register") || !httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (action.equals("register")) {
            String login = servletRequest.getParameter("login_text");
            String password = servletRequest.getParameter("password_text");
            String name = servletRequest.getParameter("name_text");
            String number = servletRequest.getParameter("number_text");

            if (login == null || password == null || name == null || number == null) {
                logger.info("register filter works " + login + " " + password + " " + name + " " + number);
                servletRequest.setAttribute("errorMessage", "Some fields are empty");
                ((HttpServletResponse) servletResponse).sendError(500);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {    }

}
