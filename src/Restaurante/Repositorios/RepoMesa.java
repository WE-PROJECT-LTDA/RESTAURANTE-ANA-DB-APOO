package Restaurante.Repositorios;

import Restaurante.Entidades.Mesa;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoMesa {

    public void adicionar(Mesa mesa) {
        String sql = "INSERT INTO Mesa (Capacidade) VALUES (?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mesa.getCapacidade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mesa> listar() {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM Mesa";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mesa mesa = new Mesa(rs.getInt("Capacidade"));
                mesa.setIdMesa(rs.getInt("IdMesa"));
                mesas.add(mesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesas;
    }

    public Mesa buscarPorId(int idMesa) {
        String sql = "SELECT * FROM Mesa WHERE IdMesa = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMesa);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Mesa mesa = new Mesa(rs.getInt("Capacidade"));
                    mesa.setIdMesa(rs.getInt("IdMesa"));
                    return mesa;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int idMesa, int novaCapacidade) {
        String sql = "UPDATE Mesa SET Capacidade = ? WHERE IdMesa = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novaCapacidade);
            pstmt.setInt(2, idMesa);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remover(int idMesa) {
        String sql = "DELETE FROM Mesa WHERE IdMesa = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMesa);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
