<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Appointment" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Staff" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Resource Allocation</title>
    <link rel="stylesheet" type="text/css" href="resources/resource-allocation.css">
</head>
<body>
    <div class="container">
        <h2>Allocate Resources</h2>
        
        <form action="resource-allocation" method="POST">
            <label>Appointment ID and Name:</label>
            <select name="appointmentId" id="appointmentSelect" onchange="updateHiddenFields()">
                <% 
                    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
                    if (appointments != null && !appointments.isEmpty()) { 
                        for (Appointment appointment : appointments) { 
                %>
                    <option value="<%= appointment.getId() %>" 
                            data-owner-id="<%= appointment.getOwnerId() %>" 
                            data-pet-id="<%= appointment.getPetId() %>">
                        <%= appointment.getId() %> - <%= appointment.getServiceDescription() %>
                    </option>
                <% 
                        } 
                    } else { 
                %>
                    <option value="">No scheduled appointments available</option>
                <% } %>
            </select>

            <!-- Hidden fields for owner_id and pet_id -->
            <input type="hidden" name="ownerId" id="ownerId">
            <input type="hidden" name="petId" id="petId">

            <label>Staff Name and Type:</label>
            <select name="staffId">
                <% 
                    List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
                    if (staffList != null && !staffList.isEmpty()) {
                        for (Staff staff : staffList) { 
                %>
                    <option value="<%= staff.getId() %>"><%= staff.getName() %> - <%= staff.getRole() %></option>
                <% 
                        } 
                    } else { 
                %>
                    <option value="">No staff available</option>
                <% } %>
            </select>

            <label>Facility:</label>
            <select name="facility">
                <option>Laboratory</option>
                <option>Operation Theatre</option>
                <option>Bed</option>
                <option>Cage</option>
            </select>

            <label>Equipment:</label>
            <select name="equipment">
                <option>Ultrasound Machine</option>
                <option>Blood Pressure Monitor</option>
                <option>Surgical Instruments</option>
                <option>Hematology Analyzer</option>
                <option>Biochemistry Analyzer</option>
                <option>Quarantine Room Equipment</option>
            </select>

            <button type="submit" class="btn allocate">Allocate</button>
        </form>
        
        <div class="link-container">
            <a href="staff-dashboard.jsp" class="btn back">Back to Dashboard</a>
        </div>
    </div>

    <script>
        function updateHiddenFields() {
            var select = document.getElementById("appointmentSelect");
            var selectedOption = select.options[select.selectedIndex];
            
            if (selectedOption) {
                document.getElementById("ownerId").value = selectedOption.getAttribute("data-owner-id") || "";
                document.getElementById("petId").value = selectedOption.getAttribute("data-pet-id") || "";
            }
        }

        // Call function initially only if there are appointments
        <% if (appointments != null && !appointments.isEmpty()) { %>
            updateHiddenFields();
        <% } %>
    </script>
</body>
</html>
