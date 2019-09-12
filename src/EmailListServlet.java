import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmailListServlet")
public class EmailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/outcome.jsp";
        String action = request.
getParameter("action");
        String outcomeBody = null;
        boolean operationSuccessful = false;
        HttpSession httpSession = request.getSession();

        switch (action) {
            case "add": {
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                User user = new User(email, firstName, lastName);
                if (UserDb.addEmail(user) == 1) {
                    operationSuccessful = true;
                    System.out.println("Email added successfully!");
                    outcomeBody = "<h1>Operation Successful!</h1><p>You are now subscribed to our mailing list!<br>Use the following button to return to the index page.<br><br><a href=\"index.jsp\"><input type=\"button\" value=\"Return\"></a></p>";
                } else {
                    operationSuccessful = false;
                    System.out.println("Add email unsuccessful...");
                }
                break;
            }
            case "remove": {
                String email = request.getParameter("email");
                if (UserDb.removeEmail(email) == 1) {
                    operationSuccessful = true;
                    System.out.println("Email removed successfully!");
                    outcomeBody = "<h1>Operation Successful!</h1><p>You have been removed from our mailing list.<br>Use the following button to return to the index page.<br><br><a href=\"index.jsp\"><input type=\"button\" value=\"Return\"></a></p>";
                } else {
                    operationSuccessful = false;
                    System.out.println("Remove email unsuccessful...");
                    outcomeBody = "<h1>Operation Failed...</h1><p>There was an error removing the email you entered from our mailing list.<br>Please use the following button to try again.<br><br><a href=\"unsubscribe.jsp\"><input type=\"button\" value=\"Return\"></a></p>";
                }
                break;
            }
            case "update":
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                User user = new User(email, firstName, lastName);
                if (UserDb.updateInformation(user) == 1) {
                    operationSuccessful = true;
                    System.out.println("Information updated successfully!");
                    outcomeBody = "<h1>Operation Successful!</h1><p>You information has been updated.<br>Use the following button to return to the index page.<br><br><a href=\"index.jsp\"><input type=\"button\" value=\"Return\"></a></p>";
                } else {
                    operationSuccessful = false;
                    System.out.println("Update information unsuccessful...");
                    outcomeBody = "<h1>Operation Failed...</h1><p>There was an error updating your information.<br>Please use the following button to return to the update page.<br><br><a href=\"update.jsp\"><input type=\"button\" value=\"Return\"></a></p>";
                }
                break;
            case "show":
                if (UserDb.displayList() != null) {
                    System.out.println("Table contents displayed successfully!");
                    httpSession.setAttribute("results", "<p>The current contents of the mailing list is as follows:</p>" + UserDb.displayList());
                } else {
                    System.out.println("Display table contents unsuccessful...");
                    httpSession.setAttribute("results", "Content retrieval failed");
                }
                url = "/list.jsp";
                break;
        }
        if (operationSuccessful) {
            httpSession.setAttribute("title", "Success!");
            httpSession.setAttribute("body", outcomeBody);
        } else {
            httpSession.setAttribute("title", "Error...");
            httpSession.setAttribute("body", outcomeBody);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
