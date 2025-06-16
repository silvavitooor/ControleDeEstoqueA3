package modelo;

public class Produto {
    private int id;
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

    public Produto() {
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
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
