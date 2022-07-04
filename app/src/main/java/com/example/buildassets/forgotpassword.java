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
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
    EditText email;
    TextView register;
    Button btn;
    ProgressBar pb;
    private FirebaseAuth Auth;
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        email = findViewById(R.id.editTextTextEmailAddress);
        register = findViewById(R.id.textView65);
        btn = findViewById(R.id.button4);
        pb = findViewById(R.id.progressBar);
        Auth = FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(email)) {
                    Toast.makeText(forgotpassword.this, "Please fill email", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(forgotpassword.this, forgotpassword.class);
                }
                else{
                    resetpassword();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(forgotpassword.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }

    private void resetpassword() {
        String mail = email.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            email.setError("Please enter valid email");
            email.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        Auth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(forgotpassword.this,"Check your mail to reset password", Toast.LENGTH_LONG).show();
                    pb.setVisibility(View.GONE);
                    finish();
                }
                else{
                    Toast.makeText(forgotpassword.this,"something went wrong! Try again", Toast.LENGTH_LONG).show();
                    pb.setVisibility(View.GONE);
                }
            }
        });
    }
}