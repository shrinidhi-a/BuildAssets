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

public class MainActivity extends AppCompatActivity{
    TextView register,fp;
    EditText email, pass;
    Button btn;
    private FirebaseAuth mAuth;
    private ProgressBar pb;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        register = findViewById(R.id.textView65);
        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button4);
        fp = findViewById(R.id.textView66);
        pb = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, registeruser.class);
                startActivity(intent1);
            }
        });
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, forgotpassword.class);
                startActivity(intent3);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Please fill email", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                } else if (isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "Please fill pass", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                }
                else{
                    login();
                }
            }
        });
    }

    private void login() {
        String mail = email.getText().toString().trim();
        String pas = pass.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            email.setError("Please enter valid email");
            email.requestFocus();
            return;
        }
        if (pas.length() < 6) {
            pass.setError("Password should have more than 6 character");
            pass.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(mail, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); //if(user.isEmailVerified())
                if (task.isSuccessful()) {
                    if(user.isEmailVerified()) {
                        Intent intent2 = new Intent(MainActivity.this, enter.class);
                        startActivity(intent2);
                    } else {
                        Toast.makeText(MainActivity.this, "please verify your mail address", Toast.LENGTH_LONG).show();
                        pb.setVisibility(View.GONE);
                        Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent3);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "failed to login", Toast.LENGTH_LONG).show();
                    pb.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    protected void onStart(){ //mAuth.getCurrentUser() != null)  (user1.isEmailVerified())
        super.onStart();
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        if(mAuth.getCurrentUser() != null && user1.isEmailVerified()) {
                Intent intent4 = new Intent(MainActivity.this, enter.class);
                startActivity(intent4);
        }
        else{
            Toast.makeText(MainActivity.this, "Login to continue", Toast.LENGTH_LONG).show();
        }
    }
}