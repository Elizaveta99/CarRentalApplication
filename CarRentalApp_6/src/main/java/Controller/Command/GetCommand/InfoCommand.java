package Controller.Command.GetCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAOCar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InfoCommand implements Command {

    @Override
    public String getPattern() {
        return "info";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/View/info.jsp"); // ??

        String model = request.getParameter("model");
        if (model != null)
        {
            DAOCar carDAO = (DAOCar) MainServlet.jpaDAOCar; // ??
            List list = carDAO.getCarByCarStateAndModel(true, model); // or List<Car>
            request.setAttribute("availableCarsList", list);
        }

        dispatcher.forward(request, response);
    }
}
