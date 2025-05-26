//package Restaurante.Repositorios;
//
//import Restaurante.Entidades.Cliente;
//import Restaurante.Infraestrutura.ConnectionFactory;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RepoCliente  {
//    private List<Cliente> clientes = new ArrayList<>();
//
//
//    public void adicionar(Cliente cliente) {
//        clientes.add(cliente);
//    }
//
//
//    public List<Cliente> listar() {
//        return new ArrayList<>(clientes);
//    }
//
//
//    public Cliente buscarPorId(int id) {
//        for (Cliente c : clientes) {
//            if (c.getId() == id) {
//                return c;
//            }
//        }
//        return null;
//    }
//
//
//    public boolean atualizar(int id, String novoNome, String novoTelefone, String novoEmail) {
//        Cliente cliente = buscarPorId(id);
//        if (cliente != null) {
//            if (novoNome != null && !novoNome.trim().isEmpty()) cliente.setNome(novoNome);
//            if (novoTelefone != null && !novoTelefone.trim().isEmpty()) cliente.setTelefone(novoTelefone);
//            if (novoEmail != null && !novoEmail.trim().isEmpty()) cliente.setEmail(novoEmail);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean remover(int id) {
//        Cliente cliente = buscarPorId(id);
//        if (cliente != null) {
//            clientes.remove(cliente);
//            return true;
//        }
//        return false;
//    }
//
//    public void inserirNoBanco(Cliente cliente) {
//        String sql = "INSERT INTO Cliente (nome, telefone, email) VALUES (?, ?, ?)";
//
//        try (Connection conn = ConnectionFactory.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, cliente.getNome());
//            pstmt.setString(2, cliente.getTelefone());
//            pstmt.setString(3, cliente.getEmail());
//
//            int linhasAfetadas = pstmt.executeUpdate();
//
//            if (linhasAfetadas > 0) {
//                // Adiciona também na lista local, opcional
//                clientes.add(cliente);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Cliente findById(int id) {
//        String sql = "SELECT * FROM Cliente WHERE CodCliente = ?";
//
//        try (Connection conn = ConnectionFactory.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, id);
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    Cliente cliente = new Cliente(
//                            rs.getString("nome"),
//                            rs.getString("telefone"),
//                            rs.getString("email")
//                    );
//                    cliente.setId(rs.getInt("CodCliente"));
//                    return cliente;
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//}
package Restaurante.Repositorios;

import Restaurante.Entidades.Cliente;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoCliente {

    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (Nome, Telefone, Email) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.setString(3, cliente.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("CodCliente"),
                        rs.getString("Nome"),
                        rs.getString("Telefone"),
                        rs.getString("Email")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE CodCliente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("CodCliente"),
                            rs.getString("Nome"),
                            rs.getString("Telefone"),
                            rs.getString("Email")
                    );
                    return cliente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int id, String novoNome, String novoTelefone, String novoEmail) {
        String sql = "UPDATE Cliente SET Nome = ?, Telefone = ?, Email = ? WHERE CodCliente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoNome);
            pstmt.setString(2, novoTelefone);
            pstmt.setString(3, novoEmail);
            pstmt.setInt(4, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM Cliente WHERE CodCliente = ?";
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
