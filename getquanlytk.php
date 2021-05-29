<?php
	include "connect.php";
	$myArray = array();
	if ($result = $conn->query("SELECT * FROM user_login ORDER BY ID DESC LIMIT 50")) {
	    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
	            $myArray[] = $row;
	    }
	    echo json_encode($myArray);
	}
	$result->close();
?>