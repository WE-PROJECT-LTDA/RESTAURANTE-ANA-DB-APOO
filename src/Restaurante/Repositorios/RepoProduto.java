package Restaurante.Repositorios;

import Restaurante.Entidades.Produto;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoProduto {

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

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("Nome"),
                        rs.getDouble("Preco"),
                        rs.getString("Descricao")
                );
                produto.setCodigo(rs.getInt("Codigo"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public Produto buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM Produto WHERE Codigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto(
                            rs.getString("Nome"),
                            rs.getDouble("Preco"),
                            rs.getString("Descricao")
                    );
                    produto.setCodigo(rs.getInt("Codigo"));
                    return produto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int codigo, String novoNome, double novoPreco, String novaDescricao) {
        String sql = "UPDATE Produto SET Nome = ?, Preco = ?, Descricao = ? WHERE Codigo = ?";
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

    public boolean remover(int codigo) {
        String sql = "DELETE FROM Produto WHERE Codigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void inicializarProdutos() {
        adicionar(new Produto("Pizza Margherita", 35.00, "Pizza com molho de tomate e queijo"));
        adicionar(new Produto("Coxinha", 8.50, "Coxinha de frango desfiado"));
        adicionar(new Produto("Refrigerante", 5.00, "Refrigerante de cola"));
        adicionar(new Produto("Hambúrguer", 25.00, "Hambúrguer com queijo e bacon"));
        adicionar(new Produto("Batata Frita", 12.00, "Porção de batata frita crocante"));
        adicionar(new Produto("Salada Caesar", 18.50, "Salada com frango grelhado e molho Caesar"));
        adicionar(new Produto("Suco Natural", 7.00, "Suco de laranja natural"));
        adicionar(new Produto("Lasanha", 40.00, "Lasanha de carne com queijo"));
        adicionar(new Produto("Espaguete", 30.00, "Espaguete ao molho de tomate"));
        adicionar(new Produto("Sorvete", 10.00, "Sorvete de creme com calda de chocolate"));
    }
}
