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

public class effectiveannualrate extends AppCompatActivity {
    EditText la, ri;
    Button btn;
    TextView cg;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effectiveannualrate);
        la = findViewById(R.id.editText1);
        ri = findViewById(R.id.editText2);
        cg = findViewById(R.id.editText3);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(la)) {
                    Toast.makeText(effectiveannualrate.this, "Please fill Nominal rate of return", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(effectiveannualrate.this, effectiveannualrate.class);
                }
                else if (isEmpty(ri)){
                    Toast.makeText(effectiveannualrate.this, "Please fill number of compounding", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(effectiveannualrate.this, effectiveannualrate.class);
                }
                else {
                    String s1 = la.getText().toString();
                    String s2 = ri.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    if(a1 == 0){
                        Toast.makeText(effectiveannualrate.this, "Nominal rate of return cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a2 == 0){
                        Toast.makeText(effectiveannualrate.this, "number of compounding cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double eff = (Math.pow(1+((a1/100)/a2),a2) - 1 ) * 100;
                        String finalresult = new Double(String.format("%.2f",eff)).toString();
                        cg.setText(finalresult +" %");
                    }
                }
            }
        });
    }
}