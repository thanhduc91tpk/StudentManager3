package com.thanhduc91tpk.studentmanager3.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.thanhduc91tpk.studentmanager3.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtUserName,edtPassword;
    CheckBox chkRemember;
    Button btnLogin,btnReset;
    public static final String ACCOUNT_USER = "username";
    public static final String ACCOUNT_PASS = "password";
    public static final String ACCOUNT_STATUS = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControls();

        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = edtUserName.getText().toString();
               String password = edtPassword.getText().toString();

               if(username.equals("fpt")&&password.equals("123")){
                   Toast.makeText(LoginActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                   checkRemember(username,password,chkRemember.isChecked());
                   finish();
               }else{
                   Toast.makeText(LoginActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
               }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUserName.setText("");
                edtPassword.setText("");
            }
        });
    }

    private void addControls() {
        edtPassword = findViewById(R.id.edt_password);
        edtUserName = findViewById(R.id.edt_username);
        chkRemember = findViewById(R.id.chkPassword);
        btnLogin = findViewById(R.id.btn_login);
        btnReset = findViewById(R.id.btn_cancel);
    }

    public void checkRemember(String username,String password,boolean checkBox){
        SharedPreferences sharedPreferences = getSharedPreferences("ACCOUNT",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(checkBox == false){
            editor.clear();
        }
        else{
            editor.putString(ACCOUNT_USER,username);
            editor.putString(ACCOUNT_PASS,password);
            editor.putBoolean(ACCOUNT_STATUS,checkBox);
        }
        editor.commit();
    }
}