<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.dao.ResourceAllocationDAO" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.ResourceAllocation" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.MedicalRecord" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.service.MedicalRecordService" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
<head>
    <title>Medical Record</title>
    <link rel="stylesheet" type="text/css" href="resources/medical-record.css">
</head>
<body>
    <%
        Connection connection = DatabaseConnection.getConnection();
        ResourceAllocationDAO resourceAllocationDAO = new ResourceAllocationDAO(connection);
        MedicalRecordService medicalRecordService = new MedicalRecordService(connection);
        
        List<ResourceAllocation> allocations = resourceAllocationDAO.getAllAllocations();
        List<MedicalRecord> existingRecords = medicalRecordService.getAllMedicalRecords();
        List<MedicalRecord> medicalRecordsWithDetails = medicalRecordService.getAllMedicalRecordsWithDetails();
    %>

    <div class="container">
        <h2>Medical Record Entry</h2>
        <table>
            <thead>
                <tr>
                    <th>Resource ID</th>
                    <th>Appointment ID</th>
                    <th>Staff ID</th>
                    <th>Owner ID</th>
                    <th>Pet ID</th>
                    <th>Facility</th>
                    <th>Equipment</th>
                    <th>Procedure Date</th>
                    <th>Procedure Type</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% for (ResourceAllocation resourceAlloc : allocations) { 
                    boolean alreadyExists = false;
                    for (MedicalRecord record : existingRecords) {
                        if (record.getResourceAllocationId() == resourceAlloc.getId()) {
                            alreadyExists = true;
                            break;
                        }
                    }
                %>
                    <tr>
                        <% if (alreadyExists) { %>
                            <td colspan="10" class="record-exists">
                                <strong>Medical record already saved for Resource ID <%= resourceAlloc.getId() %></strong>
                            </td>
                        <% } else { %>
                            <form action="MedicalRecordController" method="post">
                                <td>
                                    <%= resourceAlloc.getId() %>
                                    <input type="hidden" name="resource_allocation_id" value="<%= resourceAlloc.getId() %>">
                                </td>
                                <td><%= resourceAlloc.getAppointmentId() %>
                                    <input type="hidden" name="appointment_id" value="<%= resourceAlloc.getAppointmentId() %>">
                                </td>
                                <td><%= resourceAlloc.getStaffId() %>
                                    <input type="hidden" name="staff_id" value="<%= resourceAlloc.getStaffId() %>">
                                </td>
                                <td><%= resourceAlloc.getOwnerId() %>
                                    <input type="hidden" name="owner_id" value="<%= resourceAlloc.getOwnerId() %>">
                                </td>
                                <td><%= resourceAlloc.getPetId() %>
                                    <input type="hidden" name="pet_id" value="<%= resourceAlloc.getPetId() %>">
                                </td>
                                <td><%= resourceAlloc.getFacility() %>
                                    <input type="hidden" name="facility" value="<%= resourceAlloc.getFacility() %>">
                                </td>
                                <td><%= resourceAlloc.getEquipment() %>
                                    <input type="hidden" name="equipment" value="<%= resourceAlloc.getEquipment() %>">
                                </td>
                                <td>
                                    <input type="date" name="procedure_date" required>
                                </td>
                                <td>
                                    <select name="procedure_type">
                                        <option value="Surgery">Surgery</option>
                                        <option value="Diagnostics">Diagnostics</option>
                                        <option value="Treatment">Treatment</option>
                                        <option value="Grooming">Grooming</option>
                                    </select>
                                </td>
                                <td>
                                    <button type="submit" class="btn save">Save</button>
                                </td>
                            </form>
                        <% } %>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <h2>Saved Medical Records</h2>
        <table>
            <thead>
                <tr>
                    <th>Pet ID</th>
                    <th>Pet Name</th>
                    <th>Owner ID</th>
                    <th>Owner Name</th>
                    <th>Owner Contact No</th>
                    <th>Owner NIC</th>
                    <th>Staff ID</th>
                    <th>Staff Name</th>
                    <th>Staff Type</th>
                    <th>Allocated Facility</th>
                    <th>Allocated Equipment</th>
                    <th>Procedure Date</th>
                    <th>Procedure Type</th>
                </tr>
            </thead>
            <tbody>
                <% for (MedicalRecord record : medicalRecordsWithDetails) { %>
                    <tr>
                        <td><%= record.getPetId() %></td>
                        <td><%= record.getPetName() %></td>
                        <td><%= record.getOwnerId() %></td>
                        <td><%= record.getOwnerName() %></td>
                        <td><%= record.getOwnerContactNo() %></td>
                        <td><%= record.getOwnerNIC() %></td>
                        <td><%= record.getStaffId() %></td>
                        <td><%= record.getStaffName() %></td>
                        <td><%= record.getStaffType() %></td>
                        <td><%= record.getFacility() %></td>
                        <td><%= record.getEquipment() %></td>
                        <td><%= record.getProcedureDate() %></td>
                        <td><%= record.getProcedureType() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <a href="staff-dashboard.jsp" class="btn back">Back to Dashboard</a>
    </div>
</body>
</html>
