package id.bagusip.project005;

public class Konfigurasi {

    // url dimana web api berada
    public static final String URL_GET_ALL = "http://192.168.1.3/nasabah/tampilSemuaPgw.php";
    public static final String URL_GET_DETAIL = "http://192.168.1.3/nasabah/tampilPgw.php?id=";
    public static final String URL_ADD = "http://192.168.1.3/nasabah/tambahPgw.php";
    public static final String URL_UPDATE = "http://192.168.1.3/nasabah/updatePgw.php";
    public static final String URL_DELETE = "http://192.168.1.3/nasabah/hapusPgw.php";

    // munculkan key and value JSON yang muncul di browser
    public static final String KEY_NSB_ID = "id";
    public static final String KEY_NSB_NAMA = "nama";
    public static final String KEY_NSB_NOREK = "no_rekening";
    public static final String KEY_NSB_ALAMAT = "alamat";
    public static final String KEY_NSB_STATUS = "status";

    //flag JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_JSON_ID = "id";
    public static final String TAG_JSON_NAMA = "nama";
    public static final String TAG_JSON_NOREK = "no_rekening";
    public static final String TAG_JSON_ALAMAT = "alamat";
    public static final String TAG_JSON_status = "status";

    //variabel ID pegawai
    public static final String PGW_ID = "emp_id";

    //


}
