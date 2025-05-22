package Restaurante.Servicos;

public class Pagamento {
    int idPagamento;
    int idCliente;
    int idRestaurante;
    int quantidade;
    double valor;
    int idmesa;

    public Pagamento(int idPagamento, int idCliente, int idRestaurante, int quantidade, double valor, int idmesa) {
        this.idPagamento = idPagamento;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.quantidade = quantidade;
        this.valor = valor;
        this.idmesa = idmesa;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }






}
