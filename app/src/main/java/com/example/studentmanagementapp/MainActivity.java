package com.example.studentmanagementapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etRollNo, etDepartment, etPhone;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etRollNo = findViewById(R.id.etRollNo);
        etDepartment = findViewById(R.id.etDepartment);
        etPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String rollNo = etRollNo.getText().toString();
            String department = etDepartment.getText().toString();
            String phone = etPhone.getText().toString();

            Toast.makeText(MainActivity.this,
                    "Student Saved Successfully!",
                    Toast.LENGTH_SHORT).show();
        });
    }
}