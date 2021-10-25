package com.android.roomdbinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.roomdbinjava.db.AppDatabase;
import com.android.roomdbinjava.db.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        final EditText namaInput =  findViewById(R.id.namaInput);
        final EditText alamatInput =  findViewById(R.id.alamatInput);
        Button saveButton =  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(namaInput.getText().toString(), alamatInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String nama, String alamat) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.name = nama;
        user.alamat = alamat;
        db.userDao().insertUser(user);

        finish();

    }
}