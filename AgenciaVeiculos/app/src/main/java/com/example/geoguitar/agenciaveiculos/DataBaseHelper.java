package com.example.geoguitar.agenciaveiculos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by geoguitar on 11/05/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO_DADOS = "CadastroVeiculos";
    private static final int VERSAO_BANCO_DADOS = 1;
    private static DataBaseHelper instance;

    public static DataBaseHelper getInstance(Context context){

        if(instance == null)
            instance = new DataBaseHelper(context);

        return = instance;
    }

    private DataBaseHelper(Context context){

        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(VeiculoDAO.SCRIPT_CRIACAO_TABELA_VEICULOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(VeiculoDAO.SCRIPT_DELECAO_TABELA);
        onCreate(db);
    }
}
