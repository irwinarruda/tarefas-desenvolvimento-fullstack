package contas.handle;

import pessoas.handle.Pessoa;

public class ContaEspecial extends Conta {
    protected double limite = 0; 

    public ContaEspecial(Pessoa cliente, double saldo, double limite) {
        super(cliente, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return this.limite;
    }
    
    public void setLimite(double newLimite) {
        this.limite = newLimite;
    }

    protected boolean temSaldo(double value) {
        if((this.saldo - value) < -this.limite) {
            return false;
        }
        return true;
    }
}
