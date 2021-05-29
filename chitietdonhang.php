<?php
	include "connect.php";
	// $json = '[{"giasanpham":69000,"madonhang":"10","soluongsanpham":1,"tensanpham":"chayqua","masanpham":20},{"giasanpham":69000,"madonhang":"12","soluongsanpham":1,"tensanpham":"duma","masanpham":12}]';
	$json = $_POST['json'];
	$data = json_decode($json, true);

		foreach ($data as $value) {
		$madonhang = $value['madonhang'];
		$masanpham = $value['masanpham'];
		$tensanpham = $value['tensanpham'];
		$giasanpham= $value['giasanpham'];
		$soluongsanpham = $value['soluongsanpham'];
		$sql = "INSERT INTO chitietdonhang (id,madonhang,masanpham,tensanpham,giasanpham,soluongsanpham) 
	        VALUES (null,'$madonhang', '$masanpham', '$tensanpham', '$giasanpham', '$soluongsanpham')";
	     if ($conn->query($sql) === TRUE) {
	     		echo "1";
			} else {
			    echo "0";
			}
		}
?> 