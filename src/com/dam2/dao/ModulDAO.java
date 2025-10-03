package com.dam2.dao;

import com.dam2.model.ModulProfessional;
import com.dam2.model.Professor;
import com.dam2.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModulDAO {

    public void addDam2(ModulProfessional m) {
        String sql = "INSERT INTO ModulsProfessionals (nom, id_professor) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, m.getNom());
            if (m.getProfessor() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, m.getProfessor().getId());
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) m.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Error insertant mòdul: " + e.getMessage());
        }
    }

    public List<ModulProfessional> readDam2() {
        List<ModulProfessional> llista = new ArrayList<>();
        String sql = "SELECT m.id AS mid, m.nom AS mnom, p.id AS pid, p.nom AS pnom, p.cognoms AS pcognoms " +
                "FROM ModulsProfessionals m LEFT JOIN Professors p ON m.id_professor = p.id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Professor prof = null;
                int pid = rs.getInt("pid");
                if (!rs.wasNull()) {
                    prof = new Professor(pid, rs.getString("pnom"), rs.getString("pcognoms"));
                }
                ModulProfessional m = new ModulProfessional(rs.getInt("mid"), rs.getString("mnom"), prof);
                llista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error llegint mòduls: " + e.getMessage());
        }
        return llista;
    }

    public boolean updateDam2(ModulProfessional m) {
        String sql = "UPDATE ModulsProfessionals SET nom = ?, id_professor = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNom());
            if (m.getProfessor() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, m.getProfessor().getId());
            }
            ps.setInt(3, m.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error actualitzant mòdul: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteDam2(int id) {
        String sql = "DELETE FROM ModulsProfessionals WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error eliminant mòdul: " + e.getMessage());
            return false;
        }
    }
}

