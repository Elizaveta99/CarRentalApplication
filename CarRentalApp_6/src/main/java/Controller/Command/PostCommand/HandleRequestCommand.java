package Controller.Command.PostCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.DAOCar;
import Model.DAORequest;
import Model.Exception.DAOException;
import Model.Exception.ViewException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HandleRequestCommand implements Command {

    @Override
    public String getPattern() {
        return "handleRequest";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        String forwardPage = "/View/handleRequest.jsp";

        String carId = request.getParameter("car_id");
        String requestId = request.getParameter("request_id");
        if (carId != null && requestId != null) {
            DAOCar carDAO = (DAOCar) MainServlet.jpaDAOCar;
            DAORequest requestDAO = (DAORequest) MainServlet.jpaDAORequest;
            try {
                carDAO.getCarByIdUpdate(Integer.valueOf(carId), false);
            } catch (DAOException e) {
                //e.printStackTrace();
                forwardPage = "/View/errorPage.jsp";
            }
            try {
                requestDAO.remove(Integer.valueOf(requestId));
            } catch (ViewException e) {
                //e.printStackTrace();
                forwardPage = "/View/errorPage.jsp";
            } catch (DAOException e) {
                //e.printStackTrace();
                forwardPage = "/View/errorPage.jsp";
            }
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
    }
}
