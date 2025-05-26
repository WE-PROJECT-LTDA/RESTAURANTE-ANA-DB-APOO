package Restaurante;

import Restaurante.Entidades.Cliente;
import Restaurante.Entidades.Heranças.Cozinheiro;
import Restaurante.Entidades.Heranças.Garcom;
import Restaurante.Entidades.Mesa;
import Restaurante.Entidades.Produto;
import Restaurante.Entidades.Funcionario;
import Restaurante.Entidades.Comanda;
import Restaurante.Entidades.StatusPedido;
import Restaurante.Repositorios.RepoCliente;
import Restaurante.Repositorios.RepoMesa;
import Restaurante.Repositorios.RepoProduto;
import Restaurante.Repositorios.RepoFuncionario;
import Restaurante.Repositorios.RepoComanda;

import java.util.Scanner;

import Restaurante.Entidades.*;
import Restaurante.Entidades.Heranças.Cozinheiro;
import Restaurante.Entidades.Heranças.Garcom;
import Restaurante.Repositorios.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RepoCliente repoCliente = new RepoCliente();
        RepoMesa repoMesa = new RepoMesa();
        RepoProduto repoProduto = new RepoProduto();
        RepoFuncionario repoFuncionario = new RepoFuncionario();
        RepoComanda repoComanda = new RepoComanda();

        // Inicializar produtos no banco de dados

        // Adicionando algumas mesas no banco de dados
        repoMesa.adicionar(new Mesa(4)); // Mesa para 4 pessoas
        repoMesa.adicionar(new Mesa(2)); // Mesa para 2 pessoas

        repoFuncionario.adicionar(new Funcionario("Maria", "Entrega", "12345678900"));
        repoFuncionario.adicionar(new Funcionario("José", "Cozinha", "98765432100"));

        System.out.println("=== Bem-vindo ao Restaurante ===");

        // Cadastro de Cliente
        System.out.println("Cadastro de Cliente:");
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefoneCliente = scanner.nextLine();
        System.out.print("Email: ");
        String emailCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente, emailCliente);
        repoCliente.adicionar(cliente);
        cliente = repoCliente.buscarUltimoInserido();

        // Cliente escolhe mesa
        System.out.println("\nMesas disponíveis:");
        System.out.println(repoMesa.listar());
        int idMesa = 0;
        while (true) {
            System.out.print("Escolha o ID da mesa para se sentar: ");
            if (scanner.hasNextInt()) {
                idMesa = scanner.nextInt();
                Mesa mesaEscolhida = repoMesa.buscarPorId(idMesa);
                if (mesaEscolhida != null) {
                    System.out.println("Mesa " + idMesa + " selecionada.");
                    break;
                } else {
                    System.out.println("Mesa inválida, tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // limpar entrada inválida
            }
        }
        scanner.nextLine(); // limpar buffer

        // Criar comanda para o cliente e mesa
        Comanda comanda = new Comanda(cliente.getId(), idMesa, 0.0);
        repoComanda.adicionar(comanda); // Adiciona comanda ao banco de dados
        System.out.println("Comanda criada com ID: " + comanda.getId());

        // Fazer pedido na comanda
        boolean continuarPedido = true;
        while (continuarPedido) {
            System.out.println("\nCardápio:");
            for (Produto produto : repoProduto.listar()) {
                System.out.printf("Código: %d - %s - R$ %.2f%n", produto.getCodigo(), produto.getNome(), produto.getPreco());
            }
            System.out.print("Digite o código do produto para adicionar ao pedido: ");
            int codigoProduto = -1;
            if (scanner.hasNextInt()) {
                codigoProduto = scanner.nextInt();
                Produto produtoEscolhido = repoProduto.buscarPorId(codigoProduto);
                if (produtoEscolhido != null) {
                    // Atualiza valor da comanda
                    comanda.setValor(comanda.getValor() + produtoEscolhido.getPreco());
                    System.out.println(produtoEscolhido.getNome() + " adicionado à comanda.");
                } else {
                    System.out.println("Produto não encontrado. Tente novamente.");
                    continue; // reinicia o loop para novo pedido
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // limpar entrada inválida
                continue;
            }

            System.out.print("Deseja adicionar mais produtos? (s/n): ");
            char resposta = scanner.next().charAt(0);
            continuarPedido = (resposta == 's' || resposta == 'S');
        }
        scanner.nextLine(); // limpar buffer

        System.out.printf("Pedido finalizado. Valor total da comanda: R$ %.2f%n", comanda.getValor());

        // Funcionário prepara e entrega o pedido
        if (repoFuncionario.listar().isEmpty()) {
            System.out.println("Nenhum funcionário disponível para preparar o pedido.");
        } else {
            // Para simplificação, escolhe o primeiro funcionário da lista
            Funcionario funcionario = repoFuncionario.listar().get(0);
            System.out.println("Funcionário " + funcionario.getNome() + " está preparando o pedido...");
            System.out.println("Pedido preparado e entregue ao cliente.");
        }

        // Cliente paga a comanda
        System.out.print("Digite o valor pago pelo cliente: R$ ");
        double valorPago = scanner.nextDouble();

        if (valorPago >= comanda.getValor()) {
            System.out.println("Pagamento realizado com sucesso. Obrigado!");
            System.out.println("Status do pedido: " + StatusPedido.PAGO);
            double troco = valorPago - comanda.getValor();
            if (troco > 0) {
                System.out.printf("Troco a ser devolvido: R$ %.2f%n", troco);
            }
        } else {
            System.out.println("Pagamento insuficiente. Informe o valor correto.");
            System.out.println("Status do pedido: " + StatusPedido.NAO_PAGO);
        }

        System.out.println("Cliente pode se retirar. Volte sempre!");

        scanner.close();
    }
}

class Testeconexao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RepoProduto repoProduto = new RepoProduto();
        RepoMesa mesa = new RepoMesa();
        RepoComanda comanda = new RepoComanda();
        RepoCliente cliente = new RepoCliente();
        RepoFuncionario funcionario = new RepoFuncionario();

        int i = 0;

        while (i != 6) {
            System.out.println("\n=== Sistema do Restaurante ===");
            System.out.println("[1] Listar produtos");
            System.out.println("[2] Listar mesas");
            System.out.println("[3] Listar comandas");
            System.out.println("[4] Listar clientes");
            System.out.println("[5] Listar funcionários");
            System.out.println("[6] Sair");
            System.out.print("R = ");

            i = sc.nextInt();
            sc.nextLine();

            switch (i) {
                case 1:
                    System.out.println("\n== Produtos Cadastrados ==");
                    System.out.println(repoProduto.listar());

                    int o = 0;
                    while (o != 5) {
                        System.out.println("\n== Menu de Produtos ==");
                        System.out.println("[1] Listar Produtos");
                        System.out.println("[2] Deletar Produto");
                        System.out.println("[3] Buscar Produto Específico");
                        System.out.println("[4] Atualizar Produto");
                        System.out.println("[5] Inserir Novo Produto");
                        System.out.println("[6] Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        o = sc.nextInt();
                        sc.nextLine();

                        switch (o) {
                            case 1:
                                System.out.println("\n== Produtos Cadastrados ==");
                                System.out.println(repoProduto.listar());
                                break;
                            case 2:
                                System.out.print("ID do produto para deletar: ");
                                int idDel = sc.nextInt();
                                sc.nextLine();
                                repoProduto.remover(idDel);
                                System.out.println("Produto removido com sucesso!");
                                break;
                            case 3:
                                System.out.print("Código do produto: ");
                                int codigo = sc.nextInt();
                                sc.nextLine();
                                Produto p = repoProduto.buscarPorId(codigo);
                                if (p == null) {
                                    System.out.println("❌ Produto com código " + codigo + " não encontrado.");
                                } else {
                                    System.out.println("✅ Produto encontrado:\n" + p);
                                }
                                break;
                            case 4:
                                System.out.print("ID do produto para atualizar: ");
                                int idUpdate = sc.nextInt();
                                sc.nextLine();
                                Produto existente = repoProduto.buscarPorId(idUpdate);
                                if (existente == null) {
                                    System.out.println("❌ Produto não encontrado.");
                                } else {
                                    System.out.print("Novo nome: ");
                                    String nome = sc.nextLine();
                                    System.out.print("Novo preço: ");
                                    double preco = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.print("Nova descrição: ");
                                    String descricao = sc.nextLine();
                                    repoProduto.atualizar(idUpdate, nome, preco, descricao);
                                    System.out.println("✅ Produto atualizado!");
                                }
                                break;
                            case 5:
                                System.out.print("Nome do produto: ");
                                String nome = sc.nextLine();
                                System.out.print("Preço do produto: ");
                                double preco = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Descrição do produto: ");
                                String descricao = sc.nextLine();
                                Produto novo = new Produto(nome, preco, descricao);
                                repoProduto.adicionar(novo);
                                System.out.println("✅ Produto inserido!");
                                break;
                            case 6:
                                System.out.println("Retornando ao menu principal...");
                                break;
                            default:
                                System.out.println("❗ Opção inválida.");
                        }
                        break;
                    }
                    break;
                case 2:
                    int m = 0;
                    while (m != 5) {
                        System.out.println("\n== Menu de Mesas ==");
                        System.out.println("[1] Listar Mesas");
                        System.out.println("[2] Inserir Nova Mesa");
                        System.out.println("[3] Remover Mesa");
                        System.out.println("[4] Buscar Mesa por Código");
                        System.out.println("[5] Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        m = sc.nextInt();
                        sc.nextLine(); // limpar buffer

                        switch (m) {
                            case 1:
                                System.out.println("\n== Mesas Cadastradas ==");
                                System.out.println(mesa.listar());
                                break;

                            case 2:
                                System.out.print("Capacidade: ");
                                int capacidade = sc.nextInt();
                                sc.nextLine();
                                Mesa novaMesa = new Mesa(capacidade); // id será gerado no banco
                                mesa.adicionar(novaMesa);
                                System.out.println("✅ Mesa inserida com sucesso!");
                                break;

                            case 3:
                                System.out.print("Código da mesa para remover: ");
                                int idRemover = sc.nextInt();
                                sc.nextLine();
                                mesa.remover(idRemover);
                                System.out.println("✅ Mesa removida com sucesso!");
                                break;

                            case 4:
                                System.out.print("Código da mesa para buscar: ");
                                int idBuscar = sc.nextInt();
                                sc.nextLine();
                                Mesa mesaEncontrada = mesa.buscarPorId(idBuscar);
                                if (mesaEncontrada != null) {
                                    System.out.println("✅ Mesa encontrada:\n" + mesaEncontrada);
                                } else {
                                    System.out.println("❌ Mesa com código " + idBuscar + " não encontrada.");
                                }
                                break;

                            case 5:
                                System.out.println("Retornando ao menu principal...");
                                break;

                            default:
                                System.out.println("❗ Opção inválida.");
                        }
                        break;
                    }
                    break;


                case 3:
                    int c = 0;
                    while (c != 6) {
                        System.out.println("\n== Menu de Comandas ==");
                        System.out.println("[1] Listar Comandas");
                        System.out.println("[2] Criar Nova Comanda");
                        System.out.println("[3] Remover Comanda");
                        System.out.println("[4] Buscar Comanda por Código");
                        System.out.println("[5] Atualizar Comanda");
                        System.out.println("[6] Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        c = sc.nextInt();
                        sc.nextLine();

                        switch (c) {
                            case 1:
                                System.out.println("\n== Comandas Cadastradas ==");
                                System.out.println(comanda.listar());
                                break;

                            case 2:
                                System.out.print("ID do Cliente: ");
                                int idCliente = sc.nextInt();
                                System.out.print("ID do Funcionário: ");
                                int idFuncionario = sc.nextInt();
                                System.out.print("ID da Mesa: ");
                                int idMesa = sc.nextInt();
                                sc.nextLine();

                                Comanda novaComanda = new Comanda(idCliente, idFuncionario, idMesa);
                                comanda.adicionar(novaComanda);
                                System.out.println("✅ Comanda criada com sucesso!");
                                break;

                            case 3:
                                System.out.print("Código da comanda para remover: ");
                                int idRemover = sc.nextInt();
                                comanda.remover(idRemover);
                                System.out.println("✅ Comanda removida com sucesso!");
                                break;

                            case 4:
                                System.out.print("Código da comanda para buscar: ");
                                int idBuscar = sc.nextInt();
                                Comanda comandaEncontrada = comanda.buscarPorId(idBuscar);
                                if (comandaEncontrada != null) {
                                    System.out.println("✅ Comanda encontrada:\n" + comandaEncontrada);
                                } else {
                                    System.out.println("❌ Comanda com código " + idBuscar + " não encontrada.");
                                }
                                break;

                            case 5:
                                System.out.print("Código da comanda para atualizar: ");
                                int idAtualizar = sc.nextInt();
                                Comanda comandaExistente = comanda.buscarPorId(idAtualizar);
                                if (comandaExistente != null) {
                                    System.out.print("Novo ID do Cliente: ");
                                    int novoCliente = sc.nextInt();
                                    System.out.print("Novo ID da Mesa: ");
                                    int novaMesa = sc.nextInt();
                                    System.out.print("Novo valor da Comanda: ");
                                    int valor = sc.nextInt();
                                    sc.nextLine();

                                    comanda.atualizar(idAtualizar, novoCliente, novaMesa, valor);
                                    System.out.println("✅ Comanda atualizada com sucesso!");
                                } else {
                                    System.out.println("❌ Comanda não encontrada.");
                                }
                                break;

                            case 6:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("❗ Opção inválida.");
                        }
                        break;
                    }
                    break;


                case 4:
                    int cli = 0;
                    while (cli != 6) {
                        System.out.println("\n== Menu de Clientes ==");
                        System.out.println("[1] Listar Clientes");
                        System.out.println("[2] Inserir Novo Cliente");
                        System.out.println("[3] Remover Cliente");
                        System.out.println("[4] Buscar Cliente por ID");
                        System.out.println("[5] Atualizar Cliente");
                        System.out.println("[6] Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        cli = sc.nextInt();
                        sc.nextLine(); // limpar buffer

                        switch (cli) {
                            case 1:
                                System.out.println("\n== Clientes Cadastrados ==");
                                System.out.println(cliente.listar());
                                break;

                            case 2:
                                System.out.print("Nome: ");
                                String nome = sc.nextLine();
                                System.out.print("Telefone: ");
                                String telefone = sc.nextLine();
                                System.out.print("Email: ");
                                String email = sc.nextLine();

                                Cliente novoCliente = new Cliente(nome, telefone, email);
                                cliente.adicionar(novoCliente);
                                System.out.println("✅ Cliente inserido com sucesso!");
                                break;

                            case 3:
                                System.out.print("ID do cliente para remover: ");
                                int idRemover = sc.nextInt();
                                cliente.remover(idRemover);
                                System.out.println("✅ Cliente removido com sucesso!");
                                break;

                            case 4:
                                System.out.print("ID do cliente para buscar: ");
                                int idBuscar = sc.nextInt();
                                Cliente clienteEncontrado = cliente.buscarPorId(idBuscar);
                                if (clienteEncontrado != null) {
                                    System.out.println("✅ Cliente encontrado:\n" + clienteEncontrado);
                                } else {
                                    System.out.println("❌ Cliente com ID " + idBuscar + " não encontrado.");
                                }
                                break;

                            case 5:
                                System.out.print("ID do cliente para atualizar: ");
                                int idAtualizar = sc.nextInt();
                                sc.nextLine(); // limpar buffer
                                Cliente existente = cliente.buscarPorId(idAtualizar);
                                if (existente != null) {
                                    System.out.print("Novo nome: ");
                                    String novoNome = sc.nextLine();
                                    System.out.print("Novo telefone: ");
                                    String novoTelefone = sc.nextLine();
                                    System.out.print("Novo email: ");
                                    String novoEmail = sc.nextLine();
                                    cliente.atualizar(idAtualizar, novoNome, novoTelefone, novoEmail);
                                    System.out.println("✅ Cliente atualizado com sucesso!");
                                } else {
                                    System.out.println("❌ Cliente com ID " + idAtualizar + " não encontrado.");
                                }
                                break;

                            case 6:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("❗ Opção inválida.");
                        }
                        break;
                    }
                    break;


                case 5:
                    int func = 0;
                    while (func != 6) {
                        System.out.println("\n== Menu de Funcionários ==");
                        System.out.println("[1] Listar Funcionários");
                        System.out.println("[2] Inserir Novo Funcionário");
                        System.out.println("[3] Remover Funcionário");
                        System.out.println("[4] Buscar Funcionário por ID");
                        System.out.println("[5] Atualizar Funcionário");
                        System.out.println("[6] Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        func = sc.nextInt();
                        sc.nextLine(); // Limpar buffer

                        switch (func) {
                            case 1:
                                System.out.println("\n== Funcionários Cadastrados ==");
                                System.out.println(funcionario.listar());
                                break;

                            case 2:
                                System.out.print("Nome: ");
                                String nome = sc.nextLine();

                                System.out.print("Cargo ([1] Garçom, [2] Cozinheiro): ");
                                int tipoCargo = sc.nextInt();
                                sc.nextLine(); // limpar buffer

                                System.out.print("Salário: ");
                                double salario = sc.nextDouble();
                                sc.nextLine(); // limpar buffer

                                Funcionario novoFuncionario = null;
                                if (tipoCargo == 1) {
                                    novoFuncionario = new Garcom(0, nome, "Garçom");
                                } else if (tipoCargo == 2) {
                                    novoFuncionario = new Cozinheiro(0, nome, "Cozinheiro");
                                } else {
                                    System.out.println("❌ Cargo inválido. Funcionário não inserido.");
                                    break;
                                }

                                funcionario.adicionar(novoFuncionario);
                                System.out.println("✅ Funcionário inserido com sucesso!");
                                break;

                            case 3:
                                System.out.print("ID do funcionário para remover: ");
                                int idRemover = sc.nextInt();
                                funcionario.remover(idRemover);
                                System.out.println("✅ Funcionário removido com sucesso!");
                                break;

                            case 4:
                                System.out.print("ID do funcionário para buscar: ");
                                int idBuscar = sc.nextInt();
                                Funcionario funcionarioEncontrado = funcionario.buscarPorId(idBuscar);
                                if (funcionarioEncontrado != null) {
                                    System.out.println("✅ Funcionário encontrado:\n" + funcionarioEncontrado);
                                } else {
                                    System.out.println("❌ Funcionário com ID " + idBuscar + " não encontrado.");
                                }
                                break;

                            case 5:
                                System.out.print("ID do funcionário para atualizar: ");
                                int idAtualizar = sc.nextInt();
                                sc.nextLine(); // limpar buffer
                                Funcionario existente = funcionario.buscarPorId(idAtualizar);

                                if (existente != null) {
                                    System.out.println("Funcionário atual: " + existente);
                                    System.out.print("Novo nome: ");
                                    String novoNome = sc.nextLine();
                                    System.out.print("Novo cargo ([1] Garçom, [2] Cozinheiro): ");
                                    int novoCargoTipo = sc.nextInt();
                                    System.out.print("Novo CPF: ");
                                    String novoCpf = sc.nextLine();

                                    sc.nextLine(); // limpar buffer

                                    Funcionario atualizado = null;
                                    String cargo = "";
                                    if (novoCargoTipo == 1) {
                                        cargo = "Garçom";
                                    } else if (novoCargoTipo == 2) {
                                        cargo = "Cozinheiro";
                                    } else {
                                        System.out.println("❌ Cargo inválido. Funcionário não atualizado.");
                                        break;
                                    }

                                    funcionario.atualizar(idAtualizar, novoCpf, cargo, novoCpf);

                                    System.out.println("✅ Funcionário atualizado com sucesso!");
                                } else {
                                    System.out.println("❌ Funcionário com ID " + idAtualizar + " não encontrado.");
                                }
                                break;

                            case 6:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("❗ Opção inválida.");
                        }
                    }
                    break;


                case 6:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("❗ Opção inválida.");
            }
        }

    }
}

