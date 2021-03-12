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

public class Sintomas extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private CheckBox fiebreCheck;
    private CheckBox dolorGargantaCheck;
    private CheckBox congestionCheck;
    private CheckBox tosCheck;
    private CheckBox fatigaCheck;
    private CheckBox respirarCheck;
    private CheckBox ningunoCheck;
    private Button finalizarButton;

    Boolean toContinue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        fiebreCheck = findViewById(R.id.fiebreCheck);
        dolorGargantaCheck = findViewById(R.id.dolorGargantaCheck);
        congestionCheck = findViewById(R.id.congestionCheck);
        tosCheck = findViewById(R.id.tosCheck);
        fatigaCheck = findViewById(R.id.fatigaCheck);
        respirarCheck = findViewById(R.id.respirarCheck);
        ningunoCheck = findViewById(R.id.ningunoCheck);
        finalizarButton = findViewById(R.id.finalizarButton);


        ningunoCheck.setOnCheckedChangeListener(this);

        finalizarButton.setOnClickListener(
                v->{
                    int points = 0;
                //Para verificar cuando las respuestas son incorrectas
                    if(ningunoCheck.isChecked()){
                        if(fiebreCheck.isChecked() || dolorGargantaCheck.isChecked()
                                || congestionCheck.isChecked() || tosCheck.isChecked()
                                    || fatigaCheck.isChecked() || respirarCheck.isChecked()) {
                            //toContinue = false;
                            Toast.makeText(this, "Verifique sus respuestas", Toast.LENGTH_SHORT).show();
                        }
                        //para cuando no ha seleccionado ninguna
                    } else if(!(ningunoCheck.isChecked() || fiebreCheck.isChecked() || dolorGargantaCheck.isChecked()
                                || congestionCheck.isChecked() || tosCheck.isChecked()
                                    || fatigaCheck.isChecked() || respirarCheck.isChecked())){
                            Toast.makeText(this, "Seleccione al menos una respuesta", Toast.LENGTH_SHORT).show();
                            toContinue = false;
                    } else {
                            if(fiebreCheck.isChecked()){
                                points += 4;
                                toContinue = true;
                            }
                            if(dolorGargantaCheck.isChecked()){
                                points += 4;
                                toContinue = true;
                            }
                            if(congestionCheck.isChecked()){
                                points += 4;
                                toContinue = true;
                            }
                            if(tosCheck.isChecked()){
                                points += 4;
                                toContinue = true;
                            }
                            if(fatigaCheck.isChecked()){
                                points += 4;
                                toContinue = true;
                            }
                            if(respirarCheck.isChecked()){
                                points += 4;
                                toContinue = true;
                            }
                            if(ningunoCheck.isChecked()){
                                points += 0;
                                toContinue = true;
                            }

                            if(toContinue){
                                SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);
                                points += preferences.getInt("puntosNexo", 1000);

                                preferences.edit().putString("userNames" ,
                                        preferences.getString("userNames","") + " > " + points + "\n").apply();


                                Intent i4 = new Intent(this, MainActivity.class);
                                startActivity(i4);
                            }
                        }
                    }
        );

    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.isChecked()){

            fiebreCheck.setChecked(false);
            dolorGargantaCheck.setChecked(false);
            congestionCheck.setChecked(false);
            tosCheck.setChecked(false);
            fatigaCheck.setChecked(false);
            respirarCheck.setChecked(false);

        }
    }
}