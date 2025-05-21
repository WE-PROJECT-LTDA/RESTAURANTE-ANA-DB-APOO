package Restaurante.Repositorios;

import Restaurante.Entidades.Comanda;
import java.util.ArrayList;
import java.util.List;

public class RepoComanda {
    private List<Comanda> comandas = new ArrayList<>();


    public void adicionar(Comanda comanda) {
        comandas.add(comanda);
    }


    public List<Comanda> listar() {
        return new ArrayList<>(comandas);
    }


    public Comanda buscarPorId(int id) {
        for (Comanda c : comandas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }


    public boolean atualizar(int id, int novoIdCliente, String novaComanda, int novoIdMesa, String novaDescricao, double novoValor) {
        Comanda comanda = buscarPorId(id);
        if (comanda != null) {
            if (novoIdCliente > 0) comanda.setIdCliente(novoIdCliente);
            if (novaComanda != null && !novaComanda.trim().isEmpty()) comanda.setComanda(novaComanda);
            if (novoIdMesa > 0) comanda.setIdMesa(novoIdMesa);
            if (novaDescricao != null && !novaDescricao.trim().isEmpty()) comanda.setDescricao(novaDescricao);
            if (novoValor >= 0) comanda.setValor(novoValor);
            return true;
        }
        return false;
    }


    public boolean remover(int id) {
        Comanda comanda = buscarPorId(id);
        if (comanda != null) {
            comandas.remove(comanda);
            return true;
        }
        return false;
    }
}
