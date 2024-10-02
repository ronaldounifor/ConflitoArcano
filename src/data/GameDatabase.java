package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDatabase {
    private static final String DATABASE_URL = "jdbc:sqlite:conflito.db";

    public static void main(String[] args) {
        // Example character data
        insertCharacter("Knight", 100, 15, 10);
        insertCharacter("Wizard", 80, 20, 5);

        // Example duel data
        int duelId = insertDuel(1, 2);

        // Example duel result data
        insertDuelResult(duelId, 1, 25, false);
        insertDuelResult(duelId, 2, 10, true);
    }

    public static void insertCharacter(String name, int health, int attackPower, int defensePower) {
        String sql = "INSERT INTO Characters (name, health, attack_power, defense_power) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, health);
            pstmt.setInt(3, attackPower);
            pstmt.setInt(4, defensePower);
            pstmt.executeUpdate();
            System.out.println("Character inserted: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int insertDuel(int characterOneId, int characterTwoId) {
        String sql = "INSERT INTO Duels (character_one_id, character_two_id) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, characterOneId);
            pstmt.setInt(2, characterTwoId);
            pstmt.executeUpdate();

            try (var generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int duelId = generatedKeys.getInt(1);
                    System.out.println("Duel inserted with ID: " + duelId);
                    return duelId;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1; // Indicates failure
    }

    public static void insertDuelResult(int duelId, int characterId, int damageDealt, boolean wasDefeated) {
        String sql = "INSERT INTO DuelResults (duel_id, character_id, damage_dealt, was_defeated) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, duelId);
            pstmt.setInt(2, characterId);
            pstmt.setInt(3, damageDealt);
            pstmt.setBoolean(4, wasDefeated);
            pstmt.executeUpdate();
            System.out.println("Duel result inserted for character ID: " + characterId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}