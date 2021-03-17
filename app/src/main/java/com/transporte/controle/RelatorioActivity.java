package com.transporte.controle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.nio.FloatBuffer;

public class RelatorioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //alterei o layout
        setContentView(R.layout.activity_relatorio);
        final Intent inte = new Intent(this, MainActivity.class);
        FloatingActionButton fab = findViewById(R.id.voltar);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(v.getId() == R.id.voltar) {

                    startActivity(inte);}
            }
        });
    }
    }
