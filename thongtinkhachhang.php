<?php
	include "connect.php";
	$tenkh = $_POST['tenkhachhang'];
	$sdt  = $_POST['sodienthoai'];
	$email = $_POST['email'];
	// $tenkh = 'ko';
	// $sdt  = '856786786';
	// $email = 'huytag@mail.com';
	if(strlen($tenkh) > 0  && strlen($sdt) && strlen($email) > 0){
	// Câu SQL Insert
	$sql = "INSERT INTO donhang (id, tenkhachhang,sodienthoai,email) 
	        VALUES (null, '$tenkh', '$sdt', '$email')";
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