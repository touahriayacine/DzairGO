package com.example.dzairgo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView eye ;
    EditText psw;
    int psw_visible = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eye= (ImageView) findViewById(R.id.eye_icon);
        psw = (EditText) findViewById(R.id.psw_edittext);

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
}