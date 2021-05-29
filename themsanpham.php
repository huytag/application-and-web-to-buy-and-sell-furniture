<?php
require_once ('database.php');

if(isset($_GET['delete_id'])){
	$delete_id = $_GET['delete_id'];
	$query = 'delete from sanpham where id = '.$delete_id;
	query($query);
}
if (!empty($_POST)) {
	$tensanpham = $_POST['tensanpham'];
	$giasanpham    = $_POST['giasanpham'];
	$hinhanhsanpham = $_POST['hinhanhsanpham'];
	$motasanpham = $_POST['motasanpham'];
	$idsanpham = $_POST['idsanpham'];
	// insert, update, delete & select
	if ($tensanpham != "" && $giasanpham != ""&& $hinhanhsanpham != ""&& $motasanpham != ""&& $idsanpham != "") {
		$query = 'insert into sanpham(tensanpham,giasanpham,hinhanhsanpham,motasanpham,idsanpham) values("'.$tensanpham.'", "'.$giasanpham.'", "'.$hinhanhsanpham.'", "'.$motasanpham.'", "'.$idsanpham.'")';
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
  			<a class="navbar-brand" href="http://localhost:8080/web/indexadmin.php">Trang chủ</a>
  			<a class="navbar-brand" href="#">Bàn gỗ</a>
  			<a class="navbar-brand" href="#">Ghế gỗ</a>
  			<a class="navbar-brand" href="#">Tủ gỗ</a>
  			<a class="navbar-brand" href="#">Móc treo,cây treo gỗ</a>
  			<a class="navbar-brand" href="#">Bàn Thờ gỗ</a>
  		</nav>

		<div class="panel-heading">
			Thêm sản phẩm  
		</div>
		<div class="panel-body">
			<form method="post">
				<div class="form-group">
					<label>Tên sản phẩm</label>
					<input type="text" name="tensanpham" class="form-control">
				</div>
				<div class="form-group">
					<label>Giá sản phẩm</label>
					<input type="text" name="giasanpham" class="form-control">
				</div>
				<div class="form-group">
					<label>Hình ảnh sản phẩm</label>
					<input type="text" name="hinhanhsanpham" class="form-control">
				</div>
				<div class="form-group">
					<label>Mô tả sản phẩm</label>
					<input type="text" name="motasanpham" class="form-control">
				</div>
				<div class="form-group">

					<label>Id sản phẩm </label> <p>1:Bàn gỗ 2:Ghế gỗ 3:Tủ gỗ 4:Móc treo,cây treo gỗ 5:Bàn thờ gỗ</p>
					<input type="text" name="idsanpham" class="form-control">
				</div>
				<button class="btn btn-success">Thêm sản phẩm</button>
		</form>
	</div>
</div>
<div class="container-fluid">
	<div class="panel panel-primary">
		<div class="panel-heading">
			List Sản Phẩm 
		</div>
		<div class="panel-body">
			<table class="table table-hover table-bordered">
				<tr>
					<th>Id</th>
					<th>Tên sản phẩm</th>
					<th>Giá sản phẩm</th>
					<th>Hình ảnh sản phẩm</th>
					<th>Mô tả sản phẩm</th>
					<th>id sản phẩm</th>
					<th width="60px">Xóa sản phẩm</th>
				</tr>
<?php
$query  = 'select * from sanpham';
$result = select($query);

for ($i = 0; $i < count($result); $i++) {
	echo '<tr>
				<td>'.$result[$i]['id'].'</td>
				<td>'.$result[$i]['tensanpham'].'</td>
				<td>'.$result[$i]['giasanpham'].'</td>
				<td>'.$result[$i]['hinhanhsanpham'].'</td>
				<td>'.$result[$i]['motasanpham'].'</td>
				<td>'.$result[$i]['idsanpham'].'</td>
				<td><a href="?delete_id='.$result[$i]['id'].'"><button class="btn">Delete</button></td>
			</tr>';
}
?>
			</table>
		</div>
	</div>
</div>
<footer class="container-fluid bg-4 text-center">
  <p>Design by Thang chay <a href="https://thangchay.zyrosite.com/?fbclid=IwAR2owJbV6ZqSk8s23Vq3EkRKEJJLBP2EJ7fnDc7jUgJfKlghUJOFcDhgr7c">www.Thangchay.com</a></p> 
</footer>
</body>
</html>