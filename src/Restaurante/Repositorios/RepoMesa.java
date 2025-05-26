package Restaurante.Repositorios;

import Restaurante.Entidades.Mesa;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoMesa implements IRepository<Mesa>{

    @Override
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

    @Override
    public List<Mesa> listar() {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM Mesa";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mesa mesa = new Mesa(rs.getInt("CodMesa"),
                        rs.getInt("Capacidade"));
                mesas.add(mesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesas;
    }

    @Override
    public Mesa buscarPorId(int idMesa) {
        String sql = "SELECT * FROM Mesa WHERE CodMesa = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMesa);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Mesa mesa = new Mesa(rs.getInt("CodMesa"), rs.getInt("Capacidade"));
                    return mesa;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int idMesa, int novaCapacidade) {
        String sql = "UPDATE Mesa SET Capacidade = ? WHERE CodMesa = ?";
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

    @Override
    public boolean remover(int idMesa) {
        String sql = "DELETE FROM Mesa WHERE CodMesa = ?";
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
