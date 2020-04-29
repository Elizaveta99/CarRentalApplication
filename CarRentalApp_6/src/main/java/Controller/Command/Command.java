package Controller.Command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    String getPattern();
    void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException;

}
