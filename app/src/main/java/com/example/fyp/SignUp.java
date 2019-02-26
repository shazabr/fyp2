package com.example.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText username, password, emailaddress;
    private Button signup;
    private TextView link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                  
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

        if(name.isEmpty() && pass.isEmpty() && mail.isEmpty()){
            Toast.makeText(this, "All information is required, plase complete any missing information",
                    Toast.LENGTH_SHORT).show(); }
                    else {
            result = true;

        }
return result;
    }
}
