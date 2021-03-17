package com.transporte.controle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch escolher = findViewById(R.id.esconderTabelaBtn);
        //padroniza o botão SWITCH como falso e texto hint MOSTRAR
        escolher.setChecked(true);
        escolher.setHint("MOSTRAR");
        //fragmento aqui



        //------------------------------------
        //soma dos valores registrados no aplicativo
        TextView somaRecebeu = findViewById(R.id.TotalRegistrado);
        //total de pessoas que pagaram
        TextView pagantes = findViewById(R.id.passageiros);
        //total dos valores que consta no recivo
        TextView totalReceb = findViewById(R.id.valor);

        //Futuramente tentar implementar uma mascara
        somaRecebeu.setText("##,##");

        pagantes.setText("##");

        totalReceb.setText("R$ ##,##");

    }


    @Override
    public void onClick(View v) {

        Intent intent;

        TableLayout tabela = findViewById(R.id.tabelaDados);

        Switch escolha = findViewById(R.id.esconderTabelaBtn);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        switch (v.getId()) {
            /*case R.id.acentBtn: //estrutura de acentos

                alert.setMessage("funcionou ACENTO");

                break;*/

            case R.id.diaUmBtn: //pasageiros em lista
                //alert.setMessage("funcionou LISTA");
                intent = new Intent(this,  MainFragActivity.class);
                startActivity(intent);
                break;
            case R.id.diaDoisBtn: //pasageiros em lista
                //alert.setMessage("funcionou LISTA");
                intent = new Intent(this,  MainFragActivity.class);
                startActivity(intent);
                break;
            case R.id.diaTresBtn: //pasageiros em lista
                //alert.setMessage("funcionou LISTA");
                intent = new Intent(this,  MainFragActivity.class);
                startActivity(intent);
                break;


            case R.id.relatBtn: //relatórios

                intent = new Intent(this, RelatorioActivity.class);
                startActivity(intent);
                //alert.setMessage("funcionou RELATORIO");
                break;

            case R.id.esconderTabelaBtn: //switch
            if(escolha.isChecked()){
                //mostrar a tabela de dados
                tabela.setVisibility(View.INVISIBLE);
                escolha.setHint("MOSTRAR");
                break;

            }else{
                //esconde a tabela de dados
                tabela.setVisibility(View.VISIBLE);
                escolha.setHint("ESCONDER");
                break;
            }
        }
        //alert.show();
    }
}
