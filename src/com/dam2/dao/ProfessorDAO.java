import com.dam2.model.Professor;
import com.dam2.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public void addDam2(Professor p) {
    String sql = "INSERT INTO Professors (nom, cognoms) VALUES (?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, p.getNom());
        ps.setString(2, p.getCognoms());
        ps.executeUpdate();
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                p.setId(rs.getInt(1));
            }
        }
    } catch (SQLException e) {
        System.err.println("Error insertant professor: " + e.getMessage());
    }
}

public List<Professor> readDam2() {
    List<Professor> llista = new ArrayList<>();
    String sql = "SELECT id, nom, cognoms FROM Professors";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            llista.add(new Professor(rs.getInt("id"), rs.getString("nom"), rs.getString("cognoms")));
        }
    } catch (SQLException e) {
        System.err.println("Error llegint professors: " + e.getMessage());
    }
    return llista;
}

public boolean updateDam2(Professor p) {
    String sql = "UPDATE Professors SET nom = ?, cognoms = ? WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, p.getNom());
        ps.setString(2, p.getCognoms());
        ps.setInt(3, p.getId());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error actualitzant professor: " + e.getMessage());
        return false;
    }
}

public boolean deleteDam2(int id) {
    String sql = "DELETE FROM Professors WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error eliminant professor: " + e.getMessage());
        return false;
    }
}

void main() {
}




