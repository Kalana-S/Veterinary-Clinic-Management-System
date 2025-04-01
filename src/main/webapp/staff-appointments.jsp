<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Appointment" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Manage Appointments</title>
    <link rel="stylesheet" type="text/css" href="resources/appointments.css">
</head>
<body>
    <div class="container">
        <h2>Manage Appointments</h2>

        <table>
            <thead>
                <tr>
                    <th>Owner ID</th>
                    <th>Pet ID</th>
                    <th>Date</th>
                    <th>Service</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
                    if (appointments != null && !appointments.isEmpty()) {
                        for (Appointment appointment : appointments) { 
                %>
                <tr>
                    <td><%= appointment.getOwnerId() %></td>
                    <td><%= appointment.getPetId() %></td>
                    <td><%= appointment.getAppointmentDate() %></td>
                    <td><%= appointment.getServiceDescription() %></td>
                    <td>
                        <form action="staff-appointments" method="POST">
                            <input type="hidden" name="appointmentId" value="<%= appointment.getId() %>">
                            <select name="status">
                                <option value="Scheduled" <%= appointment.getStatus().equals("Scheduled") ? "selected" : "" %>>Scheduled</option>
                                <option value="Completed" <%= appointment.getStatus().equals("Completed") ? "selected" : "" %>>Completed</option>
                                <option value="Cancelled" <%= appointment.getStatus().equals("Cancelled") ? "selected" : "" %>>Cancelled</option>
                            </select>
                            <button type="submit" name="action" value="update" class="btn update">Update</button>
                        </form>
                    </td>
                    <td>
                        <form action="staff-appointments" method="POST">
                            <input type="hidden" name="appointmentId" value="<%= appointment.getId() %>">
                            <button type="submit" name="action" value="delete" class="btn delete">Delete</button>
                        </form>
                    </td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="6" class="no-data">No appointments found.</td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <div class="link-container">
            <a href="staff-dashboard.jsp" class="btn back">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
