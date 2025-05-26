package Restaurante.Entidades.Heranças;

import Restaurante.Entidades.Funcionario;

public class Garcom extends Funcionario {
    public Garcom(int id, String nome, String cpf) {
        super(id, nome, "Entrega", cpf);
    }
}
