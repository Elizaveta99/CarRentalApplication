package Controller.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String action = servletRequest.getParameter("action");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (action == null || !action.equals("register") || !httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        String name = servletRequest.getParameter("name");
        String number = servletRequest.getParameter("number");

        if (login == null || password == null || name == null || number == null)
        {
            servletRequest.setAttribute("errorMessage", "Some fields are empty");
            ((HttpServletResponse) servletResponse).sendError(500);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {    }

}
