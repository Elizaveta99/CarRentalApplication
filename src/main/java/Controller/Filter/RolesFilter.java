package Controller.Filter;

import Model.UserInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RolesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        String action = servletRequest.getParameter("action");

        if (user != null)
        {
            switch (user.getType())
            {
                case "admin":
                    break;
                case "guest":
                    if (!action.equals("home")) {
                        RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/View/home.jsp");
                        dispatcher.forward(servletRequest, servletResponse);
                        return;
                    }
                    break;
                case "user":
                    if (!(action.equals("cars") || action.equals("requests") || action.equals("logout"))) {
                        RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/View/homeLogged.jsp");
                        dispatcher.forward(servletRequest, servletResponse);
                        return;
                    }
                    break;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {    }
}
