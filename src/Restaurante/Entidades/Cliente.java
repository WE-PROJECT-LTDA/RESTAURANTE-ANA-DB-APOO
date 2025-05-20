package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(String nome, String telefone, String email) {
        this.id = proximoId++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public static int getProximoId() { return proximoId; }
    public static void setProximoId(int proximoId) { Cliente.proximoId = proximoId; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // CRUD que ela pediu
    public static class ClienteRepositorio {
        private List<Cliente> clientes = new ArrayList<>();


        public void adicionar(Cliente cliente) {
            clientes.add(cliente);
        }


        public List<Cliente> listar() {
            return new ArrayList<>(clientes);
        }


        public Cliente buscarPorId(int id) {
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    return c;
                }
            }
            return null;
        }


        public boolean atualizar(int id, String novoNome, String novoTelefone, String novoEmail) {
            Cliente cliente = buscarPorId(id);
            if (cliente != null) {
                if (novoNome != null && !novoNome.trim().isEmpty()) cliente.setNome(novoNome);
                if (novoTelefone != null && !novoTelefone.trim().isEmpty()) cliente.setTelefone(novoTelefone);
                if (novoEmail != null && !novoEmail.trim().isEmpty()) cliente.setEmail(novoEmail);
                return true;
            }
            return false;
        }
        public boolean remover(int id) {
            Cliente cliente = buscarPorId(id);
            if (cliente != null) {
                clientes.remove(cliente);
                return true;
            }
            return false;
        }
    }
}
