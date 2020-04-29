package Controller.Command.GetCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAORequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RequestsCommand implements Command {

    @Override
    public String getPattern() {
        return "requests";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/View/requests.jsp"); // ??

        DAORequest requestDAO = (DAORequest) MainServlet.jpaDAORequest; // ??
        List list = requestDAO.getAllRequests(); // or List<Request>
        request.setAttribute("requestsList", list);

        dispatcher.forward(request, response);
    }
}
