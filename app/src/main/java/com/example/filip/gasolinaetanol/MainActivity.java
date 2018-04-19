package com.example.filip.gasolinaetanol;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editGasolina) EditText bindGasolina;
    @BindView(R.id.editEtanol) EditText bindEtanol;
    @BindView(R.id.btnCalcular) Button bindCalcular;


    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        bindCalcular.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                final AlertDialog alerta;
                final AlertDialog.Builder builderAviso = new AlertDialog.Builder(MainActivity.this);
                builderAviso.setTitle("Melhor combustível");

                try {
                    double valorGasolina = Double.parseDouble(bindGasolina.getText().toString());
                    double valorEtanol = Double.parseDouble(bindEtanol.getText().toString());

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
