<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Owner" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Owner Dashboard</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
</head>
<body>
    <%
        Owner loggedOwner = (Owner) session.getAttribute("loggedOwner");
        if (loggedOwner == null) {
            response.sendRedirect("owner-login.jsp");
            return;
        }
    %>
    <div class="dashboard-container">
        <h2>Welcome, <%= loggedOwner.getName() %></h2>
        <ul class="dashboard-menu">
            <li><a href="pets.jsp" class="btn">Add New Pets</a></li>
            <li><a href="appointments" class="btn">Add New Appointments</a></li>
            <li><a href="owner-logout" class="btn exit-btn">Logout</a></li>
        </ul>
    </div>
</body>
</html>
