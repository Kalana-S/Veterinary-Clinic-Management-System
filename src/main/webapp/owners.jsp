<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Owner" %>
<%@ page import="java.util.List" %>
<%
    List<Owner> owners = (List<Owner>) request.getAttribute("owners");
    if (owners == null) {
        response.sendRedirect("owners");
        return;
    }
%>
<html>
<head>
    <title>Owners List</title>
    <link rel="stylesheet" type="text/css" href="resources/forms.css">
</head>
<body>
    <div class="container">
        <h2>Pet Owners</h2>
        <form action="owners" method="POST">
            <div class="form-group">
                <label for="name">Name:</label> 
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="contactNumber">Contact:</label> 
                <input type="text" id="contactNumber" name="contactNumber" required>
            </div>
            <div class="form-group">
                <label for="nic">NIC:</label> 
                <input type="text" id="nic" name="nic" required>
            </div>
            <button type="submit" class="btn">Add Owner</button>
        </form>

        <h3>Registered Pet Owners</h3>
        <table class="data-table">
            <thead>
                <tr>
                    <th>Owner Name</th>
                    <th>Contact No</th>
                </tr>
            </thead>
            <tbody>
                <% if (owners != null && !owners.isEmpty()) {
                    for (Owner owner : owners) { %>
                        <tr>
                            <td><%= owner.getName() %></td>
                            <td><%= owner.getContactNumber() %></td>
                        </tr>
                <% } } else { %>
                    <tr>
                        <td colspan="2">No owners found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <div class="link-container">
            <a href="owner-login.jsp" class="btn">Owner Login</a>
            <a href="index.jsp" class="btn">Home</a>
        </div>
    </div>
</body>
</html>
