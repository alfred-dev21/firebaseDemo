package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.client_username);
        password = findViewById(R.id.client_password);
        auth = FirebaseAuth.getInstance();

    }

    public void toRegistration(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }

    public void loginUser(View view) {
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()){
            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> Toast.makeText(
                            LoginActivity.this,
                            "Login Successful",
                            Toast.LENGTH_SHORT).show()
                    );

            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }
    }
}