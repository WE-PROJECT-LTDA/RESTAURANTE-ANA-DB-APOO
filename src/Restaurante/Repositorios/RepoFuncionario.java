package Restaurante.Repositorios;

import Restaurante.Entidades.Funcionario;
import Restaurante.Entidades.Heranças.Cozinheiro;
import Restaurante.Entidades.Heranças.Garcom;
import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoFuncionario implements IRepository<Funcionario> {
    List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void adicionar(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (Nome, Cargo, Cpf) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCargo());
            pstmt.setString(3, funcionario.getCpf());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Funcionario> listar() {
        String sql = "SELECT * FROM Funcionario";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String cargo = rs.getString("Cargo");
                Funcionario funcionario;

                if ("Cozinha".equalsIgnoreCase(cargo)) {
                    funcionario = new Funcionario(
                            rs.getString("CodFuncionario"),
                            rs.getString("Nome"),
                            rs.getString("Cpf")
                    );
                } else if ("Entrega".equalsIgnoreCase(cargo)) {
                    funcionario = new Funcionario(
                            rs.getString("CodFuncionario"),
                            rs.getString("Nome"),
                            rs.getString("Cpf")
                    );
                } else {
                    // fallback para outro tipo se necessário ou lançar exceção
                    funcionario = null;
                }

                if (funcionario != null) {
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    @Override
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM Funcionario WHERE CodFuncionario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String cargo = rs.getString("Cargo");
                    Funcionario funcionario;

                    if ("Cozinha".equalsIgnoreCase(cargo)) {
                        funcionario = new Funcionario(
                                rs.getString("CodFuncionario"),
                                rs.getString("Nome"),
                                rs.getString("Cpf")
                        );
                    } else if ("Entrega".equalsIgnoreCase(cargo)) {
                        funcionario = new Funcionario(
                                rs.getString("CodFuncionario"),
                                rs.getString("Nome"),
                                rs.getString("Cpf")
                        );
                    } else {
                        // fallback para outro tipo se necessário ou lançar exceção
                        funcionario = null;
                    }

                    if (funcionario != null) {
                        funcionarios.add(funcionario);
                    }
                    return funcionario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizar(int id, String novoNome, String novoCargo, String novoCpf) {
        String sql = "UPDATE Funcionario SET Nome = ?, Cargo = ?, Cpf = ? WHERE IdFuncionario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoNome);
            pstmt.setString(2, novoCargo);
            pstmt.setString(3, novoCpf);
            pstmt.setInt(4, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM Funcionario WHERE IdFuncionario = ?";
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
