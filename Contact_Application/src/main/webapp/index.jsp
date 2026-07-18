<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Register | Contact Manager</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

  <!-- Custom Styles -->
  <style>
    body {
      background-color: #f0f2f5;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .register-container {
      max-width: 500px;
      margin: 60px auto;
      padding: 30px;
      background-color: #ffffff;
      border-radius: 12px;
      box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
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

    .login-link {
      display: block;
      text-align: center;
      margin-top: 15px;
      color: #0d6efd;
      font-weight: 500;
    }

    .login-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

  <div class="container">
    <div class="register-container">
      <h2 class="mb-4 text-center text-primary">Register Here</h2>

      <form action="register" method="post">
        <div class="mb-3">
          <label for="nameInput" class="form-label">Name</label>
          <input type="text" name="name" class="form-control" id="nameInput" placeholder="e.g., Allen" required>
        </div>

        <div class="mb-3">
          <label for="emailInput" class="form-label">Email</label>
          <input type="email" name="email" class="form-control" id="emailInput" placeholder="e.g., allen@gmail.com" required>
        </div>

        <div class="mb-3">
          <label for="phoneInput" class="form-label">Phone</label>
          <input type="number" name="phone" class="form-control" id="phoneInput" placeholder="e.g., 9876543210" required>
        </div>

        <div class="mb-3">
          <label for="passwordInput" class="form-label">Password</label>
          <input type="password" name="password" class="form-control" id="passwordInput" placeholder="e.g., Allen@123" required>
        </div>

        <button type="submit" class="btn btn-primary">Register</button>
      </form>

      <a class="login-link" href="login">Already Registered?</a>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>
