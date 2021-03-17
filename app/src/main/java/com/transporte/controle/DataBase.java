package com.transporte.controle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    private static final String dataBaseName = "dadosArranjo";

    private static final int versao = 1;

    private static final String tabelaPassageiros =
            "CREATE TABLE " + dataBaseName + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT," +
                    "sobrnome TEXT," +
                    "telefone INTEGER," +
                    "idade INTEGER," +
                    "valor REAL" +
                    ");";
    //A tabelaVeiculo sera carregada com valores automaticamente
    private static final String tabelaVeiculo =
            "CREATE TABLE " + dataBaseName + " (" +
                    "dia INTEGER not null," +
                    "carro INTEGER not null," +
                    "acento INTEGER not null," +

                    "ocupanteKEY INTEGER," +
                    "PRIMARY KEY(dia, carro, acento)" +
                    ");";

    private static final String tabelaRelatorio =
            "CREATE TABLE " + dataBaseName + " (" +
                    "data INTEGER," +
                    "valor REAL" +
                    //futuramente quero colocar fotos do raltorio aqui também
                    ");";

    DataBase(Context context) {
        super(context, dataBaseName, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabelaPassageiros);
        db.execSQL(tabelaVeiculo);
        db.execSQL(tabelaRelatorio);

        gerarAcento(1, 1, db);
    }
    //ele vai gerar os dias carros e acentos segundo comando
    public void gerarAcento(int carros,int dias, SQLiteDatabase db){

        Cursor cursor =
                db.rawQuery("SELECT COUNT(*) from '" + tabelaVeiculo + "'", null);

        String sql;
        if(cursor == null) {
            int dia = dias;

                for (int car = 1; car >= carros; car++) {
                    for (int acento = 1; acento >= 50; acento++) {

                        sql = "Insert INTO '" + tabelaVeiculo +
                                "' (carro, acento, dia, ocupado) " +
                                "VALUES (" + dia + "," + car + "," + acento + ", 0)";

                        db.execSQL(sql);
                    }
                }
            }
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + dataBaseName);
    onCreate(db);
    }

    public void InsertDados(ContentValues cv, SQLiteDatabase db, int a){

        String nomeTabela = null;

        switch(a){
            case 1: nomeTabela = tabelaPassageiros;break;

            case 2: nomeTabela = tabelaVeiculo; break;
            case 3: nomeTabela = tabelaRelatorio; break;
        }
        db.insert(nomeTabela, null, cv);
    }

    public List<ContentValues>PesuisarAll(int a){

        String nomeTabela = null;

        switch(a){
            case 1: nomeTabela = tabelaPassageiros;break;

            case 2: nomeTabela = tabelaVeiculo; break;
            case 3: nomeTabela = tabelaRelatorio; break;
        }
        String sql = "SELECT * FROM '" + nomeTabela;
        return pesquisa(sql, null, a);
    }

    public List<ContentValues>PesuisarId(int a){

        String nomeTabela = null;

        switch(a){
            case 1: nomeTabela = tabelaPassageiros;break;
            case 2: nomeTabela = tabelaVeiculo; break;
            case 3: nomeTabela = tabelaRelatorio; break;
        }
        String sql = "SELECT id FROM '" + nomeTabela;
        return pesquisa(sql, null, a);
    }

    public List<ContentValues>PesuisarNome(){

        String nomeTabela = tabelaPassageiros;

        String sql = "SELECT nome FROM '" + nomeTabela;
        return pesquisa(sql, null, 1);
    }

    private List<ContentValues> pesquisa(String sql, String[] where, int a){
        List<ContentValues> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor =db.rawQuery(sql, where);
        switch (a) {
            case 1://TABELA DAS PESSOAS
                if (cursor.moveToFirst()) {
                    do {


                        ContentValues cv = new ContentValues();

                        cv.put("id", cursor.getColumnIndex("id"));
                        cv.put("nome", cursor.getColumnIndex("nome"));
                        cv.put("sobrenome", cursor.getColumnIndex("sobrenome"));
                        cv.put("tel", cursor.getColumnIndex("tel"));
                        cv.put("idade", cursor.getColumnIndex("idade"));
                        cv.put("valor", cursor.getColumnIndex("valor"));

                        list.add(cv);

                    } while (cursor.moveToNext());
                }

            case 2://TABELA DO VEICULO
                if (cursor.moveToFirst()) {
                    do {
                        ContentValues cv = new ContentValues();

                        cv.put("id", cursor.getColumnIndex("id"));
                        cv.put("dia", cursor.getColumnIndex("dia"));
                        cv.put("carro", cursor.getColumnIndex("carro"));
                        cv.put("acento", cursor.getColumnIndex("acento"));

                        list.add(cv);

                    } while (cursor.moveToNext());
                }

            case 3:// TABELA DO RELATORIO
                if (cursor.moveToFirst()) {
                    do {
                        ContentValues cv = new ContentValues();

                        cv.put("id", cursor.getColumnIndex("id"));
                        cv.put("valor", cursor.getColumnIndex("valor"));
                        cv.put("data", cursor.getColumnIndex("data"));

                        list.add(cv);

                    } while (cursor.moveToNext());
                }
        }
        return list;
    }

}
