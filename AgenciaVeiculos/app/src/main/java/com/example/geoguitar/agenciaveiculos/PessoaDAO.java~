package com.example.geoguitar.agenciaveiculos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by geoguitar on 25/05/15.
 */
public class PessoaDAO {

    public static final String NOME_TABELA = "Pessoa";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_SOBRENOME = "sobreNome";
    public static final String COLUNA_SEXO = "sexo";
    public static final String COLUNA_IDADE = "idade";

    public static final String SCRIPT_CRIACAO_TABELA_PESSOA = "CREATE TABLE" + NOME_TABELA + "("

            + COLUNA_ID + "INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_IDADE + "TEXT,"
            + COLUNA_NOME + "TEXT,"
            + COLUNA_SEXO + "TEXT,"
            + COLUNA_SOBRENOME + "TEXT"
            + ")";

    public static final String SCRIPT_DELECAO_TABELA = "DROP TABLE IF EXISTS" + NOME_TABELA;
    private SQLiteDatabase dataBase = null;

    private static PessoaDAO instance;

    public static PessoaDAO getInstance(Context context){

        if(instance == null)
            instance = new PessoaDAO(context);
        return instance;
    }

    private PessoaDAO(Context context){

        PersistenceHelper persistenceHelper = PersistenceHelper.getInstance(context);
        dataBase = persistenceHelper.getWritableDatabase();
    }

    public void salvar(Pessoa pessoa){

        ContentValues values = gerarContentValuesPessoa(pessoa);
        dataBase.insert(NOME_TABELA, null, values);
    }

    public List<Pessoa> recuperarTodos(){

        String queryReturnAll = "SELECT * FROM" + NOME_TABELA;
        Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
        List<Pessoa> pessoas = construirPessoaPorCursor(cursor);

        return pessoas;
    }

    public void fecharConexao(){

        if(dataBase != null && dataBase.isOpen())
            dataBase.close();
    }
    //dataBase.update(NOME_TABELA,valores, COLUNA_ID + "= ?", valoresParaSubstituir);

    private List<Pessoa> construirPessoaPorCursor(Cursor cursor){

        List<Pessoa> pessoas  = new ArrayList<Pessoa>();
        if(Cursor == null)
            return pessoas;

        try {

            if (cursor.moveToFirst()){
                do{

                    int indexId = cursor.getColumnIndex(COLUNA_ID);
                    int indexNome = cursor.getColumnIndex(COLUNA_NOME);
                    int indexSobreNome = cursor.getColumnIndex(COLUNA_SOBRENOME);
                    int indexIdade = cursor.getColumnIndex(COLUNA_IDADE);
                    int indexSexo = cursor.getColumnIndex(COLUNA_SEXO);

                    int id cursor.getInt(indexId);
                    String nome = cursor.getString(indexNome);
                    String sobreNome = cursor.getString(indexSobreNome);
                    int idade = cursor.getInt(indexIdade);
                    String sexo = cursor.getString(indexSexo);

                    Pessoa pessoa = new Pessoa(id, nome, sobreNome, sexo, idade);

                    pessoas.add(pessoa);

                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
        return pessoas;
    }


    private ContentValues gerarContentValuesPessoa(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, pessoa.getNome());
        values.put(COLUNA_SOBRENOME, pessoa.getSobreNome());
        values.put(COLUNA_IDADE, pessoa.getIdade());
        values.put(COLUNA_SEXO, pessoa.getSexo());

        return values;
    }
}
