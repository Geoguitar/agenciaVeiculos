package com.example.geoguitar.curso.android;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class OlaMundoActivity extends ActionBarActivity {

    private EditText edNome;
    private Button btEnviar,btModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olamundolayout);

        edNome = (EditText) findViewById(R.id.edNome);
        btEnviar = (Button) findViewById(R.id.btExibir);
        btModal = (Button) findViewById(R.id.btModal);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), edNome.getText(),
                Toast.LENGTH_LONG).show();
            }
        });

        btModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OlaMundoActivity.this);
                builder.setMessage("Operação Realizada com Sucesso !");
                builder.setNeutralButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.setTitle("Resultado da Execução");
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ola_mundo, menu);
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
