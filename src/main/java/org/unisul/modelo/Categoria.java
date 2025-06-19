package org.unisul.modelo;

public class Categoria {
    private String nome;
    private int id;

    public Categoria() {
    }

    
    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(int Int, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
