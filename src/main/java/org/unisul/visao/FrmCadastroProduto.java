package org.unisul.visao;  // ajuste para o seu pacote

import org.unisul.dao.ProdutoDAO;
import org.unisul.modelo.Categoria;
import org.unisul.modelo.Produto;

import javax.swing.*;
import java.sql.SQLException;

public class FrmCadastroProduto extends javax.swing.JFrame {

    public FrmCadastroProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jLabelUnidade = new javax.swing.JLabel();
        jLabelPrecoUnitario = new javax.swing.JLabel();
        jLabelQuantidadeEstoque = new javax.swing.JLabel();
        jLabelQuantidadeMinima = new javax.swing.JLabel();
        jLabelQuantidadeMaxima = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldUnidade = new javax.swing.JTextField();
        jTextFieldPrecoUnitario = new javax.swing.JTextField();
        jTextFieldQuantidadeEstoque = new javax.swing.JTextField();
        jTextFieldQuantidadeMinima = new javax.swing.JTextField();
        jTextFieldQuantidadeMaxima = new javax.swing.JTextField();
        jTextFieldCategoria = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");

        jLabelNome.setText("Nome:");

        jLabelUnidade.setText("Unidade:");

        jLabelPrecoUnitario.setText("Preço Unitário:");

        jLabelQuantidadeEstoque.setText("Quantidade em Estoque:");

        jLabelQuantidadeMinima.setText("Quantidade Mínima:");

        jLabelQuantidadeMaxima.setText("Quantidade Máxima:");

        jLabelCategoria.setText("Categoria:");

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelUnidade)
                    .addComponent(jLabelPrecoUnitario)
                    .addComponent(jLabelQuantidadeEstoque)
                    .addComponent(jLabelQuantidadeMinima)
                    .addComponent(jLabelQuantidadeMaxima)
                    .addComponent(jLabelCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar)
                .addGap(18, 18, 18)
                .addComponent(jButtonLimpar)
                .addGap(18, 18, 18)
                .addComponent(jBSair)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnidade)
                    .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoUnitario)
                    .addComponent(jTextFieldPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeEstoque)
                    .addComponent(jTextFieldQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeMinima)
                    .addComponent(jTextFieldQuantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeMaxima)
                    .addComponent(jTextFieldQuantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jBSair))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nome = jTextFieldNome.getText().trim();
            String unidade = jTextFieldUnidade.getText().trim();
            String categoriaStr = jTextFieldCategoria.getText().trim();
            double precoUnitario = Double.parseDouble(jTextFieldPrecoUnitario.getText().trim());
            int quantidadeEstoque = Integer.parseInt(jTextFieldQuantidadeEstoque.getText().trim());
            int quantidadeMinima = Integer.parseInt(jTextFieldQuantidadeMinima.getText().trim());
            int quantidadeMaxima = Integer.parseInt(jTextFieldQuantidadeMaxima.getText().trim());

            Categoria categoria = new Categoria(categoriaStr);
            Produto produto = new Produto(nome, unidade, categoria, precoUnitario, quantidadeEstoque, quantidadeMinima, quantidadeMaxima);

            ProdutoDAO dao = new ProdutoDAO();
            dao.inserir(produto);

            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");

            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: Formato numérico inválido.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }
    }

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
    }

    private void limparCampos() {
        jTextFieldNome.setText("");
        jTextFieldUnidade.setText("");
        jTextFieldPrecoUnitario.setText("");
        jTextFieldQuantidadeEstoque.setText("");
        jTextFieldQuantidadeMinima.setText("");
        jTextFieldQuantidadeMaxima.setText("");
        jTextFieldCategoria.setText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Ignore erros no look and feel e usa padrão
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new FrmCadastroProduto().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPrecoUnitario;
    private javax.swing.JLabel jLabelQuantidadeEstoque;
    private javax.swing.JLabel jLabelQuantidadeMaxima;
    private javax.swing.JLabel jLabelQuantidadeMinima;
    private javax.swing.JLabel jLabelUnidade;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPrecoUnitario;
    private javax.swing.JTextField jTextFieldQuantidadeEstoque;
    private javax.swing.JTextField jTextFieldQuantidadeMaxima;
    private javax.swing.JTextField jTextFieldQuantidadeMinima;
    private javax.swing.JTextField jTextFieldUnidade;
    // End of variables declaration                   
}
