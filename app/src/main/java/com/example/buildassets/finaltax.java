package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class finaltax extends AppCompatActivity {
    EditText la, ri, ty, rt;
    Button btn;
    TextView cg,cv;
    int prog=5;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaltax);
        la = findViewById(R.id.editText1);
        ri = findViewById(R.id.editText2);
        cg = findViewById(R.id.editText3);
        cv = findViewById(R.id.editText5);
        ty = findViewById(R.id.editText8);
        rt = findViewById(R.id.editText9);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(la)) {
                    Toast.makeText(finaltax.this, "Please fill lumpsum amount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(finaltax.this, finaltax.class);
                }
                else if (isEmpty(ri)){
                    Toast.makeText(finaltax.this, "Please fill Rate of interest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(finaltax.this, finaltax.class);
                }
                else if (isEmpty(ty)){
                    Toast.makeText(finaltax.this, "Please fill Time duration", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(finaltax.this, finaltax.class);
                }
                else if (isEmpty(rt)){
                    Toast.makeText(finaltax.this, "Please fill tax rate", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(finaltax.this, finaltax.class);
                }
                else {
                    String s1 = la.getText().toString();
                    String s2 = ri.getText().toString();
                    String s3 = ty.getText().toString();
                    String s4 = rt.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    int a3 = Integer.parseInt(s3);
                    double a4 = Integer.parseInt(s4);
                    prog = a3;
                    if(a1 == 0){
                        Toast.makeText(finaltax.this, "lumpsum amount cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a2 == 0){
                        Toast.makeText(finaltax.this, "Rate of interest cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a3 == 0){
                        Toast.makeText(finaltax.this, "Time duration cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a4 == 0){
                        Toast.makeText(finaltax.this, "tax rate cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double z = a2 - (a2*(a4/100));
                        double f = a1*Math.pow((1+z/100),prog);
                        double ff = f - a1;
                        String finalresult = new Double(String.format("%.2f",f)).toString();
                        String finalresult2 = new Double(String.format("%.2f",ff)).toString();
                        cg.setText(finalresult2 +" Rs");
                        cv.setText(finalresult + " Rs");
                    }
                }
            }
        });
    }
}