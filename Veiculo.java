import java.util.Scanner;

public class Veiculo {
    private String placa, modelo, cor, marca, historicoTranferencia;
    private int ano;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getHistoricoTransferencia() {
        return historicoTranferencia;
    }

    public int getAno() {
        return ano;
    }



    public void cadastrarVeiculo(Scanner ler) {

        System.out.print("Modelo: ");
        modelo = ler.nextLine();

        System.out.print("Cor: ");
        cor = ler.nextLine();

        System.out.print("Marca: ");
        marca = ler.nextLine();

        System.out.print("Historico de transferência: ");
        historicoTranferencia = ler.nextLine();

        System.out.print("Ano: ");
        ano = ler.nextInt();
        ler.nextLine();

    }

    public void exibirVeiculoCadastrado() {

        System.out.println(" -- Veiculo Cadastrado -- ");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Marca: " + marca);
        System.out.println("Historico de transferência: " + historicoTranferencia);
        System.out.println("Ano: " + ano);
    }

    public void transferir() {
        System.out.println("Tranferir carro");
    }

    public void registrarTransferencia(){
        System.out.println("Tranferência registrada!");
    }

    public void mudancaProprietario() {
        System.out.println("Mudou de proprietário!");
    }


}
