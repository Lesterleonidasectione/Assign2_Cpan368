package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Registration;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Parsing/Traversing the data 
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailId = request.getParameter("emailId");

        // Print to Console
        System.out.println("--- Console: Received Data for " + userName + " ---");

        boolean isValid = true;
        StringBuilder errorMsg = new StringBuilder();

        // 2. Validation Logic 
        
        // UserName: cannot be blank and max 10 characters
        if (userName == null || userName.trim().isEmpty() || userName.length() > 10) {
            isValid = false;
            errorMsg.append("UserName Error. ");
            System.out.println("CONSOLE ERROR: UserName is blank or over 10 chars.");
        }

        // Password: digits, $, _ only and max 10 chars
        if (password == null || !password.matches("^[0-9$_]{1,10}$")) {
            isValid = false;
            errorMsg.append("Password Error. ");
            System.out.println("CONSOLE ERROR: Password does not meet regex requirements.");
        }

        // Mobile Number: exactly 10 digits
        if (mobileNumber == null || !mobileNumber.matches("^[0-9]{10}$")) {
            isValid = false;
            errorMsg.append("Mobile Error. ");
            System.out.println("CONSOLE ERROR: Mobile number must be exactly 10 digits.");
        }

        // 3. MVC Flow
        if (isValid) {
            System.out.println("CONSOLE SUCCESS: Validation Passed.");
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // Return to JSP with errors 
            request.setAttribute("errorMessage", errorMsg.toString());
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}