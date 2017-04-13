package br.com.livroandroid.helloandroidstudio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.R;

public class MainActivity2 extends Activity {
    private static final String TAG = "livro";

    private Button btLogin;
    private TextView tLogin,tSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tLogin = (TextView) findViewById(R.id.tLogin);
                tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                if("geovane".equals(login) && "123".equals(senha)){
                    alert("Bem-vindo, login realizado com sucesso.");
                }else {
                    alert("Login ou senha incorretos.");
                }
            }
        });

        Log.v(TAG, "log de verbose");
        Log.d(TAG,"log de debug");
        Log.i(TAG,"log de info");
        Log.w(TAG,"log de alerta");
        Log.e(TAG, "log de erro", new RuntimeException("Teste de erro"));
    }
    private void alert(String s){

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

}
