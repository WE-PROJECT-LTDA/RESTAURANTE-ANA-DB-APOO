package Restaurante.Entidades;

public abstract class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private String cpf;

    public Funcionario(int id, String nome, String cargo, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public Funcionario(String nome, String cargo, String cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\n=== Funcionario ===" +
                "\nID      : " + id +
                "\nnome    : " + nome +
                "\ncargo   : " + cargo +
                "\ncpf     : " + cpf;
    }
}
