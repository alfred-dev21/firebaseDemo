package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText mail;
    EditText pass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void registerUser(View view) {
        String text_username, text_password, text_email;

        username = findViewById(R.id.user_username);
        mail = findViewById(R.id.user_email);
        pass = findViewById(R.id.user_password);

        text_username = username.getText().toString();
        text_email = mail.getText().toString();
        text_password = pass.getText().toString();

        boolean isValid = validateData(text_username, text_email, text_password);

        if (isValid){
            firebaseAuth.createUserWithEmailAndPassword(text_email, text_password)
                    .addOnCompleteListener(RegisterActivity.this, task -> {
                        if (task.isSuccessful()){
                            Toast.makeText(
                                    RegisterActivity.this,
                                    "User Successfully Registered",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(
                                    RegisterActivity.this,
                                    "Registration failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private boolean validateData(String username, String email, String password) {
        return !username.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }

    public void toLoginScreen(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}