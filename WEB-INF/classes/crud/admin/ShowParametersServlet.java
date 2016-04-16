package crud.admin;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//http://www.informit.com/articles/article.aspx?p=102175&seqNum=3
//use doPost instead of service!

@WebServlet("/testInput")
public class ShowParametersServlet extends HttpServlet
{
	    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
				
    // Tell Web server response is HTML
    response.setContentType("text/html");    

    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<body>");
    out.println("Following parameters were passed:");
    out.println("<pre>");

// Find out the names of all the parameters.
    Enumeration params = request.getParameterNames();

    while (params.hasMoreElements())
    {
// Get the next parameter name.
      String paramName = (String) params.nextElement();

// Use getParameterValues in case there are multiple values.
      String paramValues[] = 
        request.getParameterValues(paramName);
    
// If there is only one value, print it out.
      if (paramValues.length == 1)
      {
        out.println(paramName+
          "="+paramValues[0]);
      }
      else
      {
// For multiple values, loop through them.
        out.print(paramName+"=");

        for (int i=0; i < paramValues.length; i++)
        {
// If this isn't the first value, print a comma to separate values.
          if (i > 0) out.print(',');

          out.print(paramValues[i]);
        }
        out.println();
      }
    }

    out.println("</pre>");
    out.println("</body>");
    out.println("</html>");
  }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    // Tell Web server response is HTML
    response.setContentType("text/html");    

    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<body>");
    out.println("Following parameters were passed:");
    out.println("<pre>");

// Find out the names of all the parameters.
    Enumeration params = request.getParameterNames();

    while (params.hasMoreElements())
    {
// Get the next parameter name.
      String paramName = (String) params.nextElement();

// Use getParameterValues in case there are multiple values.
      String paramValues[] = 
        request.getParameterValues(paramName);
    
// If there is only one value, print it out.
      if (paramValues.length == 1)
      {
        out.println(paramName+
          "="+paramValues[0]);
      }
      else
      {
// For multiple values, loop through them.
        out.print(paramName+"=");

        for (int i=0; i < paramValues.length; i++)
        {
// If this isn't the first value, print a comma to separate values.
          if (i > 0) out.print(',');

          out.print(paramValues[i]);
        }
        out.println();
      }
    }

    out.println("</pre>");
    out.println("</body>");
    out.println("</html>");

        String url = "/index.jsp";				
				
        if (request.getParameter("action") != null) {
					url = "add.jsp";    // set url redirect (not forward) to "add" page
					response.sendRedirect(url);
				} 						
    }
}
