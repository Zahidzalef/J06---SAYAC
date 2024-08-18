package com.zahidiyigokler.a08_sayac;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.CountDownTimer;
import android.support.v4.app.*;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView);
        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Left : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_LONG).show();
                textView.setText("Finished!");
            }
        }.start();
    }
}