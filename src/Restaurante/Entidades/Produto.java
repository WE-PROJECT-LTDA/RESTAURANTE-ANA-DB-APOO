package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private String nome;

    public Produto(int codigo,String descricao, double preco, String nome) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.nome = nome;
    }

    public Produto(String descricao, double preco, String nome) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\n=== Produto ===" +
                "\ncodigo    : " + codigo +
                "\nnome      : " + nome +
                "\ndescricao : " + descricao +
                "\npreco     : " + preco;
    }
}



