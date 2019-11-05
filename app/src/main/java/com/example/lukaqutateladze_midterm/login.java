package com.example.lukaqutateladze_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    EditText email_log;
    EditText password_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_log = (EditText)findViewById(R.id.email_log);
        password_log = (EditText)findViewById(R.id.password_log);
    }
    protected boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
    }

    public void onClick2(View v){
        String alertText = " ";
        Boolean isValid = true;

        String emailText = email_log.getText().toString();
        String password = password_log.getText().toString();

        if (emailText.isEmpty()){
            isValid = false;
            alertText += "sheavset email veli";
        }
        else if (!this.isValidEmail(emailText)) {
            isValid = false;
            alertText += "E-mail ar aris validuri";
        }
        if (password.isEmpty()){
            isValid = false;
            alertText += "sheavset password veli";
        }
        else if (!this.isValidPassword(password)) {
            isValid = false;
            alertText += "paroli unda shedgebodes minimum 8 simbolosgan da sheicavdes 1 cifrs da 1 did simbolos mainc ";
        }
        if (isValid){
            Intent newActivity = new Intent(login.this , contact.class);
            startActivity(newActivity);
        }
        else{
//            alertText += "error";
            Toast.makeText(this, alertText, Toast.LENGTH_SHORT).show();
        }

    }
}
