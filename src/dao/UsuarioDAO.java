package dao;

import controller.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */
public class UsuarioDAO { // DAO - DATA ACESS OBJECT - Classe ontem vai conter os métodos de conexão com bd

    private Connection conn;

    public UsuarioDAO() throws SQLException {
        conn = DBConnection.getConnection();
    }

    //CREATE
    public int InserirUsuario(Usuario usuario) throws SQLException {
        try {
            String sql = "insert into usuarios (nome, sobrenome, email, cidade, cpf) values (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCidade());
            stmt.setString(5, usuario.getCpf());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //READ / SELECT
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "select * from usuarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String email = rs.getString("email");
                String cidade = rs.getString("cidade");
                String cpf = rs.getString("cpf");
                usuarios.add(new Usuario(id, nome, sobrenome, email, cidade, cpf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    //UPDATE
    public int updateUsuario(Usuario usuario) {
        try {
            String sql = "update usuarios set nome=?, sobrenome=?, email=?, cidade=?, cpf=? where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCidade());
            stmt.setString(5, usuario.getCpf());
            stmt.setInt(6, usuario.getId());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //DELETE
    public void deleteUsuario(int id) {
        try {
            String sql = "delete from usuarios where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}