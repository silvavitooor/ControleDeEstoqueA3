package dao;

import modelo.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso.");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria cat = new Categoria(rs.getInt("id"), rs.getString("nome"));
                categorias.add(cat);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar categorias: " + e.getMessage());
        }

        return categorias;
    }

    public Categoria buscarPorId(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        Categoria categoria = null;

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                categoria = new Categoria(rs.getInt("id"), rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao buscar categoria: " + e.getMessage());
        }

        return categoria;
    }

    public void atualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
            System.out.println("✅ Categoria atualizada com sucesso.");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar categoria: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Categoria excluída com sucesso.");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao excluir categoria: " + e.getMessage());
        }
    }
}
