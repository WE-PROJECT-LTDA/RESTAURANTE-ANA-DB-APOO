package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private static int proximoId = 1;
    private int idMesa;
    private int capacidade;

    public Mesa(int capacidade) {
        this.idMesa = proximoId++;
        this.capacidade = capacidade;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "idMesa=" + idMesa +
                ", capacidade=" + capacidade +
                '}';
    }

    //CRUD
    public static class MesaRepositorio {
        private List<Mesa> mesas = new ArrayList<>();


        public void adicionar(Mesa mesa) {
            mesas.add(mesa);
        }


        public List<Mesa> listar() {
            return new ArrayList<>(mesas);
        }


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
}
