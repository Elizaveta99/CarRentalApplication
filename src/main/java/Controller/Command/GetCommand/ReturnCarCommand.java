package Controller.Command.GetCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAOCar;
import Model.Exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReturnCarCommand implements Command {

    @Override
    public String getPattern() {
        return "returnCar";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String forwardPage = "/View/returnCar.jsp";

        String carId = request.getParameter("car_id");
        if (carId != null) {
            DAOCar carDAO = (DAOCar) MainServlet.jpaDAOCar;
            try {
                carDAO.getCarByIdUpdate(Integer.valueOf(carId), true);
            } catch (DAOException e) {
                //e.printStackTrace();
                forwardPage = "/View/errorPage.jsp";
            }
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
    }
}
