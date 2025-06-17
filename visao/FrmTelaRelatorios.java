package visao;

import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.util.List;

public class TelaRelatorios extends JFrame {
    private JButton btnListaPrecos;
    private JButton btnBalanco;
    private JButton btnAbaixoMin;
    private JButton btnAcimaMax;
    private final ProdutoController produtoController;

    public TelaRelatorios(ProdutoController controller) {
        this.produtoController = controller;

        setTitle("Relatórios");
        setSize(320, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        btnListaPrecos = new JButton("Lista de Preços");
        btnListaPrecos.setBounds(60, 20, 200, 30);
        add(btnListaPrecos);

        btnBalanco = new JButton("Balanço Físico/Financeiro");
        btnBalanco.setBounds(60, 70, 200, 30);
        add(btnBalanco);

        btnAbaixoMin = new JButton("Produtos Abaixo da Mínima");
        btnAbaixoMin.setBounds(60, 120, 200, 30);
        add(btnAbaixoMin);

        btnAcimaMax = new JButton("Produtos Acima da Máxima");
        btnAcimaMax.setBounds(60, 170, 200, 30);
        add(btnAcimaMax);

        btnListaPrecos.addActionListener(e -> mostrarListaPrecos());
        btnBalanco.addActionListener(e -> mostrarBalanco());
        btnAbaixoMin.addActionListener(e -> mostrarProdutosAbaixoMin());
        btnAcimaMax.addActionListener(e -> mostrarProdutosAcimaMax());

        setVisible(true);
    }

    private void mostrarListaPrecos() {
        List<Produto> produtos = produtoController.listarProdutos();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== Lista de Preços ===\n");
        for (Produto p : produtos) {
            sb.append(String.format("%s - R$ %.2f - %s - %s%n",
                    p.getNome(),
                    p.getPreco(),
                    p.getUnidadeMedida(),
                    p.getCategoria().getNome()));
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void mostrarBalanco() {
        List<Produto> produtos = produtoController.listarProdutos();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto cadastrado.");
            return;
        }

        double totalEstoque = 0;
        StringBuilder sb = new StringBuilder("=== Balanço Físico/Financeiro ===\n");
        for (Produto p : produtos) {
            double totalProduto = p.getPreco() * p.getQtdAtual();
            totalEstoque += totalProduto;
            sb.append(String.format("%s - Qtd: %d - Total: R$ %.2f%n",
                    p.getNome(),
                    p.getQtdAtual(),
                    totalProduto));
        }
        sb.append(String.format("Valor Total do Estoque: R$ %.2f", totalEstoque));
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void mostrarProdutosAbaixoMin() {
        List<Produto> produtos = produtoController.listarAbaixoDaMinima();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto abaixo da quantidade mínima.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== Produtos Abaixo da Quantidade Mínima ===\n");
        for (Produto p : produtos) {
            sb.append(String.format("%s - Min: %d - Atual: %d%n",
                    p.getNome(),
                    p.getQtdMinima(),
                    p.getQtdAtual()));
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void mostrarProdutosAcimaMax() {
        List<Produto> produtos = produtoController.listarAcimaDaMaxima();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto acima da quantidade máxima.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== Produtos Acima da Quantidade Máxima ===\n");
        for (Produto p : produtos) {
            sb.append(String.format("%s - Max: %d - Atual: %d%n",
                    p.getNome(),
                    p.getQtdMaxima(),
                    p.getQtdAtual()));
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}
