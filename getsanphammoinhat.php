<?php
	include "connect.php";
	$myarray = array();
	if ($result = $conn->query("SELECT * FROM sanpham ORDER BY ID DESC LIMIT 8 ")) {
	    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
	            $myArray[] = $row;
	    }
	    echo json_encode($myArray);
	}
	$result->close();
?>
