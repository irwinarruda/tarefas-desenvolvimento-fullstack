package pessoas.handle;

public class PessoaJuridica extends Pessoa {
    protected String cnpj;
    protected String atividade;

    public PessoaJuridica(String nome, String endereco, String cnpj, String atividade) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.atividade = atividade;
    }  

    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String newCnpj) {
        this.cnpj = newCnpj;
    }

    public String getAtividade() {
        return this.atividade;
    }
    
    public void setAtividade(String newAtividade) {
        this.atividade = newAtividade;
    }
}
