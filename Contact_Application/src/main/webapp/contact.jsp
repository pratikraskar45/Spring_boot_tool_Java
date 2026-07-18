<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Add Contact | Contact Manager</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

  <!-- Custom Styles -->
  <style>
    body {
      background-color: #f8f9fa;
    }

    .form-container {
      max-width: 600px;
      margin: 60px auto;
      padding: 30px;
      background-color: #ffffff;
      border-radius: 12px;
      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
    }

    h1 {
      text-align: center;
      color: #0d6efd;
      margin-bottom: 30px;
    }

    .btn-primary {
      width: 100%;
    }

    .back-link {
      display: block;
      text-align: center;
      margin-top: 20px;
      font-weight: 500;
      color: #0d6efd;
    }

    .back-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

  <div class="container">
    <div class="form-container">
      <h1>Add Contact</h1>

      <form action="add" method="post">
        <input type="hidden" name="cid" value="${contact.cid}">

        <div class="mb-3">
          <label for="nameInput" class="form-label">Name</label>
          <input type="text" name="name" class="form-control" id="nameInput"
            placeholder="e.g., Martin" value="${contact.name}" required>
        </div>

        <div class="mb-3">
          <label for="phoneInput" class="form-label">Phone</label>
          <input type="number" name="phone" class="form-control" id="phoneInput"
            placeholder="e.g., 1234567890" value="${contact.phone}" required>
        </div>

        <div class="mb-3">
          <label for="adharInput" class="form-label">Aadhar Number</label>
          <input type="text" name="adharNo" class="form-control" id="adharInput"
            placeholder="e.g., 112233" value="${contact.adharNo}" required>
        </div>

        <button type="submit" class="btn btn-primary">Save Contact</button>
      </form>

      <a href="home" class="btn btn-outline-primary mt-3 w-100"> <--Back to Home
</a>
      
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>
