package Restaurante.Entidades.Heranças;

import Restaurante.Entidades.Funcionario;

public class Cozinheiro extends Funcionario {
    public Cozinheiro(int id, String nome, String cpf) {
        super(id, nome, "Cozinha", cpf);
    }
}
