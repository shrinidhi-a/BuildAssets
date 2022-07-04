package com.example.buildassets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class registeruser extends AppCompatActivity {
    EditText name, age, salary, email, pass;
    TextView au, fp;
    Button btn;
    ProgressBar pb;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editTextTextPersonName2);
        age =  findViewById(R.id.editTextTextPersonName3);
        salary = findViewById(R.id.editTextTextPersonName4);
        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        pb = findViewById(R.id.progressBar2);
        au = findViewById(R.id.textView65);
        fp = findViewById(R.id.textView66);
        btn = findViewById(R.id.button4);
        au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(registeruser.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(name)) {
                    Toast.makeText(registeruser.this, "Please fill name", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registeruser.this, registeruser.class);
                } else if (isEmpty(age)) {
                    Toast.makeText(registeruser.this, "Please fill age", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registeruser.this, registeruser.class);
                } else if (isEmpty(salary)) {
                    Toast.makeText(registeruser.this, "Please fill salary", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registeruser.this, registeruser.class);
                } else if (isEmpty(email)) {
                    Toast.makeText(registeruser.this, "Please fill email", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registeruser.this, registeruser.class);
                } else if (isEmpty(pass)) {
                    Toast.makeText(registeruser.this, "Please fill pass", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registeruser.this, registeruser.class);
                }
                else{
                        register();
                }
            }
        });
    }

    private void register() {
        String mail = email.getText().toString().trim();
        String na = name.getText().toString().trim();
        String ag = age.getText().toString().trim();
        String sa = salary.getText().toString().trim();
        String pas = pass.getText().toString().trim();
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Please enter valid email");
            email.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail,pas)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(na, ag, sa, mail);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                                    Toast.makeText(registeruser.this,"Check your mail to verify your mail address", Toast.LENGTH_LONG).show();
                                                    user.sendEmailVerification();
                                                    pb.setVisibility(View.GONE);
                                                    finish();
                                            }
                                            else{
                                                Toast.makeText(registeruser.this,"User registration failed", Toast.LENGTH_LONG).show();
                                                pb.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }
                        else{
                            Toast.makeText(registeruser.this,"User registration failed", Toast.LENGTH_LONG).show();
                            pb.setVisibility(View.GONE);
                        }
                    }
                });

    }
}