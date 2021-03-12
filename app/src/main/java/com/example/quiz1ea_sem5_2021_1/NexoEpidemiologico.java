package com.example.quiz1ea_sem5_2021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class NexoEpidemiologico extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private CheckBox checkNinguno;
    private Button toSintomasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_epidemiologico);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        checkNinguno = findViewById(R.id.checkNinguno);
        toSintomasButton = findViewById(R.id.toSintomasButton);

        checkNinguno.setOnCheckedChangeListener(this);

        toSintomasButton.setOnClickListener(
                v-> {
                    int points = 0;

                    if(!(checkNinguno.isChecked() || check1.isChecked() || check2.isChecked()
                            || check3.isChecked() || check4.isChecked())){
                        Toast.makeText(this, "Seleccione al menos una respuesta", Toast.LENGTH_SHORT).show();
                    } else {

                        if(check1.isChecked()){
                            points += 3;
                        }
                        if(check2.isChecked()){
                            points += 3;
                        }
                        if(check3.isChecked()){
                            points += 3;
                        }
                        if(check4.isChecked()){
                            points += 3;
                        }
                        if(checkNinguno.isChecked()){
                            points += 0;
                        }

                        SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);
                        preferences.edit().putInt("puntosNexo", points).apply();
                        Intent i3 = new Intent(this, Sintomas.class);
                        startActivity(i3);
                        finish();
                    }

                    if(checkNinguno.isChecked()){
                        if(check1.isChecked() || check2.isChecked()
                                || check3.isChecked() || check4.isChecked()) {
                            Toast.makeText(this, "Verifique sus respuestas", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.isChecked()){

            check1.setChecked(false);
            check2.setChecked(false);
            check3.setChecked(false);
            check4.setChecked(false);

        }
    }
}