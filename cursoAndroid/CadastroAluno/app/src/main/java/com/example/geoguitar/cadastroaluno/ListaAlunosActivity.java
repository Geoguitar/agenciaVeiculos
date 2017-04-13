package com.example.geoguitar.cadastroaluno;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListaAlunosActivity extends ActionBarActivity {

    private EditText edNome;
    private Button botao;
    private ListView lvListagem;
    private List<String> listaAlunos;

    private ArrayAdapter<String> adapter;
    private  int adapterLayout = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaalunoslayout);

        edNome = (EditText) findViewById(R.id.edNomeListagem);
        botao = (Button) findViewById(R.id.btAddListagem);
        lvListagem = (ListView) findViewById(R.id.lvListagem);

        listaAlunos = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, adapterLayout, listaAlunos);
        lvListagem.setAdapter(adapter);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listaAlunos.add(edNome.getText().toString());
                edNome.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        lvListagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                Toast.makeText(ListaAlunosActivity.this, "Aluno: " + listaAlunos.get(posicao),
                        Toast.LENGTH_LONG).show();
            }
        });

        lvListagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                Toast.makeText(ListaAlunosActivity.this,
                        "Aluno: " + listaAlunos.get(posicao) + "[Click Longo]",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
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
