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

public class onetime extends AppCompatActivity {
    EditText la, ri;
    Button btn;
    TextView year,cg,cv;
    SeekBar time;
    int prog=5;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onetime);
        la = findViewById(R.id.editText1);
        ri = findViewById(R.id.editText2);
        cg = findViewById(R.id.editText3);
        cv = findViewById(R.id.editText5);
        year = findViewById(R.id.textView3);
        time = findViewById(R.id.seekBar5);
        btn = findViewById(R.id.button);
        time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                prog = seekBar.getProgress();
                year.setText(prog +" years");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                prog = seekBar.getProgress();
                year.setText(prog +" years");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                prog = seekBar.getProgress();
                year.setText(prog +" years");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(la)) {
                    Toast.makeText(onetime.this, "Please fill lumpsum amount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(onetime.this, onetime.class);
                }
                else if (isEmpty(ri)){
                    Toast.makeText(onetime.this, "Please fill Rate of interest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(onetime.this, onetime.class);
                }
                else {
                    String s1 = la.getText().toString();
                    String s2 = ri.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    if(a1 == 0){
                        Toast.makeText(onetime.this, "lumpsum amount cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a2 == 0){
                        Toast.makeText(onetime.this, "Rate of interest cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double f = a1*Math.pow((1+a2/100),prog);
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