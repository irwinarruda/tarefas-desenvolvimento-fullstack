package pessoas.handle;

import java.util.Calendar;

public class PessoaFisica extends Pessoa {
    protected String cpf;
    protected Calendar dtNascimento;
    protected String genero;

    public PessoaFisica(String nome, String endereco, String cpf, Calendar dtNascimento, String genero) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        try {    
            if(genero.equals("male") || genero.equals("female")) {
                this.genero = genero;
            } else {
                throw new Exception("O gênero deve ser 'male' ou 'female'");
            }
        } catch(Exception ext) {
            System.out.println(ext);
            System.exit(1);
        }
        
    }  

    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String newCpf) {
        this.cpf = newCpf;
    }

    public Calendar getDtNascimento() {
        return this.dtNascimento;
    }
    
    public void setDtNascimento(Calendar newDtNascimento) {
        this.dtNascimento = newDtNascimento;
    }

    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String newGenero) {
        this.genero = newGenero;
    }

    public int getIdade() {
        Calendar todayCalendar = Calendar.getInstance();
        
        int todayDate = todayCalendar.get(Calendar.DAY_OF_MONTH);
        int todayMonth = todayCalendar.get(Calendar.MONTH);
        int todayYear = todayCalendar.get(Calendar.YEAR);

        int personBirthDate = this.dtNascimento.get(Calendar.DAY_OF_MONTH);
        int personBirthMonth = this.dtNascimento.get(Calendar.MONTH);
        int personBirthYear = this.dtNascimento.get(Calendar.YEAR);

        int birthDate = todayYear - personBirthYear;
        if(todayMonth < personBirthMonth || (todayMonth == personBirthMonth && todayDate < personBirthDate)) {
            birthDate -= 1;
        }

        return birthDate;
    }
}
