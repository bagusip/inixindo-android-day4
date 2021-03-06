package id.bagusip.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatDataActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView list_view;
    private String JSON_STRING;

    private ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // penanganan list view
        list_view = findViewById(R.id.list_view);
        list_view.setOnItemClickListener(this);

        // method untuk ambil data JSON
        getJSON();
    }


    private void getJSON() {
        // bantuan dari class AsyncTask
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDataActivity.this,
                        "Mengambil Data", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                try{
                    Thread.sleep(10000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_ALL);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                JSON_STRING = message;
                Log.d("DATA_JSON: ", JSON_STRING);

                // menampilkan data dalam bentuk list view
                displayAllData();
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void displayAllData() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            Log.d("DATA_JSON: ", JSON_STRING);

            for (int i = 0; i < result.length(); i++) {
                JSONObject object = result.getJSONObject(i);
                String id = object.getString(Konfigurasi.TAG_JSON_ID);
                String nama = object.getString(Konfigurasi.TAG_JSON_NAMA);
                String no_rekening = object.getString(Konfigurasi.TAG_JSON_NOREK);

                HashMap<String, String> nasabah = new HashMap<>();
                nasabah.put(Konfigurasi.TAG_JSON_ID, id);
                nasabah.put(Konfigurasi.TAG_JSON_NAMA, nama);
                nasabah.put(Konfigurasi.TAG_JSON_NOREK, no_rekening);
                // ubah format json menjadi array list
                list.add(nasabah);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // adapter untuk meletakan array list kedalam list view
        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(), list,
                R.layout.activity_list_item,
                new String[]{Konfigurasi.TAG_JSON_ID, Konfigurasi.TAG_JSON_NAMA, Konfigurasi.TAG_JSON_NOREK},
                new int[]{R.id.txt_id, R.id.txt_name, R.id.txt_norekening}
        );
        list_view.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent myIntent = new Intent(LihatDataActivity.this, LihatDetailDataActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String pgwId = map.get(Konfigurasi.TAG_JSON_ID).toString();
        myIntent.putExtra(Konfigurasi.PGW_ID,pgwId);
        startActivity(myIntent);
    }

    // agar back button bisa bekeja
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}