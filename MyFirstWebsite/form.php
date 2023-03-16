<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

  $formData = array(
    'vorname' => $_POST['vorname'],
    'nachname' => $_POST['nachname'],
    'email' => $_POST['email'],
    'geburtsdatum' => $_POST['geburtsdatum'],
    'straße' => $_POST['straße'],
    'wohnort' => $_POST['wohnort'],
    'plz' => $_POST['plz'],
    'bundesland' => $_POST['bundesland'],
    'telefonnummer' => $_POST['telefonnummer'],
    'username' => $_POST['username'],
    'password' => $_POST['password'],
    'confirm_password' => $_POST['confirm_password'],
  );

  $csvFile = fopen('user_data.csv', 'a');

  fputcsv($csvFile, $formData);

  fclose($csvFile);

  header('Location: registration_confirmation.php');
  exit();
}
?>

