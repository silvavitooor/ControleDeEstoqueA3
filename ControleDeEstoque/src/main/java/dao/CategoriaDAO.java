package dao;

import dao.ConexaoDAO.Conexao;
import modelo.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    
    public void inserir(Categoria categoria) throws SQLException{
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
        }
    }
    public List<Categoria> listar () throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()){
                Categoria cat = new Categoria(rs.getInt("id"),rs.getString("nome"));
                
                categorias.add(cat);
            }
        }
        return categorias;
    }
    
    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET nome=? WHERE id=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        }
    }
    
    public void excluir (int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
