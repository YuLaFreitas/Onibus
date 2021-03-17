package com.transporte.controle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarActivity extends AppCompatActivity {

    /*
     *  Pretendo colocar botaão "TRANSFERIR" que vai encapsular o passageiro
     *  retirando ele do acento e pedindo qual o dia"?" carro e acento que será transferido
     *  poderá ter um alerta, caso o acento escolhido ja esteja ocupado
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.voltar);

        final Intent intent = new Intent(this, MainActivity.class);
        Intent intent1 = getIntent();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

                    }
        });

        //EditText acento = findViewById(R.id.poltEdit);
        EditText nome = findViewById(R.id.nomeEdit);
        nome.setText(intent1.getStringExtra("nome"));

        EditText sobrnome = findViewById(R.id.sobrnomeEdit);
        sobrnome.setText(intent1.getStringExtra("sobrnome"));

        EditText tel = findViewById(R.id.telEdit);
        tel.setText(intent1.getStringExtra("tel"));

        EditText idade = findViewById(R.id.idadeEdit);
        idade.setText(intent1.getStringExtra("idade"));

        EditText valor = findViewById(R.id.valorEdit);
        valor.setText(intent1.getStringExtra("valor"));

        EditText ponto = findViewById(R.id.pontoEdit);
        ponto.setText(intent1.getStringExtra("ponto"));

        EditText car = findViewById(R.id.carEdit);
        car.setText(intent1.getStringExtra("car"));

        EditText acento = findViewById(R.id.poltEdit);
        acento.setText(intent1.getStringExtra("acento"));


    }

    public void onClick(View v){
        Toast toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
            String word="";

            switch (v.getId()){

                case R.id.nomeEdit: word="NOME \n"; break;
                //case R.id.carEdit: word="CARRO\n"; break;
                //case R.id.poltEdit: word="POLTRONA\n"; break;
                case R.id.idadeEdit: word="IDADE\n"; break;
                case R.id.sobrnomeEdit: word="SOBRENOME\n"; break;
                case R.id.telEdit: word="TELEFONE DE CONTATO\n"; break;
                case R.id.valorEdit: word="VALOR CONTRIBUIDO\n"; break;
                case R.id.pontoEdit: word="PONTO QUE VAI AGURADAR\n"; break;

            }

        toast.setText(word + " A SER ALTERADO");
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent intent = new Intent(this, MainFragActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
