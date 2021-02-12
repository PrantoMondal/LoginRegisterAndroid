package com.prantom.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname, textInputEditTextUsername, textInputEditTextPassword, textInputEditTextEmail;
    Button buttonSignup;
    TextView textviewLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextFullname = findViewById(R.id.textInputLayoutFullName);
        textInputEditTextUsername = findViewById(R.id.textInputLayoutUserName);
        textInputEditTextPassword = findViewById(R.id.textInputLayoutPass);
        textInputEditTextEmail = findViewById(R.id.textInputLayoutEmail);
        buttonSignup = findViewById(R.id.buttonSignUp);
        textviewLogin = findViewById(R.id.loginText);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname, username, password, email;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                username = String.valueOf(textInputEditTextEmail.getText());


                //Start ProgressBar first (Set visibility VISIBLE)
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[4];
                        field[0] = "fullname";
                        field[1] = "username";
                        field[2] = "password";
                        field[3] = "email";

                        //Creating array for data
                        String[] data = new String[4];
                        data[0] = "data-1";
                        data[1] = "data-2";
                        data[0] = "data-1";
                        data[1] = "data-2";
                        PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                //End ProgressBar (Set visibility to GONE)

                            }
                        }
            }
        });


                //End Write and Read data with URL
            }
        });

    }
}