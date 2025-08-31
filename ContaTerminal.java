import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Criando a Conta A
        System.out.println("=== Cadastro Conta A ===");
        System.out.println("Digite o número da Conta: ");
        int numeroA = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o número da Agência: ");
        String agenciaA = scanner.nextLine();
        System.out.println("Digite o nome do Cliente: ");
        String nomeClienteA = scanner.nextLine();
        System.out.println("Digite o saldo inicial: ");
        double saldoA = scanner.nextDouble();

        Conta contaA = new Conta(numeroA, agenciaA, nomeClienteA, saldoA);

        // Criando a Conta B (destino de transferências)
        System.out.println("\n=== Cadastro Conta B (destino de transferências) ===");
        System.out.println("Digite o número da Conta: ");
        int numeroB = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o número da Agência: ");
        String agenciaB = scanner.nextLine();
        System.out.println("Digite o nome do Cliente: ");
        String nomeClienteB = scanner.nextLine();
        System.out.println("Digite o saldo inicial: ");
        double saldoB = scanner.nextDouble();

        Conta contaB = new Conta(numeroB, agenciaB, nomeClienteB, saldoB);

        // Mensagens iniciais
        System.out.println("\nConta A criada: " + contaA.exibirMensagem());
        System.out.println("Conta B criada: " + contaB.exibirMensagem());

        // Menu
        int opcao;
        do {
            System.out.println("\n=== Menu Banco (Conta A) ===");
            System.out.println("1 - Consultar saldo Conta A");
            System.out.println("2 - Depositar em Conta A");
            System.out.println("3 - Sacar de Conta A");
            System.out.println("4 - Transferir de Conta A para Conta B");
            System.out.println("5 - Consultar saldo Conta B");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contaA.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    contaA.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    contaA.sacar(valorSaque);
                    break;
                case 4:
                    System.out.print("Digite o valor para transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    contaA.transferir(valorTransferencia, contaB);
                    break;
                case 5:
                    contaB.consultarSaldo();
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso banco!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
