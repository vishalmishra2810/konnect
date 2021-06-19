package com.example.konnect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button callSignUp, login_button;
    ImageView imageView;
    TextView logoText, sloganText;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_login);

        callSignUp = findViewById (R.id.signUp);
        imageView = findViewById (R.id.logoImage);
        logoText = findViewById (R.id.logoName);
        sloganText = findViewById (R.id.slogan_name);
        username = findViewById (R.id.username);
        password = findViewById (R.id.password);
        login_button = findViewById (R.id.login_button);


        callSignUp.setOnClickListener (view -> {
          Intent intent = new Intent (Login.this,SignUp.class);


          Pair[] pairs = new Pair[7];

            pairs[0] = new Pair<View,String>(imageView,"logo_image");
            pairs[1] = new Pair<View,String>(logoText,"logo_text");
            pairs[2] = new Pair<View,String>(sloganText,"logo_desc");
            pairs[3] = new Pair<View,String>(username,"username_tran");
            pairs[4] = new Pair<View,String>(password,"password_tran");
            pairs[5] = new Pair<View,String>(login_button,"button_tran");
            pairs[6] = new Pair<View,String>(callSignUp,"login_signup_tran");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation (Login.this,pairs);
            startActivity (intent, options.toBundle ());
        });

    }
}