package view;

import java.util.Scanner;

import controller.Conflito;
import util.Grimorio;

public class InterfaceJogo {
      private Scanner scan;
      private Conflito conflito;

      public InterfaceJogo() {
            scan = new Scanner(System.in);

            iniciarJogo();

            vezDoHeroi();

            scan.close();
      }

      
      private void iniciarJogo() {
            System.out.println("Nome do heroi: ");
            String nomeHeroi = scan.nextLine();
            
            
            System.out.println("Nome do vilao: ");
            String nomeVilao = scan.nextLine();
            
            this.conflito = new Conflito(nomeHeroi, nomeVilao);
      }

      private void vezDoHeroi() {
            // Vez do Herói
            System.out.println("Escolha a magia do heroi: ");
            // Selecione sua magia

            for (int i = 0; i < Grimorio.MAGIAS.length; i++)
                  System.out.println("["+i+"]. "+Grimorio.MAGIAS[i].getNome());

            boolean vilaoVivo = conflito.turnoHeroi(Grimorio.MAGIAS[scan.nextInt()]);

            if(vilaoVivo)
                  vezDoVilao();
      }

      private void vezDoVilao() {
            System.out.println("Escolha a magia do vilao: ");

            for (int i = 0; i < Grimorio.MAGIAS.length; i++)
                  System.out.println("["+i+"]. "+Grimorio.MAGIAS[i].getNome());

            boolean heroiVivo = conflito.turnoVilao(Grimorio.MAGIAS[scan.nextInt()]);

            if(heroiVivo)
                  vezDoHeroi();
      }
}
      