package modelo;

public class Produto {
    private String nome;
    private String unidade;
    private Categoria categoria;
    private double precoUnitario;
    private int quantidadeEstoque;
    private int quantidadeMinima;
    private int quantidadeMaxima;

    public Produto(String nome, String unidade, Categoria categoria, double precoUnitario, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima) {
        this.nome = nome;
        this.unidade = unidade;
        this.categoria = categoria;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    
    public void entrada(int quantidade){
        quantidadeEstoque += quantidade;
    }

    public void saida(int quantidade){
        quantidadeEstoque -= quantidade;
    }

    public double valorTotal(){
        return precoUnitario * quantidadeEstoque;
    }


}
