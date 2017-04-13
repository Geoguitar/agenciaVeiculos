package com.example.geoguitar.cadastrando;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class WinOne extends ActionBarActivity {

    public static final int CONSTANTE_TELA_1 = 1;

    protected EditText textoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_one);

        Button botaoSalvar = (Button) findViewById(R.id.buttonSalvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textoNome = (EditText) findViewById(R.id.meuTexto);

                Bundle bundle = new Bundle();
                bundle.putString("TEXTO_NOME",textoNome.getText().toString());

                Intent intent = new Intent(WinOne.this,TelaDois.class);
                intent.putExtras(bundle);
                textoNome.setText("");

                startActivityForResult(intent, CONSTANTE_TELA_1);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_win_one, menu);
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
