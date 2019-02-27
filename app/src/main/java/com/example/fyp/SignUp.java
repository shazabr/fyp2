package com.example.fyp;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {


    private EditText username, password, emailaddress;
    private Button signup;
    private TextView link;
    private FirebaseAuth firebaseauthentification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();

        //feeding back user information to the firebase database
       firebaseauthentification = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                String umail = emailaddress.getText().toString().trim();
                String upassword = password.getText().toString().trim();
                firebaseauthentification.createUserWithEmailAndPassword(umail, upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUp.this,"account has successfully been created!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, MainActivity.class));
                        }
                        else {
                            Toast.makeText(SignUp.this,"something went wrong, try again!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                }
            }
        });

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, MainActivity.class));

            }
        });
    }

    private void setupUIViews() {
        username = (EditText)findViewById(R.id.euser);
        password = (EditText)findViewById(R.id.epass);
        emailaddress = (EditText)findViewById(R.id.email);
        signup = (Button)findViewById(R.id.esignup);
        link = (TextView)findViewById(R.id.elink);
    }

    private Boolean validate(){
        Boolean result = false;
        String name = username.getText().toString();
        String pass = password.getText().toString();
        String mail = emailaddress.getText().toString();

        if(name.isEmpty() || pass.isEmpty() || mail.isEmpty()){
            Toast.makeText(this, "Please fill in your information!",
                    Toast.LENGTH_SHORT).show(); }
        else {
            result = true;

        }
        return result;
    }
}
