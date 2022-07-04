package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bank_returns extends AppCompatActivity {
    Button find1, find2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_returns);
        find1 = findViewById(R.id.btn1);
        find2 = findViewById(R.id.btn2);
        find1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(bank_returns.this, fixeddeposite.class);
                startActivity(intent1);
            }
        });
        find2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(bank_returns.this, recurringdeposite.class);
                startActivity(intent2);
            }
        });
    }
}