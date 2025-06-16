package servico;

import modelo.Produto;
import dao.ProdutoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Movimentacao {
    
    private ProdutoDAO produtoDAO;

    public Movimentacao() {
        this.produtoDAO = new ProdutoDAO();
    }

    /**
     * Realiza movimentação de estoque do produto.
     * @param produtoId id do produto
     * @param quantidade quantidade para movimentar (deve ser > 0)
     * @param entrada true para adicionar, false para remover
     * @throws SQLException erros no banco
     * @throws IllegalArgumentException caso produto não exista ou quantidade inválida
     */
    public void movimentar(int produtoId, int quantidade, boolean entrada) throws SQLException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        
        Produto produto = produtoDAO.buscarPorId(produtoId);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        int novaQuantidade = entrada
            ? produto.getQuantidadeEstoque() + quantidade
            : produto.getQuantidadeEstoque() - quantidade;

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Não é possível remover mais do que o estoque disponível.");
        }

        produto.setQuantidadeEstoque(novaQuantidade);
        produtoDAO.atualizar(produto);

        if (!entrada && novaQuantidade < produto.getQuantidadeMinima()) {
            JOptionPane.showMessageDialog(null,
                    "⚠️ Atenção: produto abaixo da quantidade mínima.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else if (entrada && novaQuantidade > produto.getQuantidadeMaxima()) {
            JOptionPane.showMessageDialog(null,
                    "⚠️ Atenção: produto acima da quantidade máxima.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
