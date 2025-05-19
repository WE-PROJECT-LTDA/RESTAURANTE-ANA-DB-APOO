package Entidades;

public class Funcionario {
     String nome;
     String funcao;
     String telefone;



    public Funcionario(String nome, String funcao, String telefone) {
        this.nome = nome;
        this.funcao = funcao;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
