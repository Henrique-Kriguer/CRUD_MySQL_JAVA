package com.kriguer;

import java.util.List;

public class QueryiesExecution {
    public static void main(String[] args) {


        AlunoDAO alunoDAO = new AlunoDAO();

        //----------------- CONSULTA -------------------------
       //List<Aluno> alunos = alunoDAO.list();

        //alunos.stream().forEach(System.out::println);

        //-----------------------------------------------------

        //-------------------CONSULTA COM FILTRO --------------

        //
        //
         //Aluno alunoParaConsulta = alunoDAO.getById(4);
        //System.out.println(alunoParaConsulta);


        //------------------ INSERÇÃO DE NOVO ALUNO ------------

        //Aluno alunoParaInsercao = new Aluno("Pedro Alvares Cabral",155,"Aparecida","SP");
        //AlunoDAO.create(alunoParaInsercao);


        // --------------------- DELETAR ALUNO ---------------------------------------------------------------
        List<Aluno> alunos = alunoDAO.list();

        alunoDAO.list().stream().forEach(System.out::println);

        alunoDAO.delete(8);

        alunoDAO.list().stream().forEach(System.out::println);

        //------------------------ATUALIZAR ALUNO ---------------------------------------------------------------

      /*  alunoDAO.list().stream().forEach(System.out::println);

        Aluno alunoParaAtualizar = alunoDAO.getById(7);
        alunoParaAtualizar.setNome("Marcos Soliva");
        alunoParaAtualizar.setIdade(71);
        alunoParaAtualizar.setCidade("Aparecida");
        alunoParaAtualizar.setEstado("SP");

        alunoDAO.update(alunoParaAtualizar);

        alunoDAO.list().stream().forEach(System.out::println);
*/
    }
}