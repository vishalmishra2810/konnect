package com.example.konnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class SignUp extends AppCompatActivity {

    TextInputLayout regName, regUserName, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;
    FirebaseDatabase mDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//Hooks to all xml elements in activity_sign_up.xml
        regName = findViewById(R.id.reg_name);
        regUserName = findViewById(R.id.reg_userName);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_button);
        regToLoginBtn = findViewById(R.id.reg_toLogIn);
//Save data in FireBase on button click
        regBtn.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                mDatabase = FirebaseDatabase.getInstance ();
                reference = mDatabase.getReference ("Courses");


//Get all the values

                String name = regName.getEditText ().getText ().toString ();
                String username = regUserName.getEditText ().getText ().toString ();
                String email = regEmail.getEditText ().getText ().toString ();
                String phoneNo = regPhoneNo.getEditText ().getText ().toString ();
                String password = regPassword.getEditText ().getText ().toString ();


                UserHelperClass helperClass = new UserHelperClass (name, username, email, phoneNo, password);
                reference.child (name).setValue (helperClass);
//
            }
        });//Register Button method end
    }//onCreate Method End
}