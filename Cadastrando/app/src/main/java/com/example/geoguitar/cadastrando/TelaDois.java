package com.example.geoguitar.cadastrando;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TelaDois extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);

        TextView msgTextView = (TextView) findViewById(R.id.mensagem);
        Button botaoSim = (Button) findViewById(R.id.buttonSim);
        Button botaoNao = (Button) findViewById(R.id.buttonNao);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String textoRetornado = bundle.getString("TEXTO_NOME");

        msgTextView.setText(textoRetornado);

        botaoSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(1);
                finish();
            }
        });

        botaoNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setResult(0);
                finish();
            }
        });

        if(getIntent().hasExtra("TEXTO_NOME")) {

            bundle = getIntent().getExtras();

            msgTextView.setText(bundle.getString("TEXTO_NOME"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_dois, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
