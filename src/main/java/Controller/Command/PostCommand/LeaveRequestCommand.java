package Controller.Command.PostCommand;

import Controller.Command.Command;
import Controller.MainServlet;
import Model.Client;
import Model.DAOClient;
import Model.DAORequest;
import Model.Exception.DAOException;
import Model.Exception.ViewException;
import Model.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LeaveRequestCommand implements Command {
    @Override
    public String getPattern() {
        return "leaveRequest";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException
    {
        String forwardPage = "/View/leaveRequest.jsp";

        String model = request.getParameter("model"); // where set? как в форме имя? - т.е. как на странице
        String rental_time = request.getParameter("rental_time");
        String id_passport = request.getParameter("id_passport");
        if (model != null && rental_time != null && id_passport != null)
        {
            DAORequest requestDAO = (DAORequest) MainServlet.jpaDAORequest;
            DAOClient clientDAO = MainServlet.jpaDAOClient;

            Client client = new Client();
            Request carRequest = new Request();
            try {
                client = clientDAO.getClientById(id_passport);
            } catch (DAOException e) {
                //e.printStackTrace();
                forwardPage = "/View/errorPage.jsp";
            }
            // check if client is't exist, add html, form to add new client
            carRequest.setClient(client);
            carRequest.setModel(model);
            carRequest.setRentalTime(Integer.valueOf(rental_time));
            carRequest.setId(getCntId() + 1);
            setCntId(getCntId() + 1);

            try {
                requestDAO.persist(carRequest);
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

    private int cntId = 0;

    public int getCntId() {
        return cntId;
    }

    public void setCntId(int cntId) {
        this.cntId = cntId;
    }
}
