package org.salas.dao;

import org.salas.model.Salas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA

public class SalasDAO {

    public List<Salas> findAll() throws SQLException {
        List<Salas> list = new ArrayList<>();
        String sql = "SELECT id_sala, nome, \"FK_status_id\" FROM public.tb_salas";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Salas item = new Salas(
                        rs.getInt("id_sala"),
                        rs.getString("nome"),
                        rs.getInt("FK_status_id")
                );
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Inserts a new room record into the database.
     */
    public void insert(int id, String nome, int fkStatusId) throws SQLException {
        String sql = "INSERT INTO public.tb_salas (id_sala, nome, \"FK_status_id\") VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setInt(3, fkStatusId);
            stmt.executeUpdate();
        }
    }

    /**
     * Updates an existing room record based on its ID.
     */
    public void update(int id, String nome, int fkStatusId) throws SQLException {
        String sql = "UPDATE public.tb_salas SET nome = ?, \"FK_status_id\" = ? WHERE id_sala = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, fkStatusId);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }
}
