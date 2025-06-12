import java.util.*;
public class Proprietario { 
    String user, senha, cpf; 
    private Map<String, String> users; // usuario, senha e cpf 
    
    
    public Proprietario(){
        users  = new HashMap<>();
        // exemplo usuario 
        users.put("teste", "1234"); 
        users.put("teste2", "1234");
        
    } 
    
    public boolean validarCpf(String cpf){
       return cpf.matches("^[0-9]{11}$");
   }
   
    public boolean autenticacao(String user, String senha){ 
        return users.containsKey(user) && users.get(user).equals(senha); 
    } 
    
    public void cadastroProprietario(String user, String senha){ 
       users.put(user, senha); 
    } 
    
    public void consultarVeiculo() {
        System.out.println("Veiculo consultado!");
    } 
    public void checarHistorico() { System.out.println("Historico checado"); } }