<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
<style>
    /* Universal style for all input components*/
    input {
        font-family: "Segoe UI", Arial, sans-serif;
        font-size: 16px;
        background-color: #fafafa;
    }
    /* Table colored in a separate color */
    table {
        background-color: #d1e7ff;
        border-collapse: collapse;
        padding: 20px;
        border-radius: 8px;
    }
    td { padding: 10px; }
    .error { color: red; font-weight: bold; }
</style>
</head>
<body>

    <h2 style="color: #ff00ff; text-decoration: underline;">Registration Page</h2>

    <p class="error">${errorMessage}</p>

    <form action="RegistrationServlet" method="post">
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>Mobile Number:</td>
                <td><input type="text" name="mobileNumber"></td>
            </tr>
            <tr>
                <td>Email Id:</td>
                <td><input type="text" name="emailId"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit" style="background-color: #87CEEB; width: 100px;">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>