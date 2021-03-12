package com.example.quiz1ea_sem5_2021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class NexoEpidemiologico extends AppCompatActivity implements View.OnClickListener{

    private CheckBox contactoCheck;
    private CheckBox viajeIntCheck;
    private CheckBox viajeNacCheck;
    private CheckBox trabSaludCheck;
    private CheckBox ningunaCheck;
    private Button toSintomasButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_epidemiologico);

        contactoCheck = findViewById(R.id.contactoCheck);
        viajeIntCheck = findViewById(R.id.viajeIntCheck);
        viajeNacCheck = findViewById(R.id.viajeNacCheck);
        trabSaludCheck = findViewById(R.id.trabSaludCheck);
        ningunaCheck = findViewById(R.id.ningunaCheck);
        toSintomasButton = findViewById(R.id.toSintomasButton);


        SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);

        toSintomasButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.toSintomasButton:

                switch (v.getId()){
                    case R.id.contactoCheck:
                        break;

                    case R.id.viajeIntCheck:
                        break;

                    case R.id.viajeNacCheck:
                        break;

                    case R.id.trabSaludCheck:
                        break;

                    case R.id.ningunaCheck:
                        break;
                }

                Intent i3 = new Intent(this, Sintomas.class);
                startActivity(i3);
                finish();



                break;
            default:

        }

    }
}