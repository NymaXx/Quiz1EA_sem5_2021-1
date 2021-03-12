package com.example.quiz1ea_sem5_2021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoRegistro extends AppCompatActivity implements View.OnClickListener {

    private EditText nameInput;
    private EditText idInput;
    private Button toNexoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        toNexoButton = findViewById(R.id.toNexoButton);

        toNexoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.toNexoButton:

                String name =nameInput.getText().toString();
                String id = idInput.getText().toString();

                Intent i2 = new Intent(this,NexoEpidemiologico.class);
                startActivity(i2);

                SharedPreferences preferences = getSharedPreferences("id",MODE_PRIVATE);
                preferences.edit().putString("name", name).apply();

                break;
            default:

        }

    }


}