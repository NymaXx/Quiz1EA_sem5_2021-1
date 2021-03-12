package com.example.quiz1ea_sem5_2021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Sintomas extends AppCompatActivity implements View.OnClickListener{

    private CheckBox fiebreCheck;
    private CheckBox dolorGargantaCheck;
    private CheckBox congestionCheck;
    private CheckBox tosCheck;
    private CheckBox fatigaCheck;
    private CheckBox respirarCheck;
    private CheckBox ningunoCheck;
    private Button finalizarButton;

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

        finalizarButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finalizarButton:
                Intent i4 = new Intent(this, MainActivity.class);
                startActivity(i4);
                break;
            default:

        }

    }
}