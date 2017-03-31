package com.example.geoguitar.agenciaveiculos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by geoguitar on 11/05/15.
 */
public class VeiculoDAO{

    public static final String NOME_TABELA = "Veiculo";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_MARCA = "marca";
    public static final String COLUNA_MODELO = "modelo";
    public static final String COLUNA_PLACA = "placa";

    public static final String SCRIPT_CRIACAO_TABELA_VEICULOS = "CREATE TABLE" + NOME_TABELA + "("

            + COLUNA_ID + "INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_MARCA + "TEXT,"
            + COLUNA_PLACA + "TEXT,"
            + COLUNA_MODELO + "TEXT"
            + ")";

    public static final String SCRIPT_DELECAO_TABELA = "DROP TABLE IF EXISTS" + NOME_TABELA;

    private SQLiteDatabase dataBase = null;

    private static VeiculoDAO instance;

    public static VeiculoDAO getInstance(Context context){

        if(instance == null)
            instance = new VeiculoDAO(context);
        return instance;
    }

    private VeiculoDAO(Context context){

        PersistenceHelper persistenceHelper = PersistenceHelper.getInstance(context);
        dataBase = persistenceHelper.getWritableDatabase();
    }

    public void salvar(Veiculo veiculo){

        ContentValues values = gerarContentValuesVeiculo(veiculo);
        dataBase.insert(NOME_TABELA, null, values);
    }

    public List<Veiculo> recuperarTodos(){

        String queryReturnAll = "SELECT * FROM" + NOME_TABELA;
        Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
        List<Veiculo> veiculos = construirVeiculoPorCursor(cursor);

        return veiculos;
    }

    public void fecharConexao(){

        if(dataBase != null && dataBase.isOpen())
            dataBase.close();
    }
    //dataBase.update(NOME_TABELA,valores, COLUNA_ID + "= ?", valoresParaSubstituir);

    private List<Veiculo> construirVeiculoPorCursor(Cursor cursor){

        List<Veiculo> veiculos  = new ArrayList<Veiculo>();
        if(Cursor == null)
            return veiculos;

        try {

            if (cursor.moveToFirst()){
                do{

                    int indexID = cursor.getColumnIndex(COLUNA_ID);
                    int indexMarca = cursor.getColumnIndex(COLUNA_MARCA);
                    int indexModelo = cursor.getColumnIndex(COLUNA_MODELO);
                    int indexPlaca = cursor.getColumnIndex(COLUNA_PLACA);

                    int id cursor.getInt(indexID);
                    String marca = cursor.getString(indexMarca);
                    String modelo = cursor.getString(indexModelo);
                    String placa = cursor.getString(indexPlaca);

                    Veiculo veiculo = new Veiculo(id, marca, modelo, placa);

                    veiculos.add(veiculo);

                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
        return veiculos;
    }


    private ContentValues gerarContentValuesVeiculo(Veiculo veiculo){
        ContentValues values = new ContentValues();
        values.put(COLUNA_MARCA, veiculo.getMarca());
        values.put(COLUNA_MODELO, veiculo.getModelo());
        values.put(COLUNA_PLACA, veiculo.getPlaca());

        return values;
    }
}

