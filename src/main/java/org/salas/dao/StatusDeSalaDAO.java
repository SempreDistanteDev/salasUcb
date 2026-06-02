package org.salas.dao;

import org.salas.model.StatusDeSala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA

public class StatusDeSalaDAO {

    public List<StatusDeSala> findAll() throws SQLException {
        List<StatusDeSala> list = new ArrayList<>();
        String sql = "SELECT id_status, nome_status FROM public.tb_status_de_sala";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                StatusDeSala item = new StatusDeSala(
                        rs.getInt("id_status"),
                        rs.getString("nome_status")
                );
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Inserts a new room status record into the database.
     */
    public void insert(int id, String nomeStatus) throws SQLException {
        String sql = "INSERT INTO public.tb_status_de_sala (id_status, nome_status) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, nomeStatus);
            stmt.executeUpdate();
        }
    }

    /**
     * Updates an existing room status record based on its ID.
     */
    public void update(int id, String nomeStatus) throws SQLException {
        String sql = "UPDATE public.tb_status_de_sala SET nome_status = ? WHERE id_status = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}


