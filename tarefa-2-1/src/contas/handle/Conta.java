package contas.handle;

import pessoas.handle.Pessoa;

public class Conta {
    private static Integer contaCounter = 1;
    protected Pessoa cliente;
    protected Integer nrConta;
    protected double saldo;

    public Conta(Pessoa cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.nrConta = Conta.contaCounter;
        Conta.contaCounter++;
        System.out.println("------------------------------");
		System.out.println("<< O número da conta criada é "+ this.nrConta + " >>");
		System.out.println("------------------------------");
    }

    public Pessoa getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Pessoa newCliente) {
        this.cliente = newCliente;
    }

    public Integer getNrConta() {
        return this.nrConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    protected boolean temSaldo(double valor) {
        if(this.saldo < valor) {
            return false;
        }
        return true;
    }  

    protected void debitar(double valor) {
        this.saldo -= valor;
    }

    public double sacar(double valor) {
        if(temSaldo(valor)) {
            debitar(valor);
            return valor;
        }
        System.out.println("Essa conta não possui saldo suficiente");
        return 0;
    }

    public void transferir(Conta aTransferir, double valor) {
        double transferencia = sacar(valor);
        if(transferencia != 0) {
            aTransferir.depositar(transferencia);
            System.out.println("Transferência efetuada com sucesso");
        } else {
            System.out.println("Transferência negada");
        }
    }
}
