package visao;

import controller.ProdutoController;
import model.Produto;
import model.Categoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaProduto extends JFrame {
    private JTextField txtId, txtnome, txtUnidade, txtPreco, txtQtdAtual, txtQtdMin, txtQtdMax;
    private JButton btnAdicionar, btnEditar, btnExcluir, btnLimpar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private final ProdutoController controller;



    public  TelaProduto() {
        setTitle("Cadastro de Produtos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        controller = new ProdutoController();
        
        JLabel lblId = new JLabel("ID: ");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);
        
        txtId = new JTextField();
        txtId.setBounds(120, 20, 100, 25);
        add(txtId);
        
        JLabel lblNome = new JLabel("Nome: ");
        lblNome.setBounds(20, 50, 100, 25);
        add(lblNome);
        
        txtnome = new JTextField();
        txtnome.setBounds(120, 50, 200, 25);
        add(txtnome);
        
        JLabel lblUnidade = new JLabel("Unidade: ");
        lblUnidade.setBounds(20, 80, 100, 25);
        add(lblUnidade);
        
        txtUnidade = new JTextField();
        txtUnidade.setBounds(120, 80, 100, 25);
        add(txtUnidade);
        
        JLabel lblPreco = new JLabel("Preço: ");
        lblPreco.setBounds(20, 110, 100, 25);
        add(lblPreco);
        
        txtPreco = new JTextField();
        txtPreco.setBounds(120, 110, 100, 25);
        add(txtPreco);
        
        JLabel lblQtdAtual = new JLabel("Quantidade Atual: ");
        lblQtdAtual.setBounds(20, 140, 100, 25);
        add(lblQtdAtual);
        
        txtQtdAtual = new JTextField();
        txtQtdAtual.setBounds(120, 110, 100, 25);
        add(txtQtdAtual);
        
        JLabel lblQtdMin = new JLabel("Qtd Mínima:");
        lblQtdMin.setBounds(20, 170, 100, 25);
        add(lblQtdMin);

        txtQtdMin = new JTextField();
        txtQtdMin.setBounds(120, 170, 100, 25);
        add(txtQtdMin);

        JLabel lblQtdMax = new JLabel("Qtd Máxima:");
        lblQtdMax.setBounds(20, 200, 100, 25);
        add(lblQtdMax);

        txtQtdMax = new JTextField();
        txtQtdMax.setBounds(120, 200, 100, 25);
        add(txtQtdMax);

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(350, 20, 120, 30);
        add(btnAdicionar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(350, 60, 120, 30);
        add(btnEditar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(350, 100, 120, 30);
        add(btnExcluir);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(350, 140, 120, 30);
        add(btnLimpar);

        modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Unidade", "Preço", "Qtd Atual", "Qtd Mín", "Qtd Máx"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 240, 740, 100);
        add(scroll);

        btnAdicionar.addActionListener(e -> adicionarProduto());
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());
        btnLimpar.addActionListener(e -> limparCampos());

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = tabela.getSelectedRow();
                if (linha >= 0) {
                    txtId.setText(modelo.getValueAt(linha, 0).toString());
                    txtnome.setText(modelo.getValueAt(linha, 1).toString());
                    txtUnidade.setText(modelo.getValueAt(linha, 2).toString());
                    txtPreco.setText(modelo.getValueAt(linha, 3).toString());
                    txtQtdAtual.setText(modelo.getValueAt(linha, 4).toString());
                    txtQtdMin.setText(modelo.getValueAt(linha, 5).toString());
                    txtQtdMax.setText(modelo.getValueAt(linha, 6).toString());
                }
            }
        });

        setVisible(true);
    }

    private void adicionarProduto() {
        Produto p = construirProdutoDosCampos();
        if (p != null) {
            controller.adicionarProduto(p);
            atualizarTabela();
            limparCampos();
        }
    }

    private void editarProduto() {
        Produto p = construirProdutoDosCampos();
        if (p != null) {
            controller.editarProduto(p);
            atualizarTabela();
            limparCampos();
        }
    }

    private void excluirProduto() {
        try {
            int id = Integer.parseInt(txtId.getText());
            controller.excluirProduto(id);
            atualizarTabela();
            limparCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private Produto construirProdutoDosCampos() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtnome.getText();
            String unidade = txtUnidade.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int qtdAtual = Integer.parseInt(txtQtdAtual.getText());
            int qtdMin = Integer.parseInt(txtQtdMin.getText());
            int qtdMax = Integer.parseInt(txtQtdMax.getText());

            return new Produto(id, nome, new Categoria(0, "Padrão"), unidade, preco, qtdAtual, qtdMin, qtdMax);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro nos dados. Verifique os campos.");
            return null;
        }
    }

    private void atualizarTabela() {
        modelo.setRowCount(0);
        ArrayList<Produto> produtos = controller.listarProdutos();
        for (Produto p : produtos) {
            modelo.addRow(new Object[]{
                p.getId(), p.getNome(), p.getUnidadeMedida(), p.getPreco(),
                p.getQtdAtual(), p.getQtdMinima(), p.getQtdMaxima()
            });
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtnome.setText("");
        txtUnidade.setText("");
        txtPreco.setText("");
        txtQtdAtual.setText("");
        txtQtdMin.setText("");
        txtQtdMax.setText("");
    }

    public static void main(String[] args) {
        new FRMTelaProduto();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
