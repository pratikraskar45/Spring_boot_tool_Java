<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Forgot Password | Contact Manager</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous" />

  <style>
    body {
      background-color: #eef2f5;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .forgot-container {
      max-width: 450px;
      margin: 60px auto;
      padding: 30px;
      background: #fff;
      border-radius: 12px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    .btn-primary {
      width: 100%;
    }

    .instruction {
      margin-bottom: 20px;
      font-size: 1.1rem;
      color: #333;
    }

    .form-label {
      font-weight: 500;
      text-align: left;
    }
  </style>
</head>
<body>

  <div class="container">
    <div class="forgot-container">
      <h2 class="mb-4 text-primary">Password Assistance</h2>
      <p class="instruction">Enter the email address associated with your account.</p>

      <form action="forgot-password" method="post">
        <div class="mb-3 text-start">
          <label for="emailInput" class="form-label">Email</label>
          <input type="email" name="email" id="emailInput" class="form-control" placeholder="you@example.com" required />
        </div>
        <button type="submit" class="btn btn-primary">Continue</button>
      </form>

      <div class="mt-3">
        <a href="login.jsp">Back to Login</a>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>
