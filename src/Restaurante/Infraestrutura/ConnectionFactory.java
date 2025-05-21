package Restaurante.Infraestrutura;

import java.sql.*;
import java.util.function.Consumer;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://134.65.244.176:3306/projeto_ana_restaurante_nascy";
    private static final String USER = "anascimento";
    private static final String PASSWORD = "OrthERoMetabyptYpE";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void executeQuery(String sql, Consumer<ResultSet> consumer) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            consumer.accept(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int executeUpdate(String sql) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            return stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
