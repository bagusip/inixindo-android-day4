<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$nama = $_POST['nama'];
		$no_rekening = $_POST['no_rekening'];
		$alamat = $_POST['alamat'];
		$status = $_POST['status'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE nasabah SET nama = '$nama', no_rekening = '$no_rekening', alamat = '$alamat', status = '$status' WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}
		
		mysqli_close($con);
	}
?>