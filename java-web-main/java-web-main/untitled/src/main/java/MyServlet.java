

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MyServlet")
public class MyServlet  extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            // Procesa alguna lógica aquí
            String message = "{message: 'Hola desde el Servlet'}";
            response.setContentType("application/json");

            String action = request.getParameter("ACTION");
            //String id= request.getParameter("id");
            PrintWriter out = response.getWriter();
            
            //out.print(message);a
            //out.print(convertUsersToJSONString(userList));
            // out.print(jsonResponseObject);

            // Escribir el JSON en el PrintWriter
            //out.print(jsonResponse);
            /*request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
             */
        }

    public static String convertUsersToJSONString(List<User> users) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"username\": \"").append(user.getUsername()).append("\", ");
            jsonBuilder.append("\"token\": \"").append(user.getToken()).append("\"");
            jsonBuilder.append("}");

            // Si no es el último elemento, añade una coma
            if (i < users.size() - 1) {
                jsonBuilder.append(", ");
            }
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
    }

