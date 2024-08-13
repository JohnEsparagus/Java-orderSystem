package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/allPatientData.jsp")
public class allPatientDataServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Change to doGet

        Model model = ModelFactory.getModel();
        List<Map<String, String>> allPatientData = model.getAllPatientData();
        request.setAttribute("allPatientData", allPatientData);
        request.getRequestDispatcher("/allPatientData.jsp").forward(request, response);
    }
}
