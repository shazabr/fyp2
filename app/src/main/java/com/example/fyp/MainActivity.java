package com.example.fyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private TextView test;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.eusername);
        password = (EditText) findViewById(R.id.epassword);

        test = (TextView) findViewById(R.id.etest);
        login = (Button) findViewById(R.id.elogin);


        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());

            }

        });

    }

    // adding a admin with specified username and password,
    // also created a "MainMenu" class for the second homepage that it will direct to
    // if the username and password match accordingly.

    private void validate(String userName, String userPassword){
        if ((userName == "admin") && (userPassword == "pass")) {
            Intent intent = new Intent(MainActivity.this, MainMenu.class);
            startActivity(intent);
        } else {
            test.setText("wrong password, try again");
        }
    }
}
