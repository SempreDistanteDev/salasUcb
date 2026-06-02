package org.salas.dao;

import org.salas.model.Professores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA

public class ProfessoresDAO {

    public List<Professores> findAll() throws SQLException {
        List<Professores> list = new ArrayList<>();
        String sql = "SELECT id_professor, nome_professor FROM public.tb_professores";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professores item = new Professores(
                        rs.getInt("id_professor"),
                        rs.getString("nome_professor")
                );
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Inserts a new professor record into the database.
     */
    public void insert(int id, String nomeProfessor) throws SQLException {
        String sql = "INSERT INTO public.tb_professores (id_professor, nome_professor) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, nomeProfessor);
            stmt.executeUpdate();
        }
    }

    /**
     * Updates an existing professor record based on their ID.
     */
    public void update(int id, String nomeProfessor) throws SQLException {
        String sql = "UPDATE public.tb_professores SET nome_professor = ? WHERE id_professor = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeProfessor);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}