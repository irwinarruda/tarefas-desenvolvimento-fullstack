package pessoas.handle;

public class Pessoa {
    private static Integer idCounter = 1;
	protected Integer id;
	protected String nome;
	protected String endereco;
	
    public Pessoa(String nome, String endereco ) {
        this.nome = nome;
        this.endereco = endereco;
        this.id = Pessoa.idCounter;
        Pessoa.idCounter++;
        System.out.println("------------------------------");
		System.out.println("<< O id da pessoa criada é "+ this.id + " >>");
		System.out.println("------------------------------");
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String newEndereco) {
        this.endereco = newEndereco;
    }

    public void printId() {
        System.out.println(Pessoa.idCounter);
    }
}
