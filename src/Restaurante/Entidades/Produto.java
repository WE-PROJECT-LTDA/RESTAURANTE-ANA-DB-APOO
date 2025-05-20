package Restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private static int proximoCodigo = 1;
    private int codigo;
    private String descricao;
    private double preco;
    private String nome;

    public Produto(String descricao, double preco, String nome) {
        this.codigo = proximoCodigo++;
        this.descricao = descricao;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }

    //CRUD
    public static class ProdutoRepositorio {
        private List<Produto> produtos = new ArrayList<>();

        // Create - adicionar produto
        public void adicionar(Produto produto) {
            produtos.add(produto);
        }


        public List<Produto> listar() {
            return new ArrayList<>(produtos);
        }


        public Produto buscarPorCodigo(int codigo) {
            for (Produto p : produtos) {
                if (p.getCodigo() == codigo) {
                    return p;
                }
            }
            return null;
        }


        public boolean atualizar(int codigo, String novaDescricao, double novoPreco, String novoNome) {
            Produto produto = buscarPorCodigo(codigo);
            if (produto != null) {
                if (novaDescricao != null && !novaDescricao.trim().isEmpty()) produto.setDescricao(novaDescricao);
                if (novoPreco >= 0) produto.setPreco(novoPreco);
                if (novoNome != null && !novoNome.trim().isEmpty()) produto.setNome(novoNome);
                return true;
            }
            return false;
        }


        public boolean remover(int codigo) {
            Produto produto = buscarPorCodigo(codigo);
            if (produto != null) {
                produtos.remove(produto);
                return true;
            }
            return false;
        }

        //Cardápio
        public void inicializarProdutos() {
            adicionar(new Produto("Pizza Margherita", 35.00, "Pizza com molho de tomate e queijo"));
            adicionar(new Produto("Coxinha", 8.50, "Coxinha de frango desfiado"));
            adicionar(new Produto("Refrigerante", 5.00, "Refrigerante de cola"));
            adicionar(new Produto("Hambúrguer", 25.00, "Hambúrguer com queijo e bacon"));
            adicionar(new Produto("Batata Frita", 12.00, "Porção de batata frita crocante"));
            adicionar(new Produto("Salada Caesar", 18.50, "Salada com frango grelhado e molho Caesar"));
            adicionar(new Produto("Suco Natural", 7.00, "Suco de laranja natural"));
            adicionar(new Produto("Lasanha", 40.00, "Lasanha de carne com queijo"));
            adicionar(new Produto("Espaguete", 30.00, "Espaguete ao molho de tomate"));
            adicionar(new Produto("Sorvete", 10.00, "Sorvete de creme com calda de chocolate"));
        }
    }
}
