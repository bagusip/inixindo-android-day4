<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$id = $_POST['id'];
		$nama = $_POST['nama'];
		$no_rekening = $_POST['no_rekening'];
		$alamat = $_POST['alamat'];
		$status = $_POST['status'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_pegawai (nama,no_rekening,alamat,status) VALUES ('$nama','$no_rekening','$alamat'.'$status')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan nasabah';
		}else{
			echo 'Gagal Menambahkan nasabah';
		}
		
		mysqli_close($con);
	}
?>