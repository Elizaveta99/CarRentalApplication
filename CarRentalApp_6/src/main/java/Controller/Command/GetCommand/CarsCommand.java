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

public class CarsCommand implements Command {

    @Override
    public String getPattern() {
        return "cars";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/View/cars.jsp"); // ??

        //DAOCar carDAO = (DAOCar) servletContext.getAttribute("carDAO");
        DAOCar carDAO = (DAOCar) MainServlet.jpaDAOCar; // ??
        List list = carDAO.getAllCars(); // or List<Car>
        request.setAttribute("carsList", list);

        dispatcher.forward(request, response);
    }
}
