package com.example.customview_09_01_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Title_Icon mtitleicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtitleicon = findViewById(R.id.titile_Icon);

        mtitleicon.setOnClickIcon(new OnListenerClick() {
            @Override
            public void onClickIcon() {
                Toast.makeText(MainActivity.this, "Icon", Toast.LENGTH_SHORT).show();
            }
        });

        


    }
}
