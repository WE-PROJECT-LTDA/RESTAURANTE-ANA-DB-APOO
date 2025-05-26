package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
     private static int proximoId = 1;
     private int id;
     private int idCliente;
     private String comanda;
     private String descricao;
     private int idMesa;
     private double valor;

     public Comanda(int idCliente, String comanda, int idMesa, String descricao, double valor) {
          this.id = proximoId++;
          this.idCliente = idCliente;
          this.comanda = comanda;
          this.idMesa = idMesa;
          this.descricao = descricao;
          this.valor = valor;
     }

     public Comanda(int idCliente, String descricao, int idMesa, double valor) {
     }

     public int getId() {
          return id;
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

     @Override
     public String toString() {
          return "Comanda{" +
                  "id=" + id +
                  ", idCliente=" + idCliente +
                  ", comanda='" + comanda + '\'' +
                  ", descricao='" + descricao + '\'' +
                  ", idMesa=" + idMesa +
                  ", valor=" + valor +
                  '}';
     }

     public void setId(int idComanda) {
     }

     //CRUD
     public static class ComandaRepositorio {
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
}
