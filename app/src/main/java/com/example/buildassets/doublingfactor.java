package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class doublingfactor extends AppCompatActivity {
    EditText pa;
    Button btn;
    TextView fm;

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doublingfactor);
        pa = findViewById(R.id.editText2);
        fm = findViewById(R.id.editText5);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(pa)) {
                    Toast.makeText(doublingfactor.this, "Please fill Interest rate", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(doublingfactor.this, doublingfactor.class);
                } else {
                    String s1 = pa.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    if (a1 == 0) {
                        Toast.makeText(doublingfactor.this, "Interest rate cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double fa = 72 / a1;
                        double num = new Double(String.format("%.2f", fa));
                        double year = 0;
                        double month = 0;
                        num = num * 365;
                        while(num>365){
                            year = year + 1;
                            num = num-365;
                        }
                        while(num>30){
                            if(month<11) {
                                month = month + 1;
                            }
                            else{
                                year = year + 1;
                                month = 0;
                            }
                            num = num - 30;
                        }
                        int days = (int) num;
                        int imonth = (int) month;
                        int iyear = (int) year;
                        fm.setText(iyear +" years,  " +imonth +" months,  " +days +" days");
                    }
                }
            }
        });
    }
}