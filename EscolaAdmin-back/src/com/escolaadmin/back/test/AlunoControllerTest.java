
package com.escolaadmin.back.test;

import com.escolaadmin.back.controller.AlunoController;
import com.escolaadmin.back.model.Aluno;
import java.util.List;


public class AlunoControllerTest {
    public static void main(String[] args) {
        AlunoController alunoController = new AlunoController();
        
        List<Aluno> alunos = alunoController.listAlunos();
        
        System.err.println(alunos);
    }
}
