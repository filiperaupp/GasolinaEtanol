package com.example.filip.gasolinaetanol;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editGasolina, editEtanol;
    Button btnCalcular;
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGasolina = (EditText) findViewById(R.id.editGasolina);
        editEtanol = (EditText) findViewById(R.id.editEtanol);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                final AlertDialog alerta;
                final AlertDialog.Builder builderAviso = new AlertDialog.Builder(MainActivity.this);
                builderAviso.setTitle("Melhor combustível");

                try {
                    double valorGasolina = Double.parseDouble(editGasolina.getText().toString());
                    double valorEtanol = Double.parseDouble(editEtanol.getText().toString());

                    resultado = valorEtanol/valorGasolina;
                    if (resultado<=0.7) {
                        builderAviso.setMessage("Abasteça com Etanol");
                        alerta = builderAviso.create();
                        alerta.show();
                    }
                    else  {
                        builderAviso.setMessage("Abasteça com Gasolina");
                        alerta = builderAviso.create();
                        alerta.show();
                    }
                } catch (Exception e) {
                    Context contexto = getApplicationContext();
                    String txt = "Campo vazio";
                    int duracao = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(contexto,txt,duracao);
                    toast.show();

                }

            }
        });
    }
}
