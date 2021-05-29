<?php
require_once ('database.php');
if (!empty($_POST)) {
	$tenuser = $_POST['tenuser'];
	$email    = $_POST['email'];
	$pass = $_POST['pass'];
	// insert, update, delete & select
	if ($tenuser != "" && $pass != "" && $email != "") {
		$query = 'insert into user_login(tenuser,email,pass) values("'.$tenuser.'", "'.$email.'", "'.$pass.'")';
		query($query);
		header('Location: dangnhap.php');
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
<style>
	  body {
	    font: 20px Montserrat, sans-serif;
	    line-height: 1.8;

	  }
	  p {font-size: 16px;}
	  .margin {margin-bottom: 45px;}
	  .bg-1 { 
	    background-color: #1abc9c; /* Green */
	    color: #ffffff;
	  }
	  .bg-2 { 
	    background-color: #474e5d; /* Dark Blue */
	    color: #ffffff;
	  }
	  .bg-3 { 
	    background-color: #ffffff; /* White */
	    color: #555555;
	  }
	  .bg-4 { 
	    background-color: #2f2f2f; /* Black Gray */
	    color: #fff;
	  }
	  .container-fluid {
	    padding-top: 50px;
	    padding-bottom: 70px;
	  }
	  .navbar {
	    padding-bottom: 15px;
	    border: 0;
	    border-radius: 0;
	    margin-bottom: 0;
	    font-size: 12px;
	    letter-spacing: 5px;
	  }
	  .navbar-nav  li a:hover {
	    color: #1abc9c !important;
	  }
  </style>
</head>
<body>
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
					<label>Email</label>
					<input type="email" name="email" class="form-control">
				</div>
				<button class="btn btn-success">Đăng ký</button>
			</form>
		</div>
</div>
<footer class="container-fluid bg-4 text-center">
  <p>Design by Thang chay <a href="https://thangchay.zyrosite.com/?fbclid=IwAR2owJbV6ZqSk8s23Vq3EkRKEJJLBP2EJ7fnDc7jUgJfKlghUJOFcDhgr7c">www.Thangchay.com</a></p> 
</footer>
</body>
</html>