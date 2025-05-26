package Restaurante.Repositorios;

import Restaurante.Entidades.Produto;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoProduto implements IRepository<Produto>{

    @Override
    public void adicionar(Produto produto) {
        String sql = "INSERT INTO Produto (Nome, Preco, Descricao) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setString(3, produto.getDescricao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("CodProduto"),
                        rs.getString("Nome"),
                        rs.getDouble("Preco"),
                        rs.getString("Descricao")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public Produto buscarPorId(int codigo) {
        String sql = "SELECT * FROM Produto WHERE CodProduto = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto(
                            rs.getInt("CodProduto"),
                            rs.getString("Nome"),
                            rs.getDouble("Preco"),
                            rs.getString("Descricao")
                    );
                    return produto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean atualizar(int codigo, String novoNome, double novoPreco, String novaDescricao) {
        String sql = "UPDATE Produto SET Nome = ?, Preco = ?, Descricao = ? WHERE CodProduto = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoNome);
            pstmt.setDouble(2, novoPreco);
            pstmt.setString(3, novaDescricao);
            pstmt.setInt(4, codigo);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remover(int codigo) {
        String sql = "DELETE FROM Produto WHERE CodProduto = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
