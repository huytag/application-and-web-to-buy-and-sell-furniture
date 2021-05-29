<?php
	include "connect.php";
	$tenuser = $_POST['tenuser'];
	$email = $_POST['email'];
	$pass  = $_POST['pass'];
	// $tenkh = 'ko';
	// $sdt  = '856786786';
	// $email = 'huytag@mail.com';
	if(strlen($tenuser) > 0  && strlen($email) && strlen($pass) > 0){
	// Câu SQL Insert
	$sql = "INSERT INTO user_login (id, tenuser,email,pass) 
	        VALUES (null, '$tenuser', '$email', '$pass')";
	// Thực hiện thêm record
	if ($conn->query($sql) === TRUE) {
		$id_donhang = $conn->insert_id;
	    echo $id_donhang;
	} else {
	    echo "Lỗi: " . $sql . "<br>" . $conn->error;
	}
	
	// Ngắt kết nối
	$conn->close();
	}
?>