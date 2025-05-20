package Restaurante.Entidades;

public class Mesa {
    int idMesa;
    int Capacidade;

    public Mesa(int idMesa, int Capacidade) {
        this.idMesa = idMesa;
        this.Capacidade = Capacidade;
    }
    public int getIdMesa() {
        return idMesa;

    }
    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    public int getCapacidade() {
        return Capacidade;
    }
    public void setCapacidade(int Capacidade) {
        this.Capacidade = Capacidade;
    }


}
