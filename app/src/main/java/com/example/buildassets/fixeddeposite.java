package com.example.buildassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class fixeddeposite extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText la, ri;
    Button btn;
    TextView year,cg,cv;
    SeekBar time;
    int prog=5;
    int index = 0;
    String[] types = {"Monthly","Quarterly","HalfYearly","Annually"};
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixeddeposite);
        la = findViewById(R.id.editText1);
        ri = findViewById(R.id.editText2);
        cg = findViewById(R.id.editText3);
        cv = findViewById(R.id.editText5);
        year = findViewById(R.id.textView16);
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
        Spinner spin = (Spinner) findViewById(R.id.editText7);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, types);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    if (isEmpty(la)) {
                        Toast.makeText(fixeddeposite.this, "Please fill lumpsum amount", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(fixeddeposite.this, fixeddeposite.class);
                    }
                    else if (isEmpty(ri)){
                        Toast.makeText(fixeddeposite.this, "Please fill Rate of interest", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(fixeddeposite.this, fixeddeposite.class);
                    }
                    else {
                        String s1 = la.getText().toString();
                        String s2 = ri.getText().toString();
                        double a1 = Integer.parseInt(s1);
                        double a2 = Integer.parseInt(s2);
                        if(a1 == 0){
                            Toast.makeText(fixeddeposite.this, "lumpsum amount cannot be zero", Toast.LENGTH_LONG).show();
                        }
                        else if(a2 == 0){
                            Toast.makeText(fixeddeposite.this, "Rate of interest cannot be zero", Toast.LENGTH_LONG).show();
                        }
                        else {
                            double n = 12;
                            if(index==0){
                                n = 12;
                            }
                            else if(index == 1){
                                n = 4;
                            }
                            else if(index == 2){
                                n = 2;
                            }
                            else if(index == 3){
                                n = 1;
                            }
                            double r = a2/100;
                            double temp = (1+r/n);
                            double A = a1 * Math.pow(temp,(n*prog));
                            double I = A-a1;
                            String finalresult = new Double(String.format("%.2f",A)).toString();
                            String finalresult2 = new Double(String.format("%.2f",I)).toString();
                            cg.setText(finalresult2 +" Rs");
                            cv.setText(finalresult + " Rs");
                        }
                    }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        index = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "please choose frequency", Toast.LENGTH_SHORT).show();
    }
}