package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Personagem;

/**
 * @author GPT
 */
public class GerenteBancoDados {
    private static final String DATABASE_URL = "jdbc:sqlite:conflitov2.db";

    public Map<Integer, String> listarPersonagens() {
      Map<Integer, String> personagens = new HashMap<>();
        String sql = "SELECT id, nome FROM Personagem";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next())
                personagens.put(rs.getInt("id"), rs.getString("nome"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personagens;
    }

    public Personagem buscarPersonagemPorID(int id) {
        Personagem personagem = null;
        String sql = "SELECT nome, vida FROM Personagem WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    int vida = rs.getInt("vida");
                    personagem = new Personagem(nome, vida, 10); // Supondo que você tenha um construtor apropriado
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personagem; // Retorna null se não encontrar
    }
}