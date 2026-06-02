package org.salas.dao;

import org.salas.model.Alunos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA

public class AlunosDAO {
    public List<Alunos> findAll() throws SQLException {
        List<Alunos> list = new ArrayList<>();
        String sql = "SELECT id_aluno, nome_aluno, \"FK_relacao_turma\" FROM public.tb_alunos";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Alunos item = new Alunos(
                        rs.getInt("id_aluno"),
                        rs.getString("nome_aluno"),
                        rs.getInt("FK_relacao_turma")
                );
                list.add(item);
            }
        }
        return list;
    }
}