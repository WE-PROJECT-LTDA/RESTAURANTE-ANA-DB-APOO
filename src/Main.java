import Restaurante.Entidades.Cliente;
import Restaurante.Infraestrutura.ConnectionFactory;
import Restaurante.Repositorios.RepoCliente;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        RepoCliente repoCliente = new RepoCliente();

        Cliente c1 = repoCliente.findById(5);

//        Cliente c1 = new Cliente("Arlei", "81979107860", "arlei@gmail.com");
//        repoCliente.inserirNoBanco(c1);

        System.out.println(c1);

//        String sql = "SELECT * FROM Cliente";
//        ConnectionFactory.printQueryResults(sql);
    }
}
