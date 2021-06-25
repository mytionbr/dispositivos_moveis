package com.escolaadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.escolaadmin.DAO.AlunoDAO;
import com.escolaadmin.model.Aluno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    AlunoDAO alunoDAO;
    ArrayList<Aluno> listView_Aluno;
    Aluno aluno;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = (Button) findViewById(R.id.btn_Cadastrar);
        btnCadastrar.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,FormularioAluno.class);
                startActivity(intent);
            }
        });

        lista = (ListView) findViewById(R.id.listView_Alunos);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) parent.getItemAtPosition(position);
                Intent i = new Intent(MainActivity.this,FormularioAluno.class);
                i.putExtra("aluno",alunoEscolhido);
                startActivity(i);
            }
        });




        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                aluno = (Aluno) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                alunoDAO = new AlunoDAO(MainActivity.this);
                alunoDAO.deleteAluno(aluno);
                alunoDAO.close();
                carregarAlunos();
                return true;
            }
        });
    }



    protected void onResume(){
        super.onResume();
        carregarAlunos();
    }

    public void carregarAlunos(){
        alunoDAO = new AlunoDAO(MainActivity.this);
        listView_Aluno = alunoDAO.listAlunos();
        alunoDAO.close();

        System.out.println(listView_Aluno);

        if(listView_Aluno != null){
            adapter = new ArrayAdapter<Aluno>(MainActivity.this,android.R.layout.simple_list_item_1,listView_Aluno);
            lista.setAdapter(adapter);
        }

    }
}
