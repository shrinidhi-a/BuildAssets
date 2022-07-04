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

public class loanandemi extends AppCompatActivity {
    EditText pa, rp;
    Button btn;
    TextView year,emi;
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
        setContentView(R.layout.activity_loanandemi);
        pa = findViewById(R.id.editText1);
        rp = findViewById(R.id.editText2);
        emi = findViewById(R.id.editText3);
        btn = findViewById(R.id.button);
        year = findViewById(R.id.textView3);
        time = findViewById(R.id.seekBar5);
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
                if (isEmpty(pa)) {
                    Toast.makeText(loanandemi.this, "Please fill Principle amount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(loanandemi.this, loanandemi.class);
                }
                else if (isEmpty(rp)){
                    Toast.makeText(loanandemi.this, "Please fill Rate of payment", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(loanandemi.this, loanandemi.class);
                }
                else {
                    String s1 = pa.getText().toString();
                    String s2 = rp.getText().toString();
                    double a1 = Integer.parseInt(s1);
                    double a2 = Integer.parseInt(s2);
                    if(a1 == 0){
                        Toast.makeText(loanandemi.this, "Principle amount cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else if(a2 == 0){
                        Toast.makeText(loanandemi.this, "Rate of payment cannot be zero", Toast.LENGTH_LONG).show();
                    }
                    else {
                        a2 = a2 / (12 * 100);
                        prog = prog * 12;
                        double emid = (a1 * a2 * Math.pow(1 + a2, prog)) / (Math.pow(1 + a2, prog) - 1);
                        String finalresult = new Double(String.format("%.2f",emid)).toString();
                        emi.setText(finalresult + " Rs");
                    }
                }
            }
        });
    }
}