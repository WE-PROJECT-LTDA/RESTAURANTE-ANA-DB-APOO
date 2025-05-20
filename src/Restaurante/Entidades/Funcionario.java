package Restaurante.Entidades;
class Funcionario {
     static int proximoId = 1;
     int id;
     String nome;
     String cargo;
     String cpf;

    public Funcionario(String nome, String cargo, int id, String cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.id = id;
        this.cpf = cpf;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Funcionario.proximoId = proximoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}