package controller;
import model.Produto;
import java.util.ArrayList;

public class ProdutoController {
    private ArrayList<Produto> listaProdutos;
    
    public ProdutoController(){
            listaProdutos = new ArrayList<>();
}
    
public void adicionarProduto(Produto p){
    listaProdutos.add(p);
    System.out.println("Produto Adicionado: " + p.getNome());
}

public Produto buscarProduto(int id){
    for (Produto p : listaProdutos){
        if (p.getId() == id){
            return p;
        }
    }
    return null;
}

public boolean editarProduto(Produto novoProduto){
    for (int i = 0; i < listaProdutos.size(); i++){
        Produto p = listaProdutos.get(i);
        if (p.getId() == novoProduto.getId()) {
            listaProdutos.set(i, novoProduto);
            return true;
        }
    }
    return false;
}

public boolean excluirProduto(int id){
    Produto produto = buscarProduto(id);
    if (produto != null){
        listaProdutos.remove(produto);
        return true;
    }
    return false;
}

public ArrayList<Produto> listarProdutos(){
    return listaProdutos;
}
}