<?php
require_once ('database.php');
if (!empty($_POST)) {
	$tenuser = $_POST['tenuser'];
	$email    = $_POST['email'];
	$pass = $_POST['pass'];
	// insert, update, delete & select
	if ($tenuser != "" && $pass != "") {
		$query = 'insert into user_login(tenuser,email,pass) values("'.$tenuser.'", "'.$email.'", "'.$pass.'")';
		query($query);
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
</div>
</body>
</html>