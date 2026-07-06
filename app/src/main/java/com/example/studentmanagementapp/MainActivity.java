package com.example.studentmanagementapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

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

            String name = etName.getText().toString().trim();
            String rollNo = etRollNo.getText().toString().trim();
            String department = etDepartment.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            DatabaseReference ref = FirebaseDatabase.getInstance(
                    "https://student-management-app-fd07a-default-rtdb.asia-southeast1.firebasedatabase.app/"
            ).getReference("Students");

            HashMap<String, String> student = new HashMap<>();
            student.put("name", name);
            student.put("rollNo", rollNo);
            student.put("department", department);
            student.put("phone", phone);

            ref.push().setValue(student)
                    .addOnSuccessListener(unused -> {
                        Toast.makeText(MainActivity.this,
                                "Student Saved Successfully!",
                                Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(MainActivity.this,
                                "Failed: " + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    });
        });
    }
}