package com.escolaadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.escolaadmin.DAO.AlunoDAO;
import com.escolaadmin.model.Aluno;

public class FormularioAluno extends AppCompatActivity {

    EditText editText_Nome, editText_Email, editText_Telefone;
    Button btn_Salvar;
    Aluno alunoForSave, aluno;
    AlunoDAO alunoDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        aluno = new Aluno();

        alunoDAO = new AlunoDAO(FormularioAluno.this);

        Intent intent = getIntent();

        alunoForSave = (Aluno) intent.getSerializableExtra("aluno");

        editText_Nome = (EditText) findViewById(R.id.editText_Nome);
        editText_Email = (EditText) findViewById(R.id.editText_Email);
        editText_Telefone = (EditText) findViewById(R.id.editText_Telefone);

        btn_Salvar = (Button) findViewById(R.id.btn_Salvar);

        if(alunoForSave != null){
            editText_Nome.setText(alunoForSave.getNome());
            editText_Email.setText(alunoForSave.getEmail());
            editText_Telefone.setText(alunoForSave.getTelefone());

            aluno.setId(alunoForSave.getId());
        }


        System.out.println(editText_Nome);

        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aluno.setNome(editText_Nome.getText().toString());
                aluno.setEmail(editText_Email.getText().toString());
                aluno.setTelefone(editText_Telefone.getText().toString());

                if(alunoForSave == null){
                    alunoDAO.salvarAluno(aluno);

                }else {
                    alunoDAO.alterarAluno(aluno);
                }
                alunoDAO.close();

                Intent i = new Intent(FormularioAluno.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
