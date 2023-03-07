<?php
// Überprüfen, ob das Formular abgeschickt wurde
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Dateiinformationen abrufen
  $filename = $_FILES["file"]["name"];
  $tmpname = $_FILES["file"]["tmp_name"];

  // Datei in ein Verzeichnis am Webserver speichern
  move_uploaded_file($tmpname, "uploads/" . $filename);
}


// Überprüfen, ob das Formular abgeschickt wurde
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Daten aus dem Formular abrufen
  $username = $_POST["username"];
  $password = $_POST["password"];

  // Salt und Pepper hinzufügen
  $salt = "add_some_salt_here";
  $pepper = "add_some_pepper_here";
  $password_hashed = hash("sha256", $salt . $password . $pepper);

  // Benutzerdaten aus der CSV-Datei lesen
  $file = fopen("data.csv", "r");
  while (($data = fgetcsv($file)) !== FALSE) {
    if ($data[0] == $username && $data[2] == $password_hashed) {
      // Benutzer gefunden, Session-ID generieren
      session_start();
      $_SESSION["username"] = $username;
      session_regenerate_id();
      header("Location: home.php");
      exit();
    }
  }
  fclose($file);

  // Wenn der Benutzer nicht gefunden wurde, Fehlermeldung anzeigen
  echo "Falscher Benutzername oder Passwort";
}


// Session starten und Benutzername aus der Session abrufen
session_start();
if (!isset($_SESSION["username"])) {
  header("Location: login.php");
  exit();
}
$username = $_SESSION["username"];
?>

  <html>
  <head>
    <title>Willkommen, <?php echo $username; ?></title>
  </head>
  <body>
  <h1>Willkommen, <?php echo $username; ?>!</h1>

  <p>Hier ist Ihre hochgeladene Datei:</p>
  <ul>
    <?php
    // Dateien im "uploads"-Verzeichnis auflisten
    $dir = "uploads/";
    $files = scandir($dir);
    foreach ($files as $file) {
      if ($file != "." && $file != "..") {
        echo "<li><a href=\"uploads/$file\">$file</a></li>";
      }
    }
    ?>
  </ul>

  <a href="logout.php">Ausloggen</a>
  </body>
  </html>


<?php
session_start();
session_unset();
session_destroy();
header("Location: login.php");
exit();
?>
  ``

?>
<?php
