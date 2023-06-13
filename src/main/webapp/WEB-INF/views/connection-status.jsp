<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Database Connection Status</title>
</head>
<body>
    <h1>Database Connection Status</h1>
    <p>Connected: <span th:text="${isConnected}"></span></p>
</body>
</html>
