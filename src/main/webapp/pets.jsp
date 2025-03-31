<%@page import="com.mycompany.veterinaryclinicmanagementsystem.dao.PetDAO"%>
<%@page import="com.mycompany.veterinaryclinicmanagementsystem.service.PetService"%>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Pet" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.model.Owner" %>
<%@ page import="com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Pets List</title>
    <link rel="stylesheet" type="text/css" href="resources/forms.css">
</head>
<body>
    <%
        Owner loggedOwner = (Owner) session.getAttribute("loggedOwner");
        if (loggedOwner == null) {
            response.sendRedirect("owner-login.jsp");
            return;
        }

        PetService petService = new PetService(new PetDAO(DatabaseConnection.getConnection()));
        List<Pet> pets = petService.getPetsByOwner(loggedOwner.getId());
    %>

    <div class="container">
        <h1>Welcome, <%= loggedOwner.getName() %></h1>
        <h2>Add Pet</h2>

        <form action="pets" method="POST">
            <div class="form-group">
                <label for="name">Name:</label> 
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label> 
                <input type="number" id="age" name="age" required>
            </div>
            <div class="form-group">
                <label for="type">Type:</label> 
                <select id="type" name="type">
                    <option value="Dog">Dog</option>
                    <option value="Parrot">Parrot</option>
                </select>
            </div>
            <input type="hidden" name="ownerId" value="<%= loggedOwner.getId() %>">
            <button type="submit" class="btn">Add Pet</button>
        </form>

        <h3>Registered Pets</h3>
        <table class="data-table">
            <thead>
                <tr>
                    <th>Pet Name</th>
                    <th>Type</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <% if (pets != null && !pets.isEmpty()) {
                    for (Pet pet : pets) { %>
                        <tr>
                            <td><%= pet.getName() %></td>
                            <td><%= pet.getType() %></td>
                            <td><%= pet.getAge() %></td>
                        </tr>
                <% } } else { %>
                    <tr>
                        <td colspan="3">No pets found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <div class="link-container">
            <a href="owner-dashboard.jsp" class="btn">Owner Dashboard</a>
        </div>
    </div>
</body>
</html>
