package Restaurante;

import Restaurante.Infraestrutura.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class Testeconexao {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("✅ Conexão realizada com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar:");
            e.printStackTrace();
        }
    }
}
