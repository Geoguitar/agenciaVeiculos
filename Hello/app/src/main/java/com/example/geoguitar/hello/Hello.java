package com.example.geoguitar.hello;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Hello extends ActionBarActivity {

    protected Button novatela;
    protected EditText nqualquer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        novatela = (Button) findViewById(R.id.novatela);
        nqualquer = (EditText) findViewById(R.id.nqualquer);

        novatela.setOnClickListener(new View.OnClickListener() {

            //final String msg = nqualquer.getEditableText().toString() ;

            @Override
            public void onClick(View v) {
                String msg = nqualquer.getEditableText().toString();
                Intent workGroup = new Intent(Hello.this,WorkGroupActivity.class);
                workGroup.putExtra("NOME_QUALQUER", msg);

                startActivity(workGroup);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello, menu);
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
