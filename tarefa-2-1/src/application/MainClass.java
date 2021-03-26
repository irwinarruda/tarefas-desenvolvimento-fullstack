package application;

import pessoas.handle.Pessoa;
import pessoas.handle.PessoaFisica;
import pessoas.handle.PessoaJuridica;
import contas.handle.Conta;
import contas.handle.ContaPoupanca;
import contas.handle.ContaEspecial;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	final static String MASCULINO = "male";
	final static String FEMININO = "female";

	static List<Conta> contas = new ArrayList<Conta>();
	static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	public static void main(String[] args) {
		Calendar idadePessoa1 = Calendar.getInstance();
		idadePessoa1.set(2000, 0, 7);
		Calendar idadePessoa2 = Calendar.getInstance();
		idadePessoa2.set(2016, 10, 23);

		PessoaFisica pessoa1 = new PessoaFisica(
			"Irwin", 
			"av. pres jk area 2", 
			"010.192.531-00", 
			idadePessoa1, 
			MASCULINO
		);
		PessoaJuridica empresa1 = new PessoaJuridica(
			"Sia Cursos", 
			"Rua dos bobos nÂ°0", 
			"17.452.061/0001-92", 
			"Vender cursos online"
		);
			
		ContaPoupanca cpPessoa1 = new ContaPoupanca(pessoa1, 2000, 0.1);
		ContaEspecial ceEmpresa1 = new ContaEspecial(empresa1, 5000, 2000);
			
		MainClass.pessoas.add(pessoa1);
		MainClass.pessoas.add(empresa1);
		MainClass.contas.add(cpPessoa1);
		MainClass.contas.add(ceEmpresa1);

		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();

		System.out.println("-------------------------");
		System.out.println("---- Seja Bem Vindo!-----");
		System.out.println("-------------------------");
		menu.menuPrincipal(sc);
		System.out.println("-------------------------");
		System.out.println("-- Programa encerrado!---");
		System.out.println("------- AtÃ© Mais!--------");
		System.out.println("-------------------------");
	}
}

/* PessoaFisica pessoa2 = new PessoaFisica(
	"Manchinha", 
	"av. pres jk area 2", 
	"020.204.642-11", 
	idadePessoa2, 
	FEMININO
); */
/* PessoaJuridica empresa2 = new PessoaJuridica(
	"Sia Padaria", 
	"Rua dos bobos nÂ°32", 
	"06.679.801/0001-01", 
	"Vender pÃ£es e doces"
); */