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
<!DOCTYPE html>
<html lang="en">
<head>
<title>PHP tutorial</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="panel panel-primary">
		<!-- Thanh navbar -->
		<nav class="navbar navbar-expand-sm bg-dark justify-content-center navbar-dark" >
  			<a class="navbar-brand" href="http://localhost:8080/web/index.php">Trang chủ</a>
  			<a class="navbar-brand" href="#">Bàn gỗ</a>
  			<a class="navbar-brand" href="#">Ghế gỗ</a>
  			<a class="navbar-brand" href="#">Tủ gỗ</a>
  			<a class="navbar-brand" href="#">Móc treo,cây treo gỗ</a>
  			<a class="navbar-brand" href="#">Bàn Thờ gỗ</a>
  		</nav>
		<div class="panel-heading">
			Tạo thêm tài khoản
		</div>
		<div class="panel-body">
			<form method="post">
				<div class="form-group">
					<label>User Name</label>
					<input type="text" name="tenuser" class="form-control">
				</div>
				<div class="form-group">
					<label>Password</label>
					<input type="password" name="pass" class="form-control">
				</div>
				<div class="form-group">
				<a href=http://localhost:8080/web/themtaikhoan.php>Đăng ký tài khoản ở đây</a>
				</div>
				<button class="btn btn-success">Đăng nhập</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>