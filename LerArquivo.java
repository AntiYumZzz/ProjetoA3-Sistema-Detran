import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo{
    
    public static void imprimirVeiculo(){
    try {
      File arquivo = new File("veiculos.txt");
      Scanner leitor = new Scanner(arquivo);
      while (leitor.hasNextLine()) {
        String data = leitor.nextLine();
        System.out.println(data);
      }
      leitor.close();
    } catch (FileNotFoundException e) {
      System.out.println("-- Nenhum veículo está cadastrado --");
      e.printStackTrace();
    }
  }
    
    public static void imprimirUsuario(){
    try {
      File arquivo = new File("usuarios.txt");
      Scanner leitor = new Scanner(arquivo);
      while (leitor.hasNextLine()) {
        String data = leitor.nextLine();
        System.out.println(data);
      }
      leitor.close();
    }catch (FileNotFoundException e) {
        System.out.println("-- Nenhum usuário está cadastrado --");
        e.printStackTrace();
      }
    }
}