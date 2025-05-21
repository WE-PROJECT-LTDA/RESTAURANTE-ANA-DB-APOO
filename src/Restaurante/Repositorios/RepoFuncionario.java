package Restaurante.Repositorios;

import Restaurante.Entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class RepoFuncionario {
    private List<Funcionario> funcionarios = new ArrayList<>();


    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }


    public List<Funcionario> listar() {
        return new ArrayList<>(funcionarios);
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
