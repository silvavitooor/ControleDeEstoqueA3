package dao;

import modelo.Produto;
import modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // Método inserir ajustado para lançar SQLException e permitir tratamento no FrmCadastroProduto
    public void inserir(Produto p) throws SQLException {
        String sql = "INSERT INTO produto (nome, unidade, preco_unitario, quantidade_estoque, quantidade_minima, quantidade_maxima, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getUnidade());
            stmt.setDouble(3, p.getPrecoUnitario());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());
            stmt.setInt(7, p.getCategoria().getId());

            stmt.executeUpdate();
            System.out.println("✅ Produto inserido com sucesso.");

        } 
        // Removido catch para SQLException para propagar exceção
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.*, c.nome AS nome_categoria FROM produto p JOIN categoria c ON p.id_categoria = c.id";

        try (Connection conn = ConexaoDAO.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setUnidade(rs.getString("unidade"));
                p.setPrecoUnitario(rs.getDouble("preco_unitario"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                p.setQuantidadeMinima(rs.getInt("quantidade_minima"));
                p.setQuantidadeMaxima(rs.getInt("quantidade_maxima"));

                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome_categoria"));

                p.setCategoria(c);
                produtos.add(p);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
    }

    // Busca produto pelo ID
    public Produto buscarPorId(int id) {
        Produto produto = null;
        String sql = "SELECT p.*, c.nome AS nome_categoria FROM produto p JOIN categoria c ON p.id_categoria = c.id WHERE p.id = ?";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setPrecoUnitario(rs.getDouble("preco_unitario"));
                produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                produto.setQuantidadeMinima(rs.getInt("quantidade_minima"));
                produto.setQuantidadeMaxima(rs.getInt("quantidade_maxima"));

                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome_categoria"));

                produto.setCategoria(c);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao buscar produto por ID: " + e.getMessage());
        }

        return produto;
    }

    // Atualiza todos os dados do produto, inclusive estoque
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, unidade = ?, preco_unitario = ?, quantidade_estoque = ?, quantidade_minima = ?, quantidade_maxima = ?, id_categoria = ? WHERE id = ?";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getUnidade());
            stmt.setDouble(3, produto.getPrecoUnitario());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setInt(5, produto.getQuantidadeMinima());
            stmt.setInt(6, produto.getQuantidadeMaxima());
            stmt.setInt(7, produto.getCategoria().getId());
            stmt.setInt(8, produto.getId());

            stmt.executeUpdate();

            System.out.println("✅ Produto atualizado com sucesso.");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Atualiza somente o estoque
    public void atualizarEstoque(Produto produto) {
        String sql = "UPDATE produto SET quantidade_estoque = ? WHERE id = ?";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getQuantidadeEstoque());
            stmt.setInt(2, produto.getId());

            stmt.executeUpdate();

            System.out.println("✅ Estoque atualizado com sucesso.");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar estoque: " + e.getMessage());
        }
    }
}
