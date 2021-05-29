<?php
	include "connect.php";
	$myArray = array();
	if ($result = $conn->query("SELECT * FROM donhang ORDER BY ID DESC LIMIT 20")) {
	    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
	            $myArray[] = $row;
	    }
	    echo json_encode($myArray);
	}
	$result->close();
?>