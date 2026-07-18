<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/reset-password" method="post">
  <input type="hidden" name="token" value="${token}" />
  <label for="password">New Password</label>
  <input type="password" name="password" required />
  <button type="submit">Reset Password</button>
</form>

</body>
</html>