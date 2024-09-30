package model.item;

import java.util.ArrayList;

public class Mochila extends Equipamento {

      private ArrayList<Equipamento> itens;

      public Mochila() {
            itens = new ArrayList<>();
      }

      public void addItem(Equipamento equipamento) {
            itens.add(equipamento);
      }
      
}
