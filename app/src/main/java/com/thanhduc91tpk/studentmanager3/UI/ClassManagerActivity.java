package com.thanhduc91tpk.studentmanager3.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.thanhduc91tpk.studentmanager3.DAO.ClassDAO;
import com.thanhduc91tpk.studentmanager3.R;
import com.thanhduc91tpk.studentmanager3.model.ClassObject;

public class ClassManagerActivity extends AppCompatActivity {
    EditText edtIdClass,edtNameClass;
    Button btnAddClass,btnUpdateClass,btnDelClass,btnReset;
    ListView lvClass;
    ClassDAO classDao;
    ArrayAdapter<ClassObject> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_manager);

        addControls();

        addEvents();
    }

    private void addEvents() {
        lvClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassObject classObject = classDao.getAll().get(position);
                edtIdClass.setText(classObject.getmId());
                edtNameClass.setText(classObject.getmName());
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtIdClass.setText("");
                edtNameClass.setText("");
            }
        });

        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = edtIdClass.getText().toString();
                String tenLop = edtNameClass.getText().toString();
                ClassObject classObject = new ClassObject(maLop,tenLop);
                int result = classDao.addClass(classObject);
                if(result == 1){
                    Toast.makeText(ClassManagerActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ClassManagerActivity.this, "them that bai", Toast.LENGTH_SHORT).show();
                }
                adapter = new ArrayAdapter<ClassObject>(ClassManagerActivity.this,android.R.layout.simple_list_item_1,classDao.getAll());
                lvClass.setAdapter(adapter);
            }
        });

        btnUpdateClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = edtIdClass.getText().toString();
                String tenLop = edtNameClass.getText().toString();
                ClassObject classObject = new ClassObject(maLop,tenLop);
                int result = classDao.update(classObject);
                if(result == 1){
                    Toast.makeText(ClassManagerActivity.this, "update thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ClassManagerActivity.this, "update that bai", Toast.LENGTH_SHORT).show();
                }
                adapter = new ArrayAdapter<ClassObject>(ClassManagerActivity.this,android.R.layout.simple_list_item_1,classDao.getAll());
                lvClass.setAdapter(adapter);
            }
        });

        btnDelClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = edtIdClass.getText().toString();
                String tenLop = edtNameClass.getText().toString();
                ClassObject classObject = new ClassObject(maLop,tenLop);
                int result = classDao.delClass(classObject.getmId());
                if(result == 1){
                    Toast.makeText(ClassManagerActivity.this, "xoa thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ClassManagerActivity.this, "xoa that bai", Toast.LENGTH_SHORT).show();
                }
                adapter = new ArrayAdapter<ClassObject>(ClassManagerActivity.this,android.R.layout.simple_list_item_1,classDao.getAll());
                lvClass.setAdapter(adapter);
            }
        });
    }

    private void addControls() {
        edtIdClass = findViewById(R.id.edt_id_class);
        edtNameClass = findViewById(R.id.edt_name_class);
        btnAddClass = findViewById(R.id.btn_save_class);
        btnDelClass = findViewById(R.id.btn_del_class);
        btnReset = findViewById(R.id.btn_cancel_class);
        btnUpdateClass = findViewById(R.id.btn_update_class);
        lvClass = findViewById(R.id.lvClass);

        classDao = new ClassDAO(ClassManagerActivity.this);

        adapter = new ArrayAdapter<ClassObject>(ClassManagerActivity.this,android.R.layout.simple_list_item_1,classDao.getAll());
        lvClass.setAdapter(adapter);
    }
}