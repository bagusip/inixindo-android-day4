package id.bagusip.project005;

public class Konfigurasi {

    // url dimana web api berada
    public static final String URL_GET_ALL = "http://192.168.1.3/pegawai/tampilSemuaPgw.php";
    public static final String URL_GET_DETAIL = "http://192.168.1.3/pegawai/tampilPgw.php?id=";
    public static final String URL_ADD = "http://192.168.1.3/pegawai/tambahPgw.php";
    public static final String URL_UPDATE = "http://192.168.1.3/pegawai/updatePgw.php";
    public static final String URL_DELETE = "http://192.168.1.3/pegawai/hapusPgw.php";

    // munculkan key and value JSON yang muncul di browser
    public static final String KEY_PGW_ID = "id";
    public static final String KEY_PGW_NAMA = "nama";
    public static final String KEY_PGW_JABATAN = "dsg";
    public static final String KEY_PGW_GAJI = "gaji ";

    //flag JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_JSON_ID = "id";
    public static final String TAG_JSON_NAMA = "name";
    public static final String TAG_JSON_JABATAN = "desg";
    public static final String TAG_JSON_GAJI = "salary";

    //variabel ID pegawai
    public static final String PGW_ID = "emp_id";

    //


}
