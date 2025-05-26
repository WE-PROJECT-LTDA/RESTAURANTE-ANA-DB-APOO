//package Restaurante.Infraestrutura;
//
//import java.sql.*;
//
//public class ConnectionFactory {
//    private static final String URL = "jdbc:mysql://134.65.244.176:3306/projeto_ana_restaurante_nascy";
//    private static final String USER = "Luizvenancio";
//    private static final String PASSWORD = "OrthERoMetabyptYpE";
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//
//    public static void executeQuery(String sql, java.util.function.Consumer<ResultSet> consumer) {
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            consumer.accept(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static int executeUpdate(String sql) {
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement()) {
//
//            return stmt.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }
//
//    // ✅ Novo método para exibir qualquer SELECT no terminal
//    public static void printQueryResults(String sql) {
//        executeQuery(sql, rs -> {
//            try {
//                ResultSetMetaData metaData = rs.getMetaData();
//                int columnCount = metaData.getColumnCount();
//
//                while (rs.next()) {
//                    for (int i = 1; i <= columnCount; i++) {
//                        String columnName = metaData.getColumnLabel(i);
//                        String value = rs.getString(i);
//                        System.out.printf("%s: %s  ", columnName, value);
//                    }
//                    System.out.println("\n\n\n\n");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//}
package Restaurante.Infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://134.65.244.176:3306/projeto_ana_restaurante_nascy?useSSL=false&serverTimezone=UTC";
    private static final String USER = "Luizvenancio";    // ajuste seu usuário
    private static final String PASSWORD = "OrthERoMetabyptYpE"; // ajuste sua senha

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
