package Controller.Filter;

import Model.UserInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        String action = servletRequest.getParameter("action");
        if (user == null && !(action == null || action.equals("login") || action.equals("register"))) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/View/home.jsp");
            dispatcher.forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {    }

}

