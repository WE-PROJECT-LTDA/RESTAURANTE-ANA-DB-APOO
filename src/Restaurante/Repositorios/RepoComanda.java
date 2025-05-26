package Restaurante.Repositorios;

import Restaurante.Entidades.Comanda;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoComanda implements IRepository<Comanda>{

    @Override
    public void adicionar(Comanda comanda) {
        System.out.println("CodCliente: " + comanda.getIdCliente());
        System.out.println("CodMesa: " + comanda.getIdMesa());
        System.out.println("Valor: " + comanda.getValor());

        String sql = "INSERT INTO Comanda (CodCliente, CodMesa, Valor) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comanda.getIdCliente());
            pstmt.setInt(2, comanda.getIdMesa());
            pstmt.setDouble(3, comanda.getValor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Comanda> listar() {
        List<Comanda> comandas = new ArrayList<>();
        String sql = "SELECT * FROM Comanda";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Comanda comanda = new Comanda(
                        rs.getInt("CodComanda"),
                        rs.getInt("CodCliente"),
                        rs.getInt("CodMesa"),
                        rs.getDouble("Valor")
                );
                comandas.add(comanda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comandas;
    }
    @Override
    public Comanda buscarPorId(int id) {
        String sql = "SELECT * FROM Comanda WHERE IdComanda = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Comanda comanda = new Comanda(
                            rs.getInt("CodComanda"),
                            rs.getInt("CodCliente"),
                            rs.getInt("CodMesa"),
                            rs.getDouble("Valor")
                    );
                    return comanda;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int id, int novoIdCliente, int novoIdMesa, double novoValor) {
        String sql = "UPDATE Comanda SET IdCliente = ?, IdMesa = ?, Valor = ? WHERE IdComanda = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novoIdCliente);
            pstmt.setInt(2, novoIdMesa);
            pstmt.setDouble(4, novoValor);
            pstmt.setInt(5, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
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
