package com.example.shan.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.shan.wallet.Misc.BaseActivity;

public class RegisterActivity extends BaseActivity {

//    UserDatabaseHelper myDb;
//    User user = new User;
//
//
//    EditText editUsername;
//    EditText editName;
//    EditText editSurname;
//    EditText editPassword;
//    Spinner editGender;
//    EditText editEmail;
//    Button btnRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.top_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("Register");

//
        // ODWOLANIE DO KLASY UDPATUJACEJ BAE DANYCH
//        myDb = new UserDatabaseHelper(this);
//

        //POBRANIE DANYCH Z EDITTEXT'ÓW
//        editUsername = (EditText) findViewById(R.id.RegisterUsername);
//        editName = (EditText) findViewById(R.id.RegisterName);
//        editSurname = (EditText) findViewById(R.id.RegisterSurname);
//        editPassword = (EditText) findViewById(R.id.RegisterPassword);
//        editGender = (Spinner) findViewById(R.id.RegisterSpinner);
//        editEmail  = (EditText) findViewById(R.id.RegisterEmail);
//
//        btnRegister = (Button) findViewById(R.id.buttonRegisterUser);
//
//        user.setUsername(editUsername.getText().toString());
//        user.setName(editName.getText().toString());
//        user.setSurname(editSurname.getText().toString());
//        user.setPassword(editPassword.getText().toString());
//        user.setGender(true);
//        user.setEmail(editEmail.getText().toString());

    }

//      PRZYCISK REGISTER POWINIEN BRAC DANE Z EDITTEXT'ÓW I TWORZYC NOWEGO USERA W LOKALNEJ BAZIE
//    public void registerUser(){
//        btnRegister.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isInserted = myDb.RegisterUser(user);
//
//                        if(isInserted==true)
//                            Toast.makeText(getApplicationContext(),"OK", Toast.LENGTH_SHORT);
//                        else
//                            Toast.makeText(getApplicationContext(),"FAIL", Toast.LENGTH_SHORT);
//
//                    }
//                }
//        );
//    }


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_register;
    }
}

