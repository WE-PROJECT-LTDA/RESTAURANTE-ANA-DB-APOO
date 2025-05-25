//import Restaurante.Entidades.Cliente;
//import Restaurante.Entidades.Mesa;
//import Restaurante.Entidades.Produto;
//import Restaurante.Entidades.Funcionario;
//import Restaurante.Entidades.Comanda;
//import Restaurante.Entidades.StatusPedido;
//import Restaurante.Repositorios.RepoCliente;
//import Restaurante.Repositorios.RepoMesa;
//import Restaurante.Repositorios.RepoProduto;
//import Restaurante.Repositorios.RepoFuncionario;
//import Restaurante.Repositorios.RepoComanda;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//
//        RepoCliente repoCliente = new RepoCliente();
//        RepoMesa repoMesa = new RepoMesa();
//        RepoProduto repoProduto = new RepoProduto();
//        RepoFuncionario repoFuncionario = new RepoFuncionario();
//        RepoComanda repoComanda = new RepoComanda();
//
//
//        repoProduto.inicializarProdutos();
//
//         Adicionando algumas mesas
//        repoMesa.adicionar(new Mesa(4)); // Mesa para 4 pessoas
//        repoMesa.adicionar(new Mesa(2)); // Mesa para 2 pessoas
//
//         Adicionando alguns funcionários
//        repoFuncionario.adicionar(new Funcionario("Maria", "Garçonete", "123.456.789-00"));
//        repoFuncionario.adicionar(new Funcionario("José", "Cozinheiro", "987.654.321-00"));
//
//        System.out.println("=== Bem-vindo ao Restaurante ===");
//         Cliente chega e fornece dados
//        System.out.println("Cadastro de Cliente:");
//        System.out.print("Nome: ");
//        String nomeCliente = scanner.nextLine();
//        System.out.print("Telefone: ");
//        String telefoneCliente = scanner.nextLine();
//        System.out.print("Email: ");
//        String emailCliente = scanner.nextLine();
//        Cliente cliente = new Cliente(nomeCliente, telefoneCliente, emailCliente);
//        repoCliente.adicionar(cliente);
//        System.out.println("Cliente cadastrado com ID: " + cliente.getId());
//
//         Cliente escolhe mesa
//        System.out.println("\nMesas disponíveis:");
//        for (Mesa mesa : repoMesa.listar()) {
//            System.out.println(mesa);
//        }
//        int idMesa = -1;
//        while(true) {
//            System.out.print("Escolha o ID da mesa para se sentar: ");
//            if(scanner.hasNextInt()) {
//                idMesa = scanner.nextInt();
//                Mesa mesaEscolhida = repoMesa.buscarPorId(idMesa);
//                if(mesaEscolhida != null) {
//                    System.out.println("Mesa " + idMesa + " selecionada.");
//                    break;
//                } else {
//                    System.out.println("Mesa inválida, tente novamente.");
//                }
//            } else {
//                System.out.println("Entrada inválida. Digite um número.");
//                scanner.next(); // limpar entrada inválida
//            }
//        }
//        scanner.nextLine(); // limpar buffer
//
//         Criar comanda para o cliente e mesa
//        Comanda comanda = new Comanda(cliente.getId(), "Comanda do Cliente " + cliente.getNome(), idMesa, "Pedidos do cliente", 0.0);
//        repoComanda.adicionar(comanda);
//        System.out.println("Comanda criada com ID: " + comanda.getId());
//
//         Fazer pedido na comanda
//        boolean continuarPedido = true;
//        while(continuarPedido) {
//            System.out.println("\nCardápio:");
//            for (Produto produto : repoProduto.listar()) {
//                System.out.printf("Código: %d - %s - R$ %.2f%n", produto.getCodigo(), produto.getNome(), produto.getPreco());
//            }
//            System.out.print("Digite o código do produto para adicionar ao pedido: ");
//            int codigoProduto = -1;
//            if(scanner.hasNextInt()) {
//                codigoProduto = scanner.nextInt();
//                Produto produtoEscolhido = repoProduto.buscarPorCodigo(codigoProduto);
//                if(produtoEscolhido != null) {
//                     Atualiza valor da comanda
//                    comanda.setValor(comanda.getValor() + produtoEscolhido.getPreco());
//                    System.out.println(produtoEscolhido.getNome() + " adicionado à comanda.");
//                } else {
//                    System.out.println("Produto não encontrado. Tente novamente.");
//                    continue; // reinicia o loop para novo pedido
//                }
//            } else {
//                System.out.println("Entrada inválida. Digite um número.");
//                scanner.next(); // limpar entrada inválida
//                continue;
//            }
//
//            System.out.print("Deseja adicionar mais produtos? (s/n): ");
//            char resposta = scanner.next().charAt(0);
//            continuarPedido = (resposta == 's' || resposta == 'S');
//        }
//        scanner.nextLine(); // limpar buffer
//
//        System.out.printf("Pedido finalizado. Valor total da comanda: R$ %.2f%n", comanda.getValor());
//
//         Funcionario prepara e entrega o pedido
//        if(repoFuncionario.listar().isEmpty()) {
//            System.out.println("Nenhum funcionário disponível para preparar o pedido.");
//        } else {
//             Para simplificação, escolhe o primeiro funcionário da lista
//            Funcionario funcionario = repoFuncionario.listar().get(0);
//            System.out.println("Funcionário " + funcionario.getNome() + " está preparando o pedido...");
//            System.out.println("Pedido preparado e entregue ao cliente.");
//        }
//
//         Cliente paga a comanda
//        System.out.print("Digite o valor pago pelo cliente: R$ ");
//        double valorPago = scanner.nextDouble();
//
//        if(valorPago >= comanda.getValor()) {
//            System.out.println("Pagamento realizado com sucesso. Obrigado!");
//            System.out.println("Status do pedido: " + StatusPedido.PAGO);
//            double troco = valorPago - comanda.getValor();
//            if(troco > 0) {
//                System.out.printf("Troco a ser devolvido: R$ %.2f%n", troco);
//            }
//        } else {
//            System.out.println("Pagamento insuficiente. Informe o valor correto.");
//            System.out.println("Status do pedido: " + StatusPedido.NAO_PAGO);
//        }
//
//        System.out.println("Cliente pode se retirar. Volte sempre!");
//
//        scanner.close();
//    }
//}
//
//