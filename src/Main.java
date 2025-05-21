import Restaurante.Infraestrutura.ConnectionFactory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM Cliente";

        ConnectionFactory.executeQuery(sql, rs -> {
            try {
                while (rs.next()) {
                    System.out.println("Cliente: " + rs.getString("Nome"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}