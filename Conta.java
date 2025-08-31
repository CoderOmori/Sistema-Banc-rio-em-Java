public class Conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    // Construtor
    public Conta(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    // Mensagem inicial
    public String exibirMensagem() {
        return String.format(
            "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
            nomeCliente, agencia, numero, saldo
        );
    }

    // Depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Sacar
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    // Consultar saldo
    public void consultarSaldo() {
        System.out.printf("Saldo atual da conta %d (%s): R$ %.2f%n", numero, nomeCliente, saldo);
    }

    // Transferir para outra conta
    public void transferir(double valor, Conta destino) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada com sucesso para %s (Conta %d)%n",
                              valor, destino.getNomeCliente(), destino.getNumero());
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }
}
