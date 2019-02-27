package com.example.fyp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private TextView test;
    private Button login;
    private TextView signup;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.eusername);
        password = (EditText) findViewById(R.id.epassword);

        test = (TextView) findViewById(R.id.etest);
        login = (Button) findViewById(R.id.elogin);
        signup = (TextView) findViewById(R.id.esignup);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser(); // getting current users, checking if entered account already exists
        if (user !=null ) {
            finish();
            startActivity(new Intent(MainActivity.this, HomeScreen.class));
        }


        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());

            }

        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });
    }

    // adding a admin with specified username and password,
    // also created a "MainMenu" class for the second homepage that it will direct to
    // if the username and password match accordingly.

    private void validate(String userName, String userPassword){

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()) {
    startActivity(new Intent(MainActivity.this, HomeScreen.class));

}
else {
    Toast.makeText(MainActivity.this, "Couldn't find your Notebook Account", Toast.LENGTH_SHORT).show();
}
            }
        });

        if ((userName.equals("admin")) && (userPassword.equals("pass"))) {
            Intent intent = new Intent(MainActivity.this, MainMenu.class);
            startActivity(intent);
        }
    }
}
