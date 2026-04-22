package javacrudapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */
public class UsuarioDAO { // DAO - DATA ACESS OBJECT (Classe onde contém métodos de conexão com o bd)

    private Connection connection;

    public UsuarioDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    // CREATE
    public int InserirUsuario(Usuario usuario) {
        try {
            String sql = "insert into usuarios (nome,sobrenome,email,cidade) values (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCidade());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    // SELECT / READ usuario
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "select * from usuarios";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String email = rs.getString("email");
                String cidade = rs.getString("cidade");

                usuarios.add(new Usuario(id, nome, sobrenome, email, cidade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // UPDATE
    public int updateUsuario(Usuario usuario) {
        try {
            String sql = "update usuarios set nome=?, sobrenome=?,email=?,cidade=? where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCidade());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    // DELETE
    public void deleteUsuario(int id) {
        try {
            String sql = "delete from usuarios where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
