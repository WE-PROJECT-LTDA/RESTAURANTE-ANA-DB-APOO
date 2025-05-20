package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

class Funcionario {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String cargo;
    private String cpf;

    public Funcionario(String nome, String cargo, String cpf) {
        this.id = proximoId++;
        this.nome = nome;
        this.cargo = cargo;
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

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    //CRUDZIN
    public static class FuncionarioRepositorio {
        private List<Funcionario> funcionarios = new ArrayList<>();

        // Create - adicionar funcionário
        public void adicionar(Funcionario funcionario) {
            funcionarios.add(funcionario);
        }


        public List<Funcionario> listar() {
            return new ArrayList<>(funcionarios); // retorna cópia para evitar modificação externa
        }


        public Funcionario buscarPorId(int id) {
            for (Funcionario f : funcionarios) {
                if (f.getId() == id) {
                    return f;
                }
            }
            return null;
        }


        public boolean atualizar(int id, String novoNome, String novoCargo, String novoCpf) {
            Funcionario funcionario = buscarPorId(id);
            if (funcionario != null) {
                if (novoNome != null && !novoNome.trim().isEmpty()) funcionario.setNome(novoNome);
                if (novoCargo != null && !novoCargo.trim().isEmpty()) funcionario.setCargo(novoCargo);
                if (novoCpf != null && !novoCpf.trim().isEmpty()) funcionario.setCpf(novoCpf);
                return true;
            }
            return false;
        }


        public boolean remover(int id) {
            Funcionario funcionario = buscarPorId(id);
            if (funcionario != null) {
                funcionarios.remove(funcionario);
                return true;
            }
            return false;
        }
    }
}
