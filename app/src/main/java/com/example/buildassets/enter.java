package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class enter extends AppCompatActivity {
    long backPressedTime;
    Toast backToast;
    Button find1, find2, find3, find4, find5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find1 = findViewById(R.id.btn1);
        find2 = findViewById(R.id.btn2);
        find3 = findViewById(R.id.btn3);
        find4 = findViewById(R.id.btn4);
        find5 = findViewById(R.id.btn5);
        find1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(enter.this, basic.class);
                startActivity(intent1);
            }
        });
        find2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(enter.this, bank_returns.class);
                startActivity(intent2);
            }
        });
        find3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(enter.this, fundreturns.class);
                startActivity(intent3);
            }
        });
        find4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(enter.this, loanandemi.class);
                startActivity(intent4);
            }
        });
        find5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(enter.this, currencyconversion.class);
                startActivity(intent5);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings1){
            Intent intent6 = new Intent(enter.this, learn.class);
            startActivity(intent6);
        }
        if(id == R.id.action_settings2){
            Intent intent7 = new Intent(enter.this, aboutus.class);
            startActivity(intent7);
        }
        if(id == R.id.action_settings3){
            FirebaseAuth.getInstance().signOut();
            Intent intent8 = new Intent(enter.this, MainActivity.class);
            startActivity(intent8);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            finishAffinity();
        }
        else{
            backToast = Toast.makeText(getBaseContext(),"Press again to exit", Toast.LENGTH_LONG);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}