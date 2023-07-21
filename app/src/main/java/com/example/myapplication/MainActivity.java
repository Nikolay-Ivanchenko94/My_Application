package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView textView,textView2;
    private EditText editTextTextEmailAddress,editTextTextPassword;
    private Button button,button2;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);




    }

    public void enterData(View view) {
        String editTextEmail = editTextTextEmailAddress.getText().toString();
        String editTextPassword = editTextTextPassword.getText().toString();

        try {
            FileOutputStream fileOutput = openFileOutput("edit_email.txt", MODE_PRIVATE);
            fileOutput.write((editTextEmail +"."+editTextPassword).getBytes());
            fileOutput.close();

            editTextTextEmailAddress.setText("");
            editTextTextPassword.setText("");
            Toast.makeText(this, "Ви усішно ввелі дані",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            Toast.makeText(this,"Ви ввели неправильні дані",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }





    public void registerData(View view) {
        FileInputStream fileInput = null;
        try {
            fileInput = openFileInput("edit_email.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader reader = new InputStreamReader(fileInput);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String lines = "", result = "";
        while(true) {
            try {
                if (!((lines = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            result += lines;

        }


    }
}
