import java.util.Scanner;

public class Veiculo {
    private String formato;
    private Placa placa = new Placa();
    private Modelo modelo = new Modelo();
    private Marca marca = new Marca();
    private String cor;
    private int ano;

    // getters e setters
    public String getPlaca(){
        return placa.id;
    }
    public String getModelo(){
        return modelo.nome;
    }
    public String getCor(){
        return cor;
    }
    public String getMarca(){
        return marca.nome;
    }
    public int getAno(){
        return ano;
    }
    public String getFormato(){
        return formato;
    } 

    public String setPlaca(String novaPlaca){
        return this.placa.id = novaPlaca;
    }
    public String setModelo(String novoModelo){
        return this.modelo.nome = novoModelo;
    }
    public String setCor(String novaCor){
        return this.cor = novaCor;
    }
    public String setMarca(String novaMarca){
        return this.marca.nome = novaMarca;
    }
    public String setFormato(String novoFormato){
        return this.formato = novoFormato;
    }

    public void cadastrarVeiculo(Scanner ler){
        System.out.println("Formato da placa (Digite Antigo ou Mercosul)");
        formato = ler.nextLine();

        while(!(formato.equalsIgnoreCase("antigo") || formato.equalsIgnoreCase("mercosul"))){
            System.out.println("Formato Inválido! Digite novamente");
            formato = ler.nextLine();
            ler.nextLine();
        }   
        

        // Isso tudo pra verificar o formato da placa, se é valido e se não foi repetido
        while(true){
            System.out.print("Placa :");
            placa.id = ler.nextLine();

            if(formato.equalsIgnoreCase("Antigo")){
                if(placa.validarPlacaAntiga(placa.id)){
                    break; 
                }else{
                    System.out.println("Formato Invalido, tente novamente");
                } 
            }else if(formato.equalsIgnoreCase("Mercosul")){
                if(placa.validarPlacaMerco(placa.id)){
                    break;
                }else{
                    System.out.print("Formato Invalido, tente novamente");
                }
            }
        }

        System.out.print("Modelo: ");
        modelo.nome = ler.nextLine();

        System.out.print("Cor: ");
        cor = ler.nextLine();

        System.out.print("Marca: ");
        marca.nome = ler.nextLine();

        System.out.print("Ano: ");
        ano = ler.nextInt();
        ler.nextLine();
        
    }

    public void exibirVeiculoCadastrado() {

        System.out.println(" -- Veiculo Cadastrado -- ");
        System.out.println("Placa: " + placa.id);
        System.out.println("Modelo: " + modelo.nome);
        System.out.println("Cor: " + cor);
        System.out.println("Marca: " + marca.nome);
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
