<?php

$host = "localhost";
$user = "root";
$pass = "";
$db = "sobatlaptop";

$con = mysqli_connect($host,$user,$pass,$db);

$query = "select * from data_laptop;";

$result = mysqli_query($con, $query);
$response = array($result);

while ($row = mysqli_fetch_array($result)){
	array_push($response,array('tipe_laptop'=>$row[0],'merk'=>$row[1],'jenis'=>$row[2],'harga'=>$row[3],'url_image'=>$row[4]));
}
mysqli_close($con);

echo json_encode(array('server_response'=>$response));
?>