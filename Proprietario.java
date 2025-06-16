import java.io.Serializable;
import java.util.*;
public class Proprietario implements Serializable {
    private String nome, cpf, senha, email, dataNascimento, telefone;
    private static List<Veiculo> veiculos;




    public Proprietario(String nome, String cpf, String senha, String email,String dataNascimento, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public void setNome(String novoNome){
        nome = novoNome;
    }
    public void setCpf (String novoCpf){
        cpf = novoCpf;
    }
    public void setSenha (String novaSenha){
        senha = novaSenha;
    }
    public void setEmail (String novoEmail){
        email = novoEmail;
    }
    public void setDataNascimento (String novaData){
        dataNascimento = novaData;
    }
    public void setTelefone (String novoTelefone){
        telefone = novoTelefone;
    }

    public String getNome(){
        return nome;
    }
    public String getCpf (){
        return cpf;
    }
    public String getEmail(){
        return email;
    }
    public String getSenha(){
        return senha;
    }
    public String getData(){
        return dataNascimento;
    }
    public String getTele(){
        return telefone;
    }
    public List<Veiculo> getVeiculos(){
        return veiculos;
    }



    public static void adicionarVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }



    public boolean validarCpf(String cpf){
       return cpf.matches("^[0-9]{11}$");
   }
}