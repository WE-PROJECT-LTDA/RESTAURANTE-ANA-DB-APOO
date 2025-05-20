package Restaurante.Entidades;

public class Comanda {
     int idCliente;
     String comanda;
     String descricao;
     int idMesa;
     double valor;

     public Comanda(int idCliente, String comanda, int idMesa, String descricao, double valor) {
          this.idCliente = idCliente;
          this.comanda = comanda;
          this.idMesa = idMesa;
          this.descricao = descricao;
          this.valor = valor;
     }

     public int getIdCliente() {
          return idCliente;
     }

     public void setIdCliente(int idCliente) {
          this.idCliente = idCliente;
     }

     public String getComanda() {
          return comanda;
     }

     public void setComanda(String comanda) {
          this.comanda = comanda;
     }

     public String getDescricao() {
          return descricao;
     }

     public void setDescricao(String descricao) {
          this.descricao = descricao;
     }

     public int getIdMesa() {
          return idMesa;
     }

     public void setIdMesa(int idMesa) {
          this.idMesa = idMesa;
     }

     public double getValor() {
          return valor;
     }

     public void setValor(double valor) {
          this.valor = valor;
     }
}
