package com.example.quiz1ea_sem5_2021_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView namesList;
    private Button registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesList = findViewById(R.id.namesList);
        registerButton = findViewById(R.id.registerButton);



        registerButton.setOnClickListener(
                v->{
                    Intent i = new Intent(this, NuevoRegistro.class);
                    startActivity(i);
                }
        );

    }


    @Override
    public void onClick(View v) {

    }


    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);
        String data = preferences.getString("name","");

        namesList.setText(data);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Está seguro que desea salir de la aplicación?")
                .setNegativeButton("No", (dialog, id)->{
                    dialog.dismiss();
                })
                .setPositiveButton("Si", (dialog, id)->{
                    System.exit(0);
                });
        builder.show();
    }



}