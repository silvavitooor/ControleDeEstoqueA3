package org.unisul.visao;

import org.unisul.dao.ProdutoDAO;
import org.unisul.modelo.Produto;
import org.unisul.servico.Movimentacao;

import javax.swing.*;
import java.util.List;

public class FrmMovimentacao extends JFrame {

    private Movimentacao movimentacaoService;
    private ProdutoDAO produtoDAO;

    public FrmMovimentacao() {
        initComponents();
        movimentacaoService = new Movimentacao();
        produtoDAO = new ProdutoDAO();
        carregarProdutos();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        // setMinimumSize(new java.awt.Dimension(600, 400)); // opcional, para tamanho mínimo
    }

    private void carregarProdutos() {
        try {
            List<Produto> produtos = produtoDAO.listar(); // seu método listar() no ProdutoDAO
            jComboBoxProdutos.removeAllItems();
            for (Produto p : produtos) {
                jComboBoxProdutos.addItem(p.getId() + " - " + p.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void executarMovimentacao(boolean entrada) {
        try {
            String selecionado = (String) jComboBoxProdutos.getSelectedItem();
            if (selecionado == null || selecionado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecione um produto.");
                return;
            }

            int produtoId = Integer.parseInt(selecionado.split(" - ")[0].trim());
            int quantidade = Integer.parseInt(jTextFieldQuantidade.getText());

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "Informe uma quantidade maior que zero.");
                return;
            }

            movimentacaoService.movimentar(produtoId, quantidade, entrada);

            JOptionPane.showMessageDialog(this,
                    entrada ? "Quantidade adicionada com sucesso!" : "Quantidade removida com sucesso!");

            carregarProdutos(); // Atualiza combo (se necessário)
            jTextFieldQuantidade.setText(""); // Limpa campo quantidade

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Informe uma quantidade válida (número inteiro).");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro na movimentação: " + e.getMessage());
        }
    }

    // Botões e eventos gerados pelo NetBeans (ou manualmente):
    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        executarMovimentacao(true);
    }

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        executarMovimentacao(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); // Fecha a janela
    }

    private void jComboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        // Ação se quiser reagir à seleção do combo
    }

    // Método initComponents (exatamente o que você enviou):
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelMovimentacao = new JLabel();
        jTextFieldQuantidade = new JTextField();
        jLabelQuantidade = new JLabel();
        jLabelProduto = new JLabel();
        jButtonAdicionar = new JButton();
        jButton2 = new JButton();
        jButtonRemover = new JButton();
        jComboBoxProdutos = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelMovimentacao.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelMovimentacao.setText("Movimentação");

        jLabelQuantidade.setText("Informe a quantidade que deseja adicionar ou remover:");

        jLabelProduto.setText("Produto");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(this::jButtonAdicionarActionPerformed);

        jButton2.setText("Sair");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(this::jButtonRemoverActionPerformed);

        jComboBoxProdutos.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProdutos.addActionListener(this::jComboBoxProdutosActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jButtonAdicionar)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldQuantidade)
                            .addComponent(jLabelProduto)
                            .addComponent(jLabelQuantidade, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxProdutos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(43, 43, 43))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelMovimentacao)
                        .addGap(349, 349, 349))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelMovimentacao)
                .addGap(41, 41, 41)
                .addComponent(jLabelProduto)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelQuantidade)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonRemover))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        /* Set the Nimbus look and feel (opcional) */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Se falhar, ignore e use padrão
        }

        java.awt.EventQueue.invokeLater(() -> new FrmMovimentacao().setVisible(true));
    }

    // Variables declaration - do not modify
    private JButton jButton2;
    private JButton jButtonAdicionar;
    private JButton jButtonRemover;
    private JComboBox<String> jComboBoxProdutos;
    private JLabel jLabelMovimentacao;
    private JLabel jLabelProduto;
    private JLabel jLabelQuantidade;
    private JTextField jTextFieldQuantidade;
    // End of variables declaration
}
