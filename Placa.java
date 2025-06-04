import java.util.ArrayList;

public class Placa {
    protected String id;

    public void baixaPlaca() {
        System.out.println("Baixa na placa");

    }

    public void emplacamento() {
        System.out.println("Carro emplacado!");
    }

    public boolean validarPlacaMerco(String id){
       return id.matches("(?i)^[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}$");
   }

   public boolean validarPlacaAntiga(String id){
       return id.matches("(?i)^[A-Z]{3}[0-9]{4}$");
   }

   public boolean placaExiste(String id, ArrayList<Veiculo> lista) {
           for (Veiculo v : lista) {
               if (v.getPlaca().equalsIgnoreCase(id)) {
                   return true;
               }
           }
        return false;
    }
}
