package data.adapter;

import java.util.Map;

import data.GameDatabase;
import model.Personagem;

public class GameDataBaseAdapter implements DBAdapter {
      private GameDatabase entityManager;

      public GameDataBaseAdapter() {
            entityManager = new GameDatabase();
      }

      @Override
      public Map<Integer, String> listarPersonagens() {
            return entityManager.getAllCharacterNames();
      }

      @Override
      public Personagem buscarPersonagemPorID(int id) {
            return entityManager.findPersonagemByID(id);
      }
      
}
