import controller.Conflito;
import util.Dado;

public class App {
 
    public static void main(String[] args) throws Exception {
        new Conflito("Gandalf", "Feiticeira Escarlate");

        Dado d6 = Dado.getInstancia();
        Dado d10 = Dado.getInstancia();
        Dado d12 = Dado.getInstancia();
        Dado d20 = Dado.getInstancia();

        Dado d100 = Dado.getInstancia();
    }
}