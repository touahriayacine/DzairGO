package com.example.dzairgo;

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

public class SignupActivity extends AppCompatActivity {
    ImageView eye1 ;
    ImageView eye2 ;
    EditText psw1;
    EditText psw2;
    TextView signinLink;
    Button commencerBtn;
    int psw_visible_1 = -1;
    int psw_visible_2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        eye1= (ImageView) findViewById(R.id.eye_icon);
        eye2= (ImageView) findViewById(R.id.confirm_eye_icon);
        psw1 = (EditText) findViewById(R.id.psw_edittext);
        psw2 = (EditText) findViewById(R.id.confirm_psw_edittext);
        signinLink= (TextView) findViewById(R.id.signin_link);
        commencerBtn = (Button) findViewById(R.id.commencer_btn);
        configEye1(eye1);
        configEye2(eye2);
        configSignInLink(signinLink);
        configCommencerBtn();
    }
    private void configEye1(ImageView eye1){
        eye1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(psw_visible_1 == -1){
                    psw1.setTransformationMethod(null);
                    psw1.setInputType(InputType.TYPE_CLASS_TEXT);
                    psw_visible_1 = 1;
                }else{
                    psw1.setTransformationMethod(new PasswordTransformationMethod());
                    psw1.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    psw_visible_1 = -1;
                }
            }
        });
    }
    private void configEye2(ImageView eye2){
        eye2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(psw_visible_2 == -1){
                    psw2.setTransformationMethod(null);
                    psw2.setInputType(InputType.TYPE_CLASS_TEXT);
                    psw_visible_2 = 1;
                }else{
                    psw2.setTransformationMethod(new PasswordTransformationMethod());
                    psw2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    psw_visible_2 = -1;
                }
            }
        });
    }
    private void configSignInLink(TextView signinLink){
        signinLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext() , LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
    private void configCommencerBtn(){
        commencerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext() , MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
}