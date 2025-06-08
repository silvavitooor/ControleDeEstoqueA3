package model;

public class Produto {
    private int id;
    private String nome;
    private int qtdMinima;
    private int qtdMaxima;
    private int qtdAtual;
    private String unidadeMedida;
    private double preco;
    private Categoria categoria;

        public Produto(int id, String nome, Categoria categoria, String unidadeMedida,double preco,int qtdAtual, int qtdMinima, int qtdMaxima ) {
        this.id = id;
        this.nome = nome;
        this.qtdMinima = qtdMinima;
        this.qtdMaxima = qtdMaxima;
        this.qtdAtual = qtdAtual;
        this.unidadeMedida = unidadeMedida;
        this.preco = preco;
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.qtdMinima = quantidadeMinima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.qtdMaxima = quantidadeMaxima;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.qtdAtual = quantidadeTotal;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    

    public void entrada(int quantidade){
        qtdAtual += quantidade;
    }

    public void saida(int quantidade){
        qtdAtual -= quantidade;
    }

    public double valorAtual(){
        return preco * qtdAtual;
    }
    
    @Override
    public String toString(){
        return nome + "(" + unidadeMedida +") -R$ " + preco;
    }


}
