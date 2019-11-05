package com.example.lukaqutateladze_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText name;
    EditText pass;
    EditText pass2;
    RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.editText);
        name = (EditText)findViewById(R.id.editText2);
        pass = (EditText)findViewById(R.id.editText3);
        pass2 = (EditText)findViewById(R.id.editText4);
        RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroup);

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


    public void onClick(View v){

        String alertText = " ";
        Boolean isValid = true;

        String emailText = email.getText().toString();
        String names = name.getText().toString();
        String password = pass.getText().toString();
        String password2 = pass2.getText().toString();
//        String genderText = gender.toString();


        if (emailText.isEmpty()){
            isValid = false;
            alertText += "sheavset email veli";
        }
        else if (!this.isValidEmail(emailText)) {
            isValid = false;
            alertText += "E-mail ar aris validuri";
        }
        if (names.isEmpty()){
            isValid = false;
            alertText += "sheavset name veli";
        }
        if (password.isEmpty()){
            isValid = false;
            alertText += "sheavset password veli";
        }
        else if (!this.isValidPassword(password)) {
            isValid = false;
            alertText += "paroli unda shedgebodes minimum 8 simbolosgan da sheicavdes 1 cifrs da 1 did simbolos mainc ";
        }
        if (password2.isEmpty()){
            isValid = false;
            alertText += "sheavset password2 veli";
        }
        if (emailText.isEmpty()){
            isValid = false;
            alertText += "sheavset email veli";
        }
//        else if(!pass.equals(pass2)){
//            isValid = false;
//            alertText += "parolebi ar emtxveva ertmanets";
//        }
        if (isValid){
            Intent newActivity = new Intent(MainActivity.this , login.class);
            startActivity(newActivity);
        }
        else{
//            alertText += "error";
            Toast.makeText(this, alertText, Toast.LENGTH_SHORT).show();
        }


    }

}
