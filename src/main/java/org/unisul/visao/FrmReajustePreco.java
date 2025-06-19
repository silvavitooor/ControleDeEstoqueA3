package org.unisul.visao;

import org.unisul.dao.ProdutoDAO;
import org.unisul.modelo.Produto;

import javax.swing.*;
import java.util.List;

public class FrmReajustePreco extends JFrame {

    private JButton jButtonAlterar;
    private JTextField jButtonPercentual;
    private JButton jButtonSair;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabelReajustePreco;
    private JLabel jLabelSelecioneProduto;
    private JComboBox<Produto> comboProdutos;
    private List<Produto> listaProdutos;

    public FrmReajustePreco() {
        initComponents();
        comboProdutos = new JComboBox<Produto>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        listaProdutos = dao.listar();
        comboProdutos.removeAllItems();
        for (Produto p : listaProdutos) {
            comboProdutos.addItem(p);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelReajustePreco = new JLabel();
        jLabelSelecioneProduto = new JLabel();
        jComboBox1 = new JComboBox<>();
        jButtonPercentual = new JTextField();
        jButtonAlterar = new JButton();
        jButtonSair = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelReajustePreco.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelReajustePreco.setText("Reajuste de Preço");

        jLabelSelecioneProduto.setText("Selecione o produto");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButtonPercentual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPercentualActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Informe o percentual que deseja alterar o valor");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabelReajustePreco))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabelSelecioneProduto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonPercentual, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButtonAlterar)
                        .addGap(86, 86, 86)
                        .addComponent(jButtonSair)))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelReajustePreco)
                .addGap(26, 26, 26)
                .addComponent(jLabelSelecioneProduto)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jButtonPercentual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonSair))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox1.getSelectedIndex();
        if (index >= 0 && index < listaProdutos.size()) {
            Produto produtoSelecionado = listaProdutos.get(index);
            System.out.println("Produto selecionado: " + produtoSelecionado.getNome());
        }
    }
    //GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
   
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonPercentualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPercentualActionPerformed

    }//GEN-LAST:event_jButtonPercentualActionPerformed

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReajustePreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
java.awt.EventQueue.invokeLater(() -> {
            FrmReajustePreco frame = new FrmReajustePreco();
            frame.setVisible(true);
        });
    }
}
