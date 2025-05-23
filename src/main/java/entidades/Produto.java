package entidades;

public class Produto {
    private String nome;
    private int quantidadeMinima;
    private int quantidadeMaxima;
    private int quantidadeTotal;
    private double preco;
    private Categoria categoria;

    public Produto(String nome, int quantidadeMinima, int quantidadeMaxima, int quantidadeTotal, double preco, Categoria categoria) {
        this.nome = nome;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.quantidadeTotal = quantidadeTotal;
        this.preco = preco;
        this.categoria = categoria;
    }

    

    public void entrada(int quantidade){
        quantidadeTotal += quantidade;
    }

    public void saida(int quantidade){
        quantidadeTotal -= quantidade;
    }

    public double valorTotal(){
        return preco * quantidadeTotal;
    }


}
