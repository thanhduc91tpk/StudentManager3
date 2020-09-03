package com.thanhduc91tpk.studentmanager3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thanhduc91tpk.studentmanager3.UI.ClassManagerActivity;
import com.thanhduc91tpk.studentmanager3.UI.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private String strAccount;
    TextView txtAccount;
    Button btnClassActivity,btnStudentActivity;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();

        SharedPreferences sharedPreferences = getSharedPreferences("ACCOUNT",MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean(LoginActivity.ACCOUNT_STATUS,false);
        if(check == false){
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            strAccount = sharedPreferences.getString(LoginActivity.ACCOUNT_USER,"");
            txtAccount.setText("xin chao "+strAccount);
        }
        
        addEvents();

    }

    private void addEvents() {
        btnClassActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ClassManagerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        txtAccount = findViewById(R.id.txtUserName);
        btnClassActivity = findViewById(R.id.btn_class);
        btnStudentActivity = findViewById(R.id.btn_student);
    }

}