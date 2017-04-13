package com.example.geoguitar.intents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        final  EditText ageEditText = (EditText) findViewById(R.id.age_edit_text);
        Button button = (Button) findViewById(R.id.next_button);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String age = extras.getString("age");

        TextView nameTextView = (TextView) findViewById(R.id.textViewName);
        TextView ageTextView = (TextView) findViewById(R.id.textViewAge);

        nameTextView.setText(getString(R.string.user_name,name));
        ageTextView.setText(getString(R.string.user_age,age));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEditText.getEditableText().toString();
                String age = ageEditText.getEditableText().toString();

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("age",age);
                startActivity(intent);
            }
        });
/*
        Bundle extras = getIntent().getExtras();
        String curso = extras.getString("curso");
        String sigla = extras.getString("sigla");
        int total = extras.getInt("total");
*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
