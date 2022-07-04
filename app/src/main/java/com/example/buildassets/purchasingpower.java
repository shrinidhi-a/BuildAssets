package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class purchasingpower extends AppCompatActivity {
    EditText pa, ir, ti;
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
        setContentView(R.layout.activity_purchasingpower);
        pa = findViewById(R.id.editText1);
        ir = findViewById(R.id.editText2);
        ti = findViewById(R.id.editText10);
        fm = findViewById(R.id.editText5);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(pa)) {
                    Toast.makeText(purchasingpower.this, "Please fill amount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(purchasingpower.this, purchasingpower.class);
                } else if (isEmpty(ir)) {
                    Toast.makeText(purchasingpower.this, "Please fill Inflation rate", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(purchasingpower.this, purchasingpower.class);
                } else if (isEmpty(ti)) {
                    Toast.makeText(purchasingpower.this, "Please fill time duration", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(purchasingpower.this, purchasingpower.class);
                } else {
                    String s1 = pa.getText().toString();
                    String s2 = ir.getText().toString();
                    String s3 = ti.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    int a3 = Integer.parseInt(s3);
                    if (a1 == 0) {
                        Toast.makeText(purchasingpower.this, "amount cannot be zero", Toast.LENGTH_LONG).show();
                    } else if (a2 == 0) {
                        Toast.makeText(purchasingpower.this, "inflation rate cannot be zero", Toast.LENGTH_LONG).show();
                    } else if (a3 == 0) {
                        Toast.makeText(purchasingpower.this, "time duration cannot be zero", Toast.LENGTH_LONG).show();
                    } else {
                        double fa = a1 / Math.pow((1 + (a2 / 100)), a3);
                        String finalresult = new Double(String.format("%.2f", fa)).toString();
                        fm.setText(finalresult + " Rs");
                    }
                }
            }
        });
    }
}