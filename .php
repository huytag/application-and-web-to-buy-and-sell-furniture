<?php
	include "connect.php";
	$myArray = array();
	$idsp = 1;
	$space = 5;
	$limit1 = ($space - 1) * $space;
	if ($result = $conn->query("SELECT * FROM sanpham WHERE idsanpham = $idsp limit $limit1,$space")) {
	    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
	            $myArray[] = $row;
	    }
	    echo json_encode($myArray);
	}
	$result->close();
?>