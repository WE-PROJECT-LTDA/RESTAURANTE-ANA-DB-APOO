package Entidades;
class Funcionario {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.id = proximoId++;
        this.nome = nome;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{id=" + id + ", nome='" + nome + "', cargo='" + cargo + "'}";
    }
}