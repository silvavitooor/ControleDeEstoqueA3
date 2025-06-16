package visao;

import dao.ProdutoDAO;
import modelo.Produto;
import servico.Movimentacao;

import javax.swing.*;
import java.util.List;

public class FrmMovimentacao extends javax.swing.JFrame {

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

        jLabelMovimentacao = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabelQuantidade = new javax.swing.JLabel();
        jLabelProduto = new javax.swing.JLabel();
        jButtonAdicionar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jComboBoxProdutos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProdutos.addActionListener(this::jComboBoxProdutosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jButtonAdicionar)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldQuantidade)
                            .addComponent(jLabelProduto)
                            .addComponent(jLabelQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxProdutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelMovimentacao)
                        .addGap(349, 349, 349))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelMovimentacao)
                .addGap(41, 41, 41)
                .addComponent(jLabelProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        /* Set the Nimbus look and feel (opcional) */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Se falhar, ignore e use padrão
        }

        java.awt.EventQueue.invokeLater(() -> new FrmMovimentacao().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox<String> jComboBoxProdutos;
    private javax.swing.JLabel jLabelMovimentacao;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration
}
