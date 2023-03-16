<!DOCTYPE html>
<html>
<head>
  <title>Registrieren</title>
  <link rel="stylesheet" href="css/Style.css">
</head>
<body>

<h1>Registrieren</h1>
<form method="post" action="register.php" id="register-form">
  <label>Vorname:</label>
  <input type="text" required name="vorname"><br><br>
  <label>Nachname:</label>
  <input type="text" required name="nachname"><br><br>
  <label>E-Mail:</label>
  <input type="text" required name="email"><br><br>
  <label>Geburtsdatum:</label>
  <input type="text" required name="geburtsdatum"><br><br>
  <label>Straße:</label>
  <input type="text" required name="straße"><br><br>
  <label>Wohnort:</label>
  <input type="text" required name="wohnort"><br><br>
  <label>PLZ:</label>
  <input type="text" required name="plz"><br><br>
  <label>Bundesland:</label>
 <div> <select id="bundesland" name="bundesland">
    <option value="Burgenland">Burgenland</option>
    <option value="Kärnten">Kärnten</option>
    <option value="Niederösterreich">Niederösterreich</option>
    <option value="Oberösterreich">Oberösterreich</option>
    <option value="Salzburg">Salzburg</option>
    <option value="Steiermark">Steiermark</option>
    <option value="Tirol">Tirol</option>
    <option value="Vorarlberg">Vorarlberg</option>
    <option value="Wien">Wien</option>
  </select> <br><br>
  </div>
  <label>Telefonnummer:</label>
  <input type="text" required name="telefonnummer"><br><br>
  <label>Benutzername:</label>
  <input type="text" required name="username"><br><br>
  <label>Passwort:</label>
  <input type="password" required name="password"><br><br>
  <label>Passwort bestätigen:</label>
  <input type="password" required name="confirm_password"><br><br>
  <input type="submit" value="Register">
</form>
</div>
<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $vorname =$_POST['vorname'];
  $nachname =$_POST['nachname'];
  $email =$_POST['email'];
  $geburtsdatum =$_POST['geburtsdatum'];
  $straße =$_POST['straße'];
  $wohnort =$_POST['wohnort'];
  $plz =$_POST['plz'];
  $bundesland =$_POST['bundesland'];
  $telefonnummer =$_POST['telefonnummer'];
  $username = $_POST['username'];
  $password = $_POST['password'];
  $confirm_password = $_POST['confirm_password'];

  if ($password != $confirm_password) {
    echo '<p>The passwords are not matching.</p>';
  } else {
    header('Location: login.php');
    exit();
  }
}
?>
</body>
</html>

