<?php
require_once('database.php');

?>
<!DOCTYPE html>
<html>
<head>
	<title>Web quản lý mua bán đồ gỗ</title>
	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	<style>
	  body {
	    font: 20px Montserrat, sans-serif;
	    line-height: 1.8;
	    color: #f5f6f7;
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
	    padding-top: 70px;
	    padding-bottom: 70px;
	  }
	  .navbar {
	    padding-top: 15px;
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
<!-- Thanh navbar -->
	<nav class="navbar navbar-expand-sm bg-dark justify-content-center navbar-dark" >
  			<a class="navbar-brand" href="http://localhost:8080/web/index.php">Trang chủ</a>
  			<ul class="navbar-nav">
    			<li class="nav-item">
      				<a class="nav-link" href="#">Bàn gỗ</a>
    			</li>
    			<li class="nav-item">
      				<a class="nav-link" href="#">Ghế gỗ</a>
    			</li>
    			<li class="nav-item">
      				<a class="nav-link" href="#">Tủ gỗ</a>
    			</li>
    			<li class="nav-item">
      				<a class="nav-link" href="#">Móc treo,cây treo gỗ</a>
    			</li>
    			<li class="nav-item">
      				<a class="nav-link" href="#">Bàn Thờ gỗ</a>
    			</li>
		    <!-- Dropdown -->
		    <li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
		        Login
		      </a>
		      <div class="dropdown-menu">
		        <a class="dropdown-item" href="http://localhost:8080/web/dangnhap.php">Đăng Nhập</a>
		        <a class="dropdown-item" href="http://localhost:8080/web/themtaikhoan.php">Đăng Ký</a>
		      </div>
		    </li>
		  </ul>
  	</nav>
<!-- Thanh carousel Trượt -->
<div class="container" style="margin-top: 5px;" >
	<div id="demo" class="carousel slide" data-ride="carousel">
	 <!-- Indicators -->
	  <ul class="carousel-indicators">
	    <li data-target="#demo" data-slide-to="0" class="active"></li>
	    <li data-target="#demo" data-slide-to="1"></li>
	    <li data-target="#demo" data-slide-to="2"></li>
	  </ul>

	  <!-- The slideshow -->
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="https://furnibuy.com/wp-content/uploads/2020/08/bo-ban-an-4-ghe-go-soi-ha-noi-BA031.jpg" width="1200" height="600">
	    </div>
	    <div class="carousel-item">
	      <img src="https://topshare.vn/wp-content/uploads/2020/01/B%E1%BB%99-b%C3%A0n-gh%E1%BA%BF-g%E1%BB%97-h%C6%B0%C6%A1ng-sang-tr%E1%BB%8Dng.jpg" width="1200" height="600" >
	    </div>
	    <div class="carousel-item">
	      <img src="http://sofagiarehanoi.vn/wp-content/uploads/2017/10/sofa-go-goc-1-700x380.jpg" width="1200" height="600" >
	    </div>
	  </div>

	  <!-- Left and right controls -->
	  <a class="carousel-control-prev" href="#demo" data-slide="prev">
	    <span class="carousel-control-prev-icon"></span>
	  </a>
	  <a class="carousel-control-next" href="#demo" data-slide="next">
	    <span class="carousel-control-next-icon"></span>
	  </a>
</div>
<!-- Tạo bảng đẩy dữ liệu lên  -->
<div class="table" style="margin-top: 20px;"> 
		<div class="row" >
	<?php
	$query = 'select count(id) as number from sanpham';
	$result = select($query);
	$number = 0;
	if ($result !=null && count($result) > 0){
		$number = $result[0]['number'];
	}
	$pages = ceil($number/12);
	// Phân trang 
	$current_page = 1;
	$index = 0;
	if(isset($_GET['page'])){
		$current_page = $_GET['page'];
	}
	$index = ($current_page - 1)*12;

	$query = 'select * from sanpham limit '.$index.', 12';
	$result = select($query);
	foreach ($result as $sanpham) {
		echo '<div class="col-md-3">
				<img src="'.$sanpham['hinhanhsanpham'].'" width="200" height="200"  >
				<h6>'.$sanpham['tensanpham'].'<span class="badge badge-secondary">  New</span></h6>
				<p class="text-danger">'.$sanpham['giasanpham'].' VNĐ     <button class="btn btn-info btn-sm" >Mua hàng</button></p>

			</div>';

	}
	?>
		</div>
		<div class="row">
			<ul class="pagination">
		  		<?php
		  			for($i=1;$i<=$pages;$i++){
		  				echo '<li class="page-item"><a class="page-link" href="?page='.$i.'">'.$i.'</a></li>';
		  			}
		  		?>
			</ul>
		</div>
	</div>
	</div>
</div>
<footer class="container-fluid bg-4 text-center">
  <p>Design by Thang chay <a href="https://thangchay.zyrosite.com/?fbclid=IwAR2owJbV6ZqSk8s23Vq3EkRKEJJLBP2EJ7fnDc7jUgJfKlghUJOFcDhgr7c">www.Thangchay.com</a></p> 
</footer>
</body>
</html>