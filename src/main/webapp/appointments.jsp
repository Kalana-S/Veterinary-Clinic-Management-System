<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Owner" %>
<html>
<head>
    <title>Appointment List</title>
    <link rel="stylesheet" type="text/css" href="resources/forms.css">
</head>
<body>
    <%
        Owner loggedOwner = (Owner) session.getAttribute("loggedOwner");
        if (loggedOwner == null) {
            response.sendRedirect("owner-login.jsp");
            return;
        }
    %>

    <div class="container">
        <h1>Welcome, <%= loggedOwner.getName() %></h1>
        <h2>Book an Appointment</h2>

        <form action="appointments" method="POST">
            <input type="hidden" name="ownerId" value="<%= loggedOwner.getId() %>">

            <div class="form-group">
                <label for="petId">Pet ID:</label> 
                <input type="number" id="petId" name="petId" required>
            </div>
            <div class="form-group">
                <label for="appointmentDate">Date:</label> 
                <input type="date" id="appointmentDate" name="appointmentDate" required>
            </div>
            <div class="form-group">
                <label for="serviceDescription">Service:</label> 
                <input type="text" id="serviceDescription" name="serviceDescription" required>
            </div>

            <button type="submit" class="btn">Book Appointment</button>
        </form>

        <h3>Your Appointments</h3>
        <table class="data-table">
            <thead>
                <tr>
                    <th>Pet ID</th>
                    <th>Date</th>
                    <th>Service</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
                    if (appointments != null && !appointments.isEmpty()) {
                        for (Appointment appointment : appointments) { 
                %>
                        <tr>
                            <td><%= appointment.getPetId() %></td>
                            <td><%= appointment.getAppointmentDate() %></td>
                            <td><%= appointment.getServiceDescription() %></td>
                            <td><strong><%= appointment.getStatus() %></strong></td>
                        </tr>
                <% 
                        }
                    } else { 
                %>
                        <tr>
                            <td colspan="4">No appointments found.</td>
                        </tr>
                <% 
                    } 
                %>
            </tbody>
        </table>

        <div class="link-container">
            <a href="owner-dashboard.jsp" class="btn">Owner Dashboard</a>
        </div>
    </div>
</body>
</html>
