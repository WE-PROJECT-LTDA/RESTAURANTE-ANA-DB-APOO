package Restaurante.Entidades;

public class Comanda {
     private int id;
     private int idCliente;
     private int idMesa;
     private double valor;

     public Comanda(int id, int idCliente, int idMesa, double valor) {
          this.id = id;
          this.idCliente = idCliente;
          this.idMesa = idMesa;
          this.valor = valor;
     }

     public Comanda(int idCliente, int idMesa, double valor) {
          this.idCliente = idCliente;
          this.idMesa = idMesa;
          this.valor = valor;
     }

     public int getId() {
          return id;
     }

     public void setId(int idComanda) {
          this.id = idComanda;
     }

     public int getIdCliente() {
          return idCliente;
     }

     public void setIdCliente(int idCliente) {
          this.idCliente = idCliente;
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

     @Override
     public String toString() {
          return "\n=== Comanda ===" +
                  "\nID        : " + id +
                  "\nidCliente : " + idCliente +
                  "\nidMesa    : " + idMesa +
                  "\nvalor     : " + valor;
     }
}
