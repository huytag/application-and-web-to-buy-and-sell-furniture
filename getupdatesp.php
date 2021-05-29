<?php
    include "connect.php";
    $id = $_POST['id'];
    $tensanpham = $_POST['tensanpham'];
    $giasanpham = $_POST['giasanpham'];
    $hinhanhsanpham = $_POST['hinhanhsanpham'];
    $motasanpham = $_POST['motasanpham'];
    // Check connection
    if ($conn->connect_error) {
      die("Connection failed: " . $conn->connect_error);
    }

    // sql to delete a record
    $sql = "UPDATE sanpham SET tensanpham ='$tensanpham', giasanpham ='$giasanpham',hinhanhsanpham = '$hinhanhsanpham',  motasanpham = '$motasanpham' WHERE id='$id'";

    if ($conn->query($sql) === TRUE) {
      echo "1";
    } else {
      echo "0";
    }

    $conn->close();
?>