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

public class sip extends AppCompatActivity {
    EditText ia, ri, tp;
    Button btn;
    TextView cg,cv;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sip);
        ia = findViewById(R.id.editText1);
        ri = findViewById(R.id.editText2);
        tp = findViewById(R.id.editText6);
        cg = findViewById(R.id.editText3);
        cv = findViewById(R.id.editText5);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(ia)) {
                    Toast.makeText(sip.this, "Please fill Investment amount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(sip.this, sip.class);
                }
                else if (isEmpty(ri)){
                    Toast.makeText(sip.this, "Please fill Rate of interest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(sip.this, sip.class);
                }
                else if (isEmpty(tp)){
                    Toast.makeText(sip.this, "Please fill Time period", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(sip.this, sip.class);
                }
                else {
                    String s1 = ia.getText().toString();
                    String s2 = ri.getText().toString();
                    String s3 = tp.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    double a3 = Integer.parseInt(s3);
                    if(a1 == 0){
                        Toast.makeText(sip.this, "Investment amount cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a2 == 0){
                        Toast.makeText(sip.this, "Rate of interest cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a3 == 0){
                        Toast.makeText(sip.this, "Time period cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double mr = a2/12/100;
                        double mo = a3*12;
                        double fv = a1 * (Math.pow(1 + mr, mo) - 1) / mr;
                        double f = fv - (a1*mo);
                        String finalresult = new Double(String.format("%.2f",fv)).toString();
                        String finalresult2 = new Double(String.format("%.2f",f)).toString();
                        cg.setText(finalresult2 +" Rs");
                        cv.setText(finalresult + " Rs");
                    }
                }
            }
        });
    }
}