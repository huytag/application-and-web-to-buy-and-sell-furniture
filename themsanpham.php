<?php
	include "connect.php";
	
// 	$ten = 'Ghế gỗ ngồi làm việc đẹp rẻ phù hợp mọi không gian';
// 	$gia  = '280000 ';
// 	$hinh = 'https://thuongthuong.vn/upload_images/images/ghe-go-ngoi-lam-viec%20(1).jpg';
// 	$mota  = 'Ghế gỗ ngồi làm việc thông minh ở tính đa zi năng của nó, có nghĩa là vai trò của nó không chỉ là ghế ngồi làm việc văn phòng mà có thể tích hợp mọi việc sử dụng đến ghế.
// Ghế gỗ sồi là sản phẩm ghế gỗ ngồi làm việc chất lượng cao. Như bạn đã biết về chất liệu gỗ này, đặc tính cứng, chắc nặng và không bị hư hại do mối mọt, đây sẽ là một sự lựa chọn kiên cố và chắc chắn nhất cho bạn. Giá ghế  gỗ ngồi làm việc này chỉ với 400.000 đồng tại Thưởng Thưởng';
// 	$idsp = '2';

	$ten = $_POST['ten'];
	$gia  = $_POST['gia'];
	$hinh = $_POST['hinh'];
	$mota  = $_POST['mota'];
	$idsp = $_POST['idsp'];
	if(strlen($ten) > 0  && strlen($gia) && strlen($hinh) > 0 && strlen($mota) > 0 && strlen($idsp) > 0){
	// Câu SQL Insert
	$sql = "INSERT INTO sanpham (id,tensanpham,giasanpham,hinhanhsanpham,motasanpham,idsanpham) 
	        VALUES (null, '$ten', '$gia', '$hinh','$mota','$idsp')";
	// Thực hiện thêm record
	if ($conn->query($sql) === TRUE) {
		$id_donhang = $conn->insert_id;
	    echo $id_donhang;
	} else {
	    echo "Lỗi: " . $sql . "<br>" . $conn->error;
	}
	 
	// Ngắt kết nối
	$conn->close();
	}
?>