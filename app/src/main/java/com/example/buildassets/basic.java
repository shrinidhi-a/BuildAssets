package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class basic extends AppCompatActivity {
    Button find1, find2, find3, find4, find5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        find1 = findViewById(R.id.btn1);
        find2 = findViewById(R.id.btn2);
        find3 = findViewById(R.id.btn3);
        find4 = findViewById(R.id.btn4);
        find5 = findViewById(R.id.btn5);
        find1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(basic.this, finaltax.class);
                startActivity(intent1);
            }
        });
        find2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(basic.this, inflation.class);
                startActivity(intent2);
            }
        });
        find3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(basic.this, purchasingpower.class);
                startActivity(intent3);
            }
        });
        find4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(basic.this, doublingfactor.class);
                startActivity(intent4);
            }
        });
        find5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(basic.this, effectiveannualrate.class);
                startActivity(intent5);
            }
        });
    }
}