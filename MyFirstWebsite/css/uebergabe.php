
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Daten aus dem Formular abrufen
  $username = $_POST["username"];
  $email = $_POST["email"];
  $password = $_POST["passwort"];

  $salt = "add_some_salt_here";
  $pepper = "add_some_pepper_here";
  $password_hashed = hash("sha256", $salt . $password . $pepper);

  $data = array($username, $email, $password_hashed);
  $file = fopen("data.csv", "a");
  fputcsv($file, $data);
  fclose($file);
}
?>

