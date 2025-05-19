package Entidades;

public class Comanda {
     String comanda;
     int codigo;
     String descricao;

    public Comanda(String comanda, int codigo, String descricao) {
        this.comanda = comanda;
        this.codigo = codigo;
        this.descricao = descricao;
    }
    public String getComanda() {
        return comanda;
    }
    public void setComanda(String comanda) {
        this.comanda = comanda;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
