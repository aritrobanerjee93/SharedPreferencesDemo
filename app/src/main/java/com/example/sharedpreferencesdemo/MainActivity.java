package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String REGEX_STORE = "RegexStore";

    private SharedPreferences sharedPreferences;
    private Context mContext;
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        name = findViewById(R.id.main_name_et);
        email = findViewById(R.id.main_email_et);
        phone = findViewById(R.id.main_phone_et);
        age = findViewById(R.id.main_age_et);
    }

    public void onSubmitPressed(View view){
        sharedPreferences = mContext.getSharedPreferences(REGEX_STORE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name",name.getText().toString());
        editor.putString("email",email.getText().toString());
        editor.putString("phone",phone.getText().toString());
        String ageAsString = age.getText().toString();
        if(!ageAsString.equalsIgnoreCase(""))
        editor.putInt("age", Integer.parseInt(age.getText().toString()));

        editor.apply();

        Intent intent = new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}
