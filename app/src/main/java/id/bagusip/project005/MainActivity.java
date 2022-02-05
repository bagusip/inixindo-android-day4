package id.bagusip.project005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_lihat_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(MainActivity.this, LihatDataActivity.class));

        btn_lihat_data = findViewById(R.id.btn_lihat_data);


    }
}