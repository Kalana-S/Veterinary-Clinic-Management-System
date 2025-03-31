<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Staff Login</title>
    <link rel="stylesheet" type="text/css" href="resources/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Staff Login</h2>

        <% if (request.getParameter("error") != null) { %>
            <p class="error-message">Invalid email or password.</p>
        <% } %>

        <form action="staff-login" method="POST">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>

        <div class="link-container">
            <a href="index.jsp" class="btn">Home Page</a>
        </div>
    </div>
</body>
</html>
