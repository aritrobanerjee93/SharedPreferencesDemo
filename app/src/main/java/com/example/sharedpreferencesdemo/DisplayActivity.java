package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView age;
    private SharedPreferences sharedPreferences;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        context = this;
        sharedPreferences = context.getSharedPreferences(MainActivity.REGEX_STORE,Context.MODE_PRIVATE);

        name = findViewById(R.id.display_name_tv);
        email = findViewById(R.id.display_email_tv);
        phone = findViewById(R.id.display_phone_tv);
        age = findViewById(R.id.display_age_tv);

        name.setText("Your Name Is " + sharedPreferences.getString("name",null));
        email.setText("Your Email Is " +  sharedPreferences.getString("email",null));
        phone.setText("Your Phone Number is " + sharedPreferences.getString("phone",null));
        age.setText("Your Age Is " + sharedPreferences.getInt("age",0));
    }
}
