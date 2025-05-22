package Restaurante.Repositorios;

import Restaurante.Entidades.Mesa;
import java.util.ArrayList;
import java.util.List;

public class RepoMesa {
    private List<Mesa> mesas = new ArrayList<>();


    public void adicionar(Mesa mesa) {
        mesas.add(mesa);
    }


    public List<Mesa> listar() {
        return new ArrayList<>(mesas);
    }

    // Busca uma mesa pelo ID
    public Mesa buscarPorId(int idMesa) {
        for (Mesa m : mesas) {
            if (m.getIdMesa() == idMesa) {
                return m;
            }
        }
        return null;
    }


    public boolean atualizar(int idMesa, int novaCapacidade) {
        Mesa mesa = buscarPorId(idMesa);
        if (mesa != null) {
            if (novaCapacidade > 0) mesa.setCapacidade(novaCapacidade);
            return true;
        }
        return false;
    }


    public boolean remover(int idMesa) {
        Mesa mesa = buscarPorId(idMesa);
        if (mesa != null) {
            mesas.remove(mesa);
            return true;
        }
        return false;
    }
}
