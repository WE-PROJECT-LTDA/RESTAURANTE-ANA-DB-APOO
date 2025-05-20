package Restaurante.Entidades;

class Cliente {
    private static int proximoId = 1;
     int id;
     String nome;
     String telefone;
     String email;
    public Cliente(String nome, String telefone, String email) {
        this.email = email;
        this.id = proximoId++;
        this.nome = nome;
        this.telefone = telefone;
    }
    public int getId() { return id;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public static int getProximoId() {
        return proximoId;
    }
    public static void setProximoId(int proximoId) {
        Cliente.proximoId = proximoId;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}