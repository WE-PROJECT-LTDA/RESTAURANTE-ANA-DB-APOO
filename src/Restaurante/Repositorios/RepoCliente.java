package Restaurante.Repositorios;

import Restaurante.Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class RepoCliente  {
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
