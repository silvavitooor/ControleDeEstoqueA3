package entidades;

public class Produto {
    private String nome;
    private String categoria;
    private int quantidadeMinima;
    private int quantidadeMaxima;
    private int quantidadeTotal;
    private double preco;

    public Produto(String nome, String categoria, int quantidadeMinima, int quantidadeMaxima, int quantidadeTotal, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.quantidadeTotal = quantidadeTotal;
        this.preco = preco;
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
