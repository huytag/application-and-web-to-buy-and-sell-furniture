<?php
require_once ('database.php');
if (!empty($_POST)) {
    $tenuser = $_POST['tenuser'];
    $pass = $_POST['pass'];

    $conn = new mysqli(HOST, USERNAME, PASSWORD, DATABASE);
    mysqli_set_charset($conn, 'utf-8');

    //thuc hien cac cau truy van
    //insert, update, delete
    // $conn->query($query);
    

    $query = "SELECT * FROM user_login WHERE tenuser = '".$tenuser."' AND pass= '".$pass."'";
    $result = mysqli_query($conn, $query);
    $data = array();
    while ($row = mysqli_fetch_array($result,1)) {
        $data[] = $row;
    }

    $conn->close();

    if($data != null && count($data) > 0){
        header('Location: indexadmin.php');
    }

    }
?>