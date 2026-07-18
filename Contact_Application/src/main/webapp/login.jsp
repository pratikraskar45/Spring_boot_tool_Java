<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login | Contact Manager</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

  <!-- Custom CSS -->
  <style>
    body {
      background-color: #eef2f5;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .login-container {
      max-width: 450px;
      margin: 60px auto;
      padding: 30px;
      background: #ffffff;
      border-radius: 12px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
    }

    .form-label {
      font-weight: 500;
    }

    .form-control::placeholder {
      color: #adb5bd;
    }

    .btn-primary {
      width: 100%;
    }

    .text-links {
      text-align: center;
      margin-top: 15px;
    }

    .text-links a {
      color: #0d6efd;
      font-weight: 500;
      display: inline-block;
      margin-top: 8px;
    }

    .text-links a:hover {
      text-decoration: underline;
    }

    .msg {
      color: red;
      font-weight: 500;
      margin-bottom: 10px;
      text-align: center;
    }
  </style>
</head>
<body>

  <div class="container">
    <div class="login-container">
      <h2 class="mb-4 text-center text-primary">Login</h2>
      <h5 class="msg">${msg}</h5>

      <form action="login" method="post">
        <div class="mb-3">
          <label for="emailInput" class="form-label">Email</label>
          <input type="email" name="uemail" class="form-control" id="emailInput" placeholder="e.g., allen@gmail.com" required>
        </div>

        <div class="mb-3">
          <label for="passwordInput" class="form-label">Password</label>
          <input type="password" name="upwd" class="form-control" id="passwordInput" placeholder="e.g., Allen@123" required>
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
      </form>

      <div class="text-links">
        <a href="forgot-password.jsp">Forgot Password?</a><br>
        <a href="/">New User? Register here</a>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>
``
