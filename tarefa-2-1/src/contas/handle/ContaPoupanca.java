package contas.handle;

import pessoas.handle.Pessoa;

public class ContaPoupanca extends Conta {
    protected double txCorrecao = 0;

    public ContaPoupanca(Pessoa cliente, double saldo, double txCorrecao) {
        super(cliente, saldo);
        this.txCorrecao = txCorrecao;
    }

    public double getTxCorrecao() {
        return this.txCorrecao;
    }
    
    public void setTxCorrecao(double newTxCorrecao) {
        this.txCorrecao = newTxCorrecao;
    }

    public double atualizaSaldoRendimento() {
        this.depositar(this.saldo * this.txCorrecao);
        return this.saldo;
    }
}
