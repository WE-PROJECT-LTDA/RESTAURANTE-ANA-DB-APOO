package Restaurante.Repositorios;

import java.util.List;

public interface IRepository<T> {
    void adicionar(T T);

    List<T> listar();

    T buscarPorId(int i);

    boolean remover(int i);
}
