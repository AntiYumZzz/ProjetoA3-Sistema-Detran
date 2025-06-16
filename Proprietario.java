import java.util.*;
public class Proprietario { 
    String user, nome, cpf, senha, email, dataNascimento, telefone;
    public Map<String, String> users; // usuario, senha e cpfpublic String nome;




    public void cadastroProprietario(){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
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
    public void checarHistorico() {
        System.out.println("Historico checado");
    }


}