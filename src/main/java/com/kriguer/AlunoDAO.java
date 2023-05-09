package com.kriguer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    //---------------------------------1 - consulta DAO - Data Access Object --------------------------------
    public List<Aluno>list(){
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()){
            // preparar consulta SQL
            String sql = "SELECT * FROM aluno2";

            // preparar statement com os parametros recebidos
            // (nesta função não tem parametros, irá retornar todos os valores da tabela

            PreparedStatement stmt = conn.prepareStatement(sql);

            //executa a consulta e armazena o retorno :
            ResultSet rs = stmt.executeQuery();

            // criar um objeto aluno e guardar na lista alunos
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(id,nome,idade,cidade,estado));
            }
        } catch (SQLException | IOException e){
            System.out.println("Erro ao listar listagem de alunos");
            e.printStackTrace();
        }
        // Retornar todos alunos encontrados no banco de dados

        return alunos;
    }

    //----------------------------------------2 - Consulta com filtro ------------------------------------------

    public Aluno getById(int id){
        // preparar o objeto aluno para receber os parâmetros do BD

        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //preparar consulta SQL
            String sql = "SELECT * FROM aluno2 WHERE id = ?";

            // Preparar o statemnet com o parâmetro recebido ( número correspondente á coluna no BD)
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //executa consulta e armazena na variável
            ResultSet rs = stmt.executeQuery();


            // Guardar os valores retornados da tabela aluno2
            if (rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setEstado(rs.getString("estado"));
            }

        } catch (SQLException | IOException e){
            System.out.println("falha ao listar alunos");
            e.printStackTrace();
        }
        return aluno;
    }

    // ---------------------------------3 - Inserção de aluno no BD-----------------------------------------

    public static void create(Aluno aluno){
        try    (Connection conn = ConnectionFactory.getConnection()){
                String sql = "INSERT INTO aluno2 (nome, idade, cidade, estado) VALUES (?, ?, ?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1,aluno.getNome());
                stmt.setInt(2,aluno.getIdade());
                stmt.setString(3, aluno.getCidade());
                stmt.setString(4, aluno.getEstado());

                int rowsAfected = stmt.executeUpdate();

                System.out.println("Inserção bem sucedida. Foi adcionada "+ rowsAfected + " linha(s)");

                }catch (SQLException | IOException e) {
                    System.out.println("Inserção falhou");
                    e.printStackTrace();
        }
    }
    // __________________________________ 4. DELETAR ALUNO ________________________________________________________
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM aluno2 WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            int rowsafected = stmt.executeUpdate();

            System.out.println("Delete bem sucedida, foi deletata(s)"+ rowsafected + " linha(s)");

        } catch (SQLException | IOException e) {
            System.out.println("Delete falhou");
            e.printStackTrace();

        }
    }
    //--------------------------------- 5 - ATUALIZAR ALUNO --------------------------------------------------------

    public void update(Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()) {
            String sql = " UPDATE aluno2 SET nome = ?, idade = ?, cidade = ? , estado = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3,aluno.getCidade());
            stmt.setString(4,aluno.getEstado());
            stmt.setInt(5,aluno.getId());

            int rowsAfected = stmt.executeUpdate();

            System.out.println("Atualização bem sucedida. foi alterado " + rowsAfected + " linha");

        } catch (SQLException | IOException e){
            System.out.println("Atualização falhou");
            e.printStackTrace();
        }
    }

}
