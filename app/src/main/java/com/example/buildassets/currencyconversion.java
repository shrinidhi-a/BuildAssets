package com.example.buildassets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class currencyconversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText amt;
    TextView famt;
    Button btn;
    int index1 = 0;
    int index2 = 0;
    String[] countries = {"Rupees","Dollar","Pound","Euro","Kuwaiti dinar"};

    String[] city = {"Rupees","Dollar","Pound","Euro","Kuwaiti dinar"};

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencyconversion);
        amt = findViewById(R.id.editText3);
        famt = findViewById(R.id.editText4);
        btn = findViewById(R.id.button2);

        Spinner spin = (Spinner) findViewById(R.id.editText);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, countries);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

        Spinner spin2 = (Spinner) findViewById(R.id.editText2);
        ArrayAdapter<String> bb = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, city);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(bb);
        spin2.setOnItemSelectedListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(amt)) {
                        Toast.makeText(currencyconversion.this, "Please fill amount", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(currencyconversion.this, currencyconversion.class);
                }
                else {
                    String s = amt.getText().toString();
                    int a = Integer.parseInt(s);
                    if(index1 == 0)
                    {
                        if(index2 == 0){
                            famt.setText(a +" INR");
                        }
                        else if(index2 == 1){
                            famt.setText(String.format("%.2f",(a/78.25)) +" USD");
                        }
                        else if(index2 == 2){
                            famt.setText(String.format("%.2f",(a/95.97)) +" GBP");
                        }
                        else if(index2 == 3){
                            famt.setText(String.format("%.2f",(a/82.61)) +" EUR");
                        }
                        else if(index2 == 4){
                            famt.setText(String.format("%.2f",(a/255.28)) +" KWD");
                        }
                    }
                    else if(index1 == 1)
                    {
                        if(index2 == 0){
                            famt.setText(String.format("%.2f",(a/0.013))  +" INR");
                        }
                        else if(index2 == 1){
                            famt.setText(a +" USD");
                        }
                        else if(index2 == 2){
                            famt.setText(String.format("%.2f",(a/1.23)) +" GBP");
                        }
                        else if(index2 == 3){
                            famt.setText(String.format("%.2f",(a/1.06)) +" EUR");
                        }
                        else if(index2 == 4){
                            famt.setText(String.format("%.2f",(a/3.26)) +" KWD");
                        }
                    }
                    else if(index1 == 2)
                    {
                        if(index2 == 0){
                            famt.setText(String.format("%.2f",(a/0.010))  +" INR");
                        }
                        else if(index2 == 1){
                            famt.setText(String.format("%.2f",(a/0.82)) +" USD");
                        }
                        else if(index2 == 2){
                            famt.setText(a +" GBP");
                        }
                        else if(index2 == 3){
                            famt.setText(String.format("%.2f",(a/0.86)) +" EUR");
                        }
                        else if(index2 == 4){
                            famt.setText(String.format("%.2f",(a/2.66)) +" KWD");
                        }
                    }
                    else if(index1 == 3)
                    {
                        if(index2 == 0){
                            famt.setText(String.format("%.2f",(a/0.012))  +" INR");
                        }
                        else if(index2 == 1){
                            famt.setText(String.format("%.2f",(a/0.95)) +" USD");
                        }
                        else if(index2 == 2){
                            famt.setText(String.format("%.2f",(a/1.16)) +" GBP");
                        }
                        else if(index2 == 3){
                            famt.setText(a +" EUR");
                        }
                        else if(index2 == 4){
                            famt.setText(String.format("%.2f",(a/3.09)) +" KWD");
                        }
                    }
                    else if(index1 == 4)
                    {
                        if(index2 == 0){
                            famt.setText(String.format("%.2f",(a/0.0039)) +" INR");
                        }
                        else if(index2 == 1){
                            famt.setText(String.format("%.2f",(a/0.31)) +" USD");
                        }
                        else if(index2 == 2){
                            famt.setText(String.format("%.2f",(a/0.38)) +" GBP");
                        }
                        else if(index2 == 3){
                            famt.setText(String.format("%.2f",(a/0.32)) +" EUR");
                        }
                        else if(index2 == 4){
                            famt.setText(a +" KWD");
                        }
                    }
                }
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id ){
        Spinner spin = (Spinner)parent;
        Spinner spin2 = (Spinner)parent;
        if(spin.getId() == R.id.editText)
        {
            index1 = position;
        }
        if(spin2.getId() == R.id.editText2)
        {
            index2 = position;
        }

    }

    public void onNothingSelected(AdapterView<?> parent){
        Toast.makeText(this, "Choose currencies :", Toast.LENGTH_SHORT).show();
    }
}
