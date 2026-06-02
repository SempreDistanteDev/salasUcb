package org.salas.dao;

import org.salas.model.Turmas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA

public class TurmasDAO {
    public List<Turmas> findAll() throws SQLException {
        List<Turmas> list = new ArrayList<>();
        String sql = "SELECT id_turma, nome_turma FROM public.tb_turmas";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Turmas item = new Turmas(
                        rs.getInt("id_turma"),
                        rs.getString("nome_turma")
                );
                list.add(item);
            }
        }
        return list;
    }
}