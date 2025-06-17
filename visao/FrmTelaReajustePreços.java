package visao;

import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.awt.event.*;

public class TelaReajustePreco extends JFrame {
    private JTextField txtPercentual;
    private JButton btnAplicar, btnLimpar;
    private final ProdutoController produtoController;

    public TelaReajustePreco(ProdutoController controller) {
        this.produtoController = controller;

        setTitle("Reajuste de Preços");
        setSize(320, 160);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblPercentual = new JLabel("Percentual (%):");
        lblPercentual.setBounds(10, 20, 100, 25);
        add(lblPercentual);

        txtPercentual = new JTextField();
        txtPercentual.setBounds(120, 20, 150, 25);
        add(txtPercentual);

        btnAplicar = new JButton("Aplicar Reajuste");
        btnAplicar.setBounds(40, 70, 120, 30);
        add(btnAplicar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(180, 70, 90, 30);
        add(btnLimpar);

        btnAplicar.addActionListener(e -> aplicarReajuste());
        btnLimpar.addActionListener(e -> limparCampo());

        setVisible(true);
    }

    private void aplicarReajuste() {
        String texto = txtPercentual.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o percentual para reajuste.");
            return;
        }

        try {
            double percentual = Double.parseDouble(texto);

            for (Produto p : produtoController.listarProdutos()) {
                double novoPreco = p.getPreco() + (p.getPreco() * percentual / 100);
                p.setPreco(novoPreco);
            }

            JOptionPane.showMessageDialog(this, "Reajuste aplicado com sucesso!");
            limparCampo();
            // Se quiser fechar a tela após aplicar o reajuste, use: dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Percentual inválido. Informe um número válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao aplicar reajuste: " + ex.getMessage());
        }
    }

    private void limparCampo() {
        txtPercentual.setText("");
    }
}
