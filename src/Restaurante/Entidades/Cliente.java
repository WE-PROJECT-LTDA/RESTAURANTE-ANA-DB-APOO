package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int codCliente) {
        this.id = codCliente;
    }

    @Override
    public String toString() {
        return "\n=== Cliente ===" +
                "\nID       : " + id +
                "\nNome     : " + nome +
                "\nTelefone : " + telefone +
                "\nEmail    : " + email;
    }
}
