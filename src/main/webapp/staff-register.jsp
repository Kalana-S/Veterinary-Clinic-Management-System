<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Staff Registration</title>
    <link rel="stylesheet" type="text/css" href="resources/forms.css">
</head>
<body>
    <div class="container">
        <h2>Staff Registration</h2>

        <form action="staff-register" method="POST">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="role">Role:</label>
                <select id="role" name="role">
                    <option value="Doctor">Doctor</option>
                    <option value="Nurse">Nurse</option>
                    <option value="Assistant">Assistant</option>
                </select>
            </div>

            <button type="submit" class="btn">Register</button>
        </form>

        <div class="link-container">
            <a href="staff-login.jsp" class="btn">Already registered? Login here</a>
            <a href="index.jsp" class="btn">Home Page</a>
        </div>
    </div>
</body>
</html>
