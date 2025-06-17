package visao;

import controller.CategoriaController;
import model.Categoria;

import javax.swing.*;
import java.awt.event.*;

public class TelaCadastroCategoria extends JFrame {
    private JTextField txtId, txtNome, txtTamanho, txtEmbalagem;
    private JButton btnSalvar, btnLimpar;
    private final CategoriaController categoriaController;

    public TelaCadastroCategoria(CategoriaController controller) {
        this.categoriaController = controller;

        setTitle("Cadastro de Categoria");
        setSize(320, 230);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120, 10, 150, 25);
        add(txtId);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 45, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 45, 150, 25);
        add(txtNome);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(10, 80, 100, 25);
        add(lblTamanho);

        txtTamanho = new JTextField();
        txtTamanho.setBounds(120, 80, 150, 25);
        add(txtTamanho);

        JLabel lblEmbalagem = new JLabel("Embalagem:");
        lblEmbalagem.setBounds(10, 115, 100, 25);
        add(lblEmbalagem);

        txtEmbalagem = new JTextField();
        txtEmbalagem.setBounds(120, 115, 150, 25);
        add(txtEmbalagem);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(40, 160, 100, 30);
        add(btnSalvar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(170, 160, 100, 30);
        add(btnLimpar);

        btnSalvar.addActionListener(e -> salvarCategoria());
        btnLimpar.addActionListener(e -> limparCampos());

        setVisible(true);
    }

    private void salvarCategoria() {
        Categoria categoria = construirCategoriaDosCampos();
        if (categoria != null) {
            try {
                categoriaController.adicionarCategoria(categoria);
                JOptionPane.showMessageDialog(this, "Categoria cadastrada com sucesso!");
                limparCampos();
                // Se quiser fechar a tela após salvar, descomente a linha abaixo:
                // dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar categoria: " + ex.getMessage());
            }
        }
    }

    private Categoria construirCategoriaDosCampos() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText().trim();
            String tamanho = txtTamanho.getText().trim();
            String embalagem = txtEmbalagem.getText().trim();

            if (nome.isEmpty() || tamanho.isEmpty() || embalagem.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
                return null;
            }

            return new Categoria(id, nome, tamanho, embalagem);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido. Informe um número inteiro.");
            return null;
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtTamanho.setText("");
        txtEmbalagem.setText("");
    }
}
