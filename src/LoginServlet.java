import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/home")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user=request.getParameter("username");
        String pass=request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(Authorization.isAllowed(user, pass)) {

            RequestDispatcher dispatcher=request.getRequestDispatcher("app");
            dispatcher.forward(request,response);
        }

        else{

            RequestDispatcher rd=request.getRequestDispatcher("/loginError.html");
            rd.include(request,response);

        }
    }
}
