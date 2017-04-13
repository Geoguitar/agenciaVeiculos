package br.com.livroandroid.loginandroidstudio;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends DebugActivity {

    private static final String TAG = "livro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ActionBar actionBar = getActionBar();
        //actionBar.setTitle("Capitulo 5");

        Button btLogin = (Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtLogin = (EditText) findViewById(R.id.edtLogin);
                EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
                String login = edtLogin.getText().toString();
                String senha = edtSenha.getText().toString();
                if("Geovane".equals(login) && "123".equals(senha)){
                    alert("Bem vindo,logou com sucesso.");

                    //navega para próxima tela
                    Intent intent = new Intent(getContext(),BemVindoActivity.class);
                    Bundle params = new Bundle();

                    params.putString("nome","Geovane");
                    intent.putExtras(params);
                    startActivity(intent);
                }else {
                    alert("Login ou senha incorretos.");
                }
            }
        });
        Log.v(TAG, "log de verbose");
        Log.d(TAG, "log de debug");
        Log.i(TAG, "log de info");
        Log.w(TAG, "log de alerta");
        Log.e(TAG, "log de erro", new RuntimeException("Teste de erro"));
    }
    private Context getContext(){
        return this;
    }
    private void alert(String s){

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //infla o menu da action bar (/res/menu/main.xml)
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            //clicou no botão settings da actions bar(o toast é um breve alerta que vai sumir)
            Toast.makeText(this,"Clicou no settings",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
