<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Staff Dashboard</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
</head>
<body>
    <%
        Staff loggedStaff = (Staff) session.getAttribute("staff");
        if (loggedStaff == null) {
            response.sendRedirect("staff-login.jsp");
            return;
        }
    %>
    <div class="dashboard-container">
        <h2>Welcome, <%= loggedStaff.getName() %> (<%= loggedStaff.getRole() %>)</h2>
        <ul class="dashboard-menu">
            <li><a href="staff-appointments" class="btn">Manage Appointments</a></li>
            <li><a href="resource-allocation" class="btn">Allocate Resources</a></li>
            <li><a href="medical-record.jsp" class="btn">Create Medical Records</a></li>
            <li><a href="staff-logout" class="btn exit-btn">Logout</a></li>
        </ul>
    </div>
</body>
</html>
