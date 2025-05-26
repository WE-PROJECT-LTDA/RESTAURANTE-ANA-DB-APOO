package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int idMesa;
    private int capacidade;

    public Mesa(int id, int capacidade) {
        this.idMesa = id;
        this.capacidade = capacidade;
    }

    public Mesa(int capacidade) {
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
        return "\n=== Mesa ===" +
                "\nidMesa     : " + idMesa +
                "\ncapacidade : " + capacidade;
    }
}
