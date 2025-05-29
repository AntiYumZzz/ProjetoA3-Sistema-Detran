public class Veiculo {
    protected String placa, modelo, cor, marca, historicoTranferencia;
    protected int ano;

    public void transferir() {
        System.out.println("Tranferir carro");
    }

    public void registrarTransferencia(){
        System.out.println("Tranferência registrada!");
    }

    public void mudancaProprietario() {
        System.out.println("Mudou de proprietário!");
    }

    public void cadastrarVeiculo() {
        System.out.println("Veiculo cadastrado!");
    }


}
