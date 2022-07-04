package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fundreturns extends AppCompatActivity {
    Button find1, find2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundreturns);
        find1 = findViewById(R.id.btn1);
        find2 = findViewById(R.id.btn2);
        find1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(fundreturns.this, onetime.class);
                startActivity(intent1);
            }
        });
        find2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(fundreturns.this, sip.class);
                startActivity(intent2);
            }
        });
    }
}