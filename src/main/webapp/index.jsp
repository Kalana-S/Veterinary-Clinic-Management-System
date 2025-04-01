<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Veterinary Clinic Management System - Home</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to the Veterinary Clinic Management System</h1>
        <p class="tagline">Providing the best care for your beloved pets</p>
        
        <div class="buttons">
            <a href="owners.jsp" class="btn">Owner Registration</a>
            <a href="owner-login.jsp" class="btn">Owner Login</a>
            <a href="staff-register.jsp" class="btn">Staff Registration</a>
            <a href="staff-login.jsp" class="btn">Staff Login</a>
        </div>
         <div class="exit">
            <button class="btn exit-btn" onclick="exitSystem()">Exit System</button>
        </div>
    </div>
  
    <script>
        function exitSystem() {
            if (confirm("Are you sure you want to exit?")) {
                window.close();
            }
        }
    </script>
</body>
</html>
