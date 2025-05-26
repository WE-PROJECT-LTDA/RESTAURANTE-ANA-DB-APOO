package Restaurante.Repositorios;

import Restaurante.Entidades.Comanda;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoComanda {

    public void adicionar(Comanda comanda) {
        String sql = "INSERT INTO Comanda (IdCliente, IdMesa, Descricao, Valor) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comanda.getIdCliente());
            pstmt.setInt(2, comanda.getIdMesa());
            pstmt.setString(3, comanda.getDescricao());
            pstmt.setDouble(4, comanda.getValor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comanda> listar() {
        List<Comanda> comandas = new ArrayList<>();
        String sql = "SELECT * FROM Comanda";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Comanda comanda = new Comanda(
                        rs.getInt("IdCliente"),
                        rs.getString("Descricao"),
                        rs.getInt("IdMesa"),
                        rs.getDouble("Valor")
                );
                comanda.setId(rs.getInt("IdComanda"));
                comandas.add(comanda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comandas;
    }

    public Comanda buscarPorId(int id) {
        String sql = "SELECT * FROM Comanda WHERE IdComanda = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Comanda comanda = new Comanda(
                            rs.getInt("IdCliente"),
                            rs.getString("Descricao"),
                            rs.getInt("IdMesa"),
                            rs.getDouble("Valor")
                    );
                    comanda.setId(rs.getInt("IdComanda"));
                    return comanda;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int id, int novoIdCliente, String novaComanda, int novoIdMesa, String novaDescricao, double novoValor) {
        String sql = "UPDATE Comanda SET IdCliente = ?, IdMesa = ?, Descricao = ?, Valor = ? WHERE IdComanda = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novoIdCliente);
            pstmt.setInt(2, novoIdMesa);
            pstmt.setString(3, novaDescricao);
            pstmt.setDouble(4, novoValor);
            pstmt.setInt(5, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM Comanda WHERE IdComanda = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
