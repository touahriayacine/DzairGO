package com.example.dzairgo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dzairgo.R;

public class LoginActivity extends AppCompatActivity {

    ImageView eye ;
    EditText psw;
    TextView signupLink;
    Button connectBtn;
    int psw_visible = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        eye= (ImageView) findViewById(R.id.eye_icon);
        psw = (EditText) findViewById(R.id.psw_edittext);
        signupLink= (TextView) findViewById(R.id.signup_link);
        connectBtn = (Button) findViewById(R.id.connecter_btn);
        configEye(eye);
        configSignUpLink(signupLink);
        configConnectBtn();
    }

    private void configEye(ImageView eye){
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(psw_visible == -1){
                    psw.setTransformationMethod(null);
                    psw.setInputType(InputType.TYPE_CLASS_TEXT);
                    psw_visible = 1;
                }else{
                    psw.setTransformationMethod(new PasswordTransformationMethod());
                    psw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    psw_visible = -1;
                }
            }
        });
    }
    private void configSignUpLink(TextView signupLink){
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext() , SignupActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
    private void configConnectBtn(){
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext() , MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
}