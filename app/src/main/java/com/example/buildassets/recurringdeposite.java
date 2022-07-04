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

public class recurringdeposite extends AppCompatActivity {
    EditText ia, ri;
    Button btn;
    TextView cg,cv,year;
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
        setContentView(R.layout.activity_recurringdeposite);
        ia = findViewById(R.id.editText1);
        ri = findViewById(R.id.editText2);
        cg = findViewById(R.id.editText3);
        cv = findViewById(R.id.editText5);
        year = findViewById(R.id.textView18);
        btn = findViewById(R.id.button);
        time = findViewById(R.id.seekBar);
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
                if (isEmpty(ia)) {
                    Toast.makeText(recurringdeposite.this, "Please fill Investment amount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(recurringdeposite.this, sip.class);
                }
                else if (isEmpty(ri)){
                    Toast.makeText(recurringdeposite.this, "Please fill Rate of interest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(recurringdeposite.this, sip.class);
                }
                else {
                    String s1 = ia.getText().toString();
                    String s2 = ri.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    if(a1 == 0){
                        Toast.makeText(recurringdeposite.this, "Investment amount cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a2 == 0){
                        Toast.makeText(recurringdeposite.this, "Rate of interest cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double n = prog * 4;
                        double a = a1 * n + a1 * ((n * (n + 1)) / 2) * (a2 / 100) * (1 / 12.0);
                        double g = a - (a1*n);
                        String finalresult = new Double(String.format("%.2f",a)).toString();
                        String finalresult2 = new Double(String.format("%.2f",g)).toString();
                        cg.setText(finalresult2 +" Rs");
                        cv.setText(finalresult + " Rs");
                    }
                }
            }
        });
    }
}