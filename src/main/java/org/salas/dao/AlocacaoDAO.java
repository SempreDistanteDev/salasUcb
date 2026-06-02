package org.salas.dao;

import org.salas.model.Alocacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA

public class AlocacaoDAO {
    public List<Alocacao> findAll() throws SQLException {
        List<Alocacao> list = new ArrayList<>();
        String sql = "SELECT id_alocacao, \"FK_id_turma\", \"FK_id_sala\", \"FK_id_professor\" FROM public.tb_alocacao";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Alocacao item = new Alocacao(
                        rs.getInt("id_alocacao"),
                        rs.getInt("FK_id_turma"),
                        rs.getInt("FK_id_sala"),
                        rs.getInt("FK_id_professor")
                );
                list.add(item);
            }
        }
        return list;
    }
}
