package data.adapter;

import java.util.Map;

import data.GerenteBancoDados;
import model.Personagem;

public class GerenteBDAdapter implements DBAdapter {
      private GerenteBancoDados entityManager;

      public GerenteBDAdapter() {
            entityManager = new GerenteBancoDados();
      }

      @Override
      public Map<Integer, String> listarPersonagens() {
            return entityManager.listarPersonagens();
      }

      @Override
      public Personagem buscarPersonagemPorID(int id) {
            return entityManager.buscarPersonagemPorID(id);
      }
}
