package com.escolaadmin.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.escolaadmin.model.Aluno;

import java.util.ArrayList;

public class AlunoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbescolaadmin";
    private static final int VERSION = 1;

    public AlunoDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String alunoScript = ("CREATE TABLE aluno (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nome TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "telefone TEXT NOT NULL);");
        db.execSQL(alunoScript);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String alunoScript = "DROP TABLE IF EXISTS aluno";
        db.execSQL(alunoScript);
    }



    public void salvarAluno(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome",aluno.getNome());
        values.put("email",aluno.getEmail());
        values.put("telefone",aluno.getTelefone());

        getWritableDatabase().insert("aluno",null,values);
    }

    public void alterarAluno(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome",aluno.getNome());
        values.put("email",aluno.getEmail());
        values.put("telefone",aluno.getTelefone());

        String[] args = {(aluno.getId().toString())};
        getWritableDatabase().update("aluno",values,"id=?",args);
    }

    public void deleteAluno(Aluno aluno){
        String[] args = {(aluno.getId().toString())};
        getWritableDatabase().delete("aluno","id=?",args);
    }

    public ArrayList<Aluno> listAlunos(){
        String[] columns = {"id","nome","email","telefone"};
        Cursor cursor = getWritableDatabase().query("aluno",columns,null,null,null,null,null,null);
        ArrayList<Aluno> alunos = new ArrayList<>();

        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(cursor.getLong(0));
            aluno.setNome(cursor.getString(1));
            aluno.setEmail(cursor.getString(2));
            aluno.setTelefone(cursor.getString(3));

            alunos.add(aluno);
        }

        return alunos;
    }
}
