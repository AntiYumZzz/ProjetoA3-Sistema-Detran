import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            // Menu Principal
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1. Cadastro de veículos");
            System.out.println("2. Transferência de veículos");
            System.out.println("3. Transferência de propriedade");
            System.out.println("4. Consulta de informações");
            System.out.println("5. Relatórios");
            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma das opções: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    submenuCadastroVeiculo(ler);
                    break;
                case 2:
                    submenuTransferenciaVeiculo(ler);
                    break;
                case 3:
                    submenuTransferenciaPropriedade(ler);
                    break;
                case 4:
                    submenuConsultaInformacoes(ler);
                    break;
                case 5:
                    submenuRelatorios(ler);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        ler.close();
    }

    // Submenu 1 - Cadastro de veículos
    public static void submenuCadastroVeiculo(Scanner ler) {
        int opcao;
        do {
            System.out.println("\n-- Cadastro de Veículos --");
            System.out.println("1. Cadastrar novo veiculo");
            System.out.println("2. Voltar ao menu principal");
            opcao = ler.nextInt();


            switch (opcao) {
                case 1:
                    Veiculo veiculo = new Veiculo();
                    ler.nextLine();
                    veiculo.cadastrarVeiculo(ler);
                    System.out.println(" ");
                    veiculo.exibirVeiculoCadastrado();
                    break;
                case 2:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                default:
                    System.out.println(">> Opção inválida.");
            }
        } while (opcao != 2);
    }

    // Submenu 2 - Transferência de veículos
    public static void submenuTransferenciaVeiculo(Scanner ler) {
        int opcao;
        do {
            System.out.println("\n-- Transferência de Veículos --");
            System.out.println("1. Iniciar transferência");
            System.out.println("2. Consultar status de transferência");
            System.out.println("3. Voltar ao menu principal");
            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma das opções: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(">> Iniciando transferência de veículo...");
                    break;
                case 2:
                    System.out.println(">> Consultando status de transferência...");
                    break;
                case 3:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                case 0:
                    System.out.println(">> Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(">> Opção inválida.");
            }
        } while (opcao != 3);
    }

    // Submenu 3 - Transferência de propriedade
    public static void submenuTransferenciaPropriedade(Scanner ler) {
        int opcao;
        do {
            System.out.println("\n-- Transferência de Propriedade --");
            System.out.println("1. Iniciar mudança de proprietário");
            System.out.println("2. Verificar documentos necessários");
            System.out.println("3. Voltar ao menu principal");
            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma das opções: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(">> Mudança de proprietário iniciada...");
                    break;
                case 2:
                    System.out.println(">> Documentos necessários: RG, CPF, CRV...");
                    break;
                case 3:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                case 0:
                    System.out.println(">> Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(">> Opção inválida.");
            }
        } while (opcao != 3);
    }

    // Submenu 4 - Consulta de informações
    public static void submenuConsultaInformacoes(Scanner ler) {
        int opcao;
        do {
            System.out.println("\n-- Consulta de Informações --");
            System.out.println("1. Consultar veículo por placa");
            System.out.println("2. Consultar proprietário por CPF");
            System.out.println("3. Voltar ao menu principal");
            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma das opções: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(">> Consulta por placa selecionada.");
                    break;
                case 2:
                    System.out.println(">> Consulta por CPF selecionada.");
                    break;
                case 3:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                case 0:
                    System.out.println(">> Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(">> Opção inválida.");
            }
        } while (opcao != 3);
    }

    // Submenu 5 - Relatórios
    public static void submenuRelatorios(Scanner ler) {
        int opcao;
        do {
            System.out.println("\n-- Relatórios --");
            System.out.println("1. Relatório de veículos cadastrados");
            System.out.println("2. Relatório de transferências realizadas");
            System.out.println("3. Voltar ao menu principal");
            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma das opções: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(">> Gerando relatório de veículos...");
                    break;
                case 2:
                    System.out.println(">> Gerando relatório de transferências...");
                    break;
                case 3:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                case 0:
                    System.out.println(">> Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(">> Opção inválida.");
            }
        } while (opcao != 3);
    }
}
