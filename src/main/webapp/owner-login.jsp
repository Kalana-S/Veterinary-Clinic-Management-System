<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Owner Login</title>
    <link rel="stylesheet" type="text/css" href="resources/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Owner Login</h2>
        
        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if (errorMessage != null) { %>
            <p class="error-message"><%= errorMessage %></p>
        <% } %>

        <form action="owner-login" method="POST">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="nic">NIC:</label>
                <input type="text" id="nic" name="nic" required>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>

        <div class="link-container">
            <a href="index.jsp" class="btn">Home Page</a>
        </div>
    </div>
</body>
</html>
