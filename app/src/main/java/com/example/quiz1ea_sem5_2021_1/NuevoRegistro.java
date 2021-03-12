package com.example.quiz1ea_sem5_2021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoRegistro extends AppCompatActivity implements View.OnClickListener {

    private EditText nameInput;
    private EditText idInput;
    private Button toNexoButton;
    Boolean isRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        toNexoButton = findViewById(R.id.toNexoButton);
        isRegistered = false;

        toNexoButton.setOnClickListener(
                v -> {
                    String name = nameInput.getText().toString();
                    String id = idInput.getText().toString();

                    SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);
                    String existId = preferences.getString("idNumber", "");

                    if (existId != null) {
                        String[] ids;
                        ids = existId.split(",");

                        for (int i = 0; i < ids.length; i++) {
                            if (ids[i].equals(ids)) {

                                isRegistered = true;
                                Toast.makeText(this, "El numero de identificacion ya fue regitrado",
                                        Toast.LENGTH_SHORT).show();
                                return;

                            } else {
                                isRegistered = false;
                            }
                        }

                        if (!isRegistered) {
                            preferences.edit().putString("nameUser",
                                    preferences.getString("nameUser","") + name).apply();

                            preferences.edit().putString("idNumber",
                                    preferences.getString("idNumber","") + name).apply();


                            Intent i2 = new Intent(this, NexoEpidemiologico.class);
                            startActivity(i2);
                            finish();
                        }
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {

    }
}