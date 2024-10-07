package data.adapter;

import java.util.Map;

import model.Personagem;

public interface DBAdapter {
      
      public Map<Integer, String> listarPersonagens();
      public Personagem buscarPersonagemPorID(int id);

}
