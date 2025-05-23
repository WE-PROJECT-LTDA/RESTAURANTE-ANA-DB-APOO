package Restaurante.Servicos;
import Restaurante.Entidades.StatusPedido;


public class Pedido {
    private int idPedido;
    private int idCliente;
    private String dataPedido;
    private StatusPedido statusPedido; //Enum
    private String descricaoPedido;

    public Pedido(int idPedido, int idCliente, String dataPedido, StatusPedido statusPedido, String desc) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.descricaoPedido = desc;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", idCliente=" + idCliente +
                ", dataPedido='" + dataPedido + '\'' +
                ", statusPedido=" + statusPedido +
                ", descricaoPedido='" + descricaoPedido + '\'' +
                '}';
    }
}
