<!DOCTYPE html>
<html>
<head>
  <title>Einloggen</title>
  <link rel="stylesheet" href="css/Style.css">
</head>
<body>

<h1>Einloggen</h1>
<form method="post" action="login.php" id="login-form">
  <label>Benutzername:</label>
  <input type="text" required name="username"><br><br>
  <label>Passwort:</label>
  <input type="password" required name="password"><br><br>
  <input type="submit" value="Einloggen">
</form>
<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $username = $_POST['username'];
  $password = $_POST['password'];
  if ($username == 'admin' && $password == 'password') {
    header('Location: index.php');
    exit();
  } else {
    echo '<p>Invalid credentials</p>';
  }
}
?>

</body>
</html>

