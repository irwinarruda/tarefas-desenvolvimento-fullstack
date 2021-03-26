package application;
import java.util.Calendar;
import java.util.Scanner;

import contas.handle.Conta;
import contas.handle.ContaPoupanca;
import contas.handle.ContaEspecial;
import pessoas.handle.Pessoa;
import pessoas.handle.PessoaFisica;
import pessoas.handle.PessoaJuridica;

public class Menu {

	public void menuPrincipal(Scanner sc) {
		Integer escolha = 1;
		Conta conta;
		Pessoa pessoa;
		do {
			this.showMenuPrincipal();
			try {
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					pessoa = this.buscarPessoa(sc);
					this.cadastrarConta(sc, pessoa);
					break;

				case 2:
					conta = this.buscarConta(sc);
					this.menuConta(sc, conta);
					break;

				case 3:
					this.cadatrarCliente(sc);
					break;

				case 4:
					System.out.println("Implentar Relatórios");
					break;

				case 5:
					System.out.println("Saindo...");
					break;

				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 5;
			}
		} while (escolha != 5);

	}

	private void cadatrarCliente(Scanner sc) {

		System.out.println("--- Novo Cliente-----");
		System.out.println("Selecione o tipo de Pessoa");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica");
		
		Integer tipo = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("--- Informe o Nome -----");
		String nome = sc.nextLine();
		
		System.out.println("--- Informe o Endereço -----");
		String endereco = sc.nextLine();
		
		if(tipo == 1) {
			System.out.println("--- Informe o CPF -----");
			String cpf = sc.nextLine();
			
			System.out.println("--- Informe a Data de Nascimento -----");
			String[] dtAux = sc.nextLine().trim().split("/");
			
			Calendar dtNascimento = Calendar.getInstance();
			dtNascimento.set(Integer.parseInt(dtAux[2]), Integer.parseInt(dtAux[1]), Integer.parseInt(dtAux[0]));
			
					
			System.out.println("--- Informe o Genero (male/female) -----");
			String genero = sc.next();
			
			MainClass.pessoas.add(new PessoaFisica(nome, endereco, cpf, dtNascimento, genero));
			
		}else {
			System.out.println("--- Informe o CNPJ -----");
			String cnpj = sc.nextLine();
			
			System.out.println("--- Informe sua atividade -----");
			String atividade = sc.nextLine();
			
			MainClass.pessoas.add(new PessoaJuridica(nome, endereco, cnpj, atividade));
		}

	}

	private void cadastrarConta(Scanner sc, Pessoa pessoa) {

		System.out.println("--- Nova Conta-----");
		System.out.println("Selecione o tipo de Conta");
		System.out.println("1 - Conta Poupança");
		System.out.println("2 - Conta Especial");
		
		Integer tipo = sc.nextInt();
				
		System.out.println("--- Informe o Saldo inicial -----");
		double saldo = sc.nextDouble();
		
		if(tipo == 1) {
			System.out.println("--- Informe a taxa de Correção -----");
			double txCorrecao = sc.nextDouble();
			
			MainClass.contas.add(new ContaPoupanca(pessoa, saldo, txCorrecao));
			
		} else {
			System.out.println("--- Informe o Limite -----");
			double limite = sc.nextDouble();
			
			MainClass.contas.add(new ContaEspecial(pessoa, saldo, limite));
		}

		sc.nextLine();
	}

	private void menuConta(Scanner sc, Conta conta) {
		
		Integer escolha = 1;
		do {
			this.showMenuConta(conta);
			try {
				escolha = sc.nextInt();
				double valor;
				if(escolha > 6 && escolha < 1) {
					throw new Exception();
				}
				switch (escolha) {
					case 1: 
						conta = this.buscarConta(sc);
						break;
					case 2: 
						System.out.println("Informe o Valor do Depósito");
						valor = sc.nextDouble();
						conta.depositar(valor);
						break;
					case 3: 
						System.out.println("Informe o Valor para Saque");
						valor = sc.nextDouble();
						conta.sacar(valor);
						
						break;
					case 4: 
						Conta destino = this.buscarConta(sc);
						System.out.println("Informe o Valor para Transferência");
						valor = sc.nextDouble();
						conta.transferir(destino, valor);
						break;
					case 5:
						System.out.println("-------------------------");
						System.out.println("--- SALDO: R$ "+conta.getSaldo());
						System.out.println("-------------------------");
						
						break;
				}

			}  catch (Exception err) {
				System.out.println("O número deve estar entre 1 e 6. Saindo...");
				escolha = 6;
			}
		}while (escolha != 6);
	}

	private void showMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 - Abrir Nova Conta");
		System.out.println("2 - Selecionar Conta");
		System.out.println("3 - Cadastrar Cliente");
		System.out.println("4 - Relatórios");
		System.out.println("5 - Sair");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta conta) {
		System.out.println("-------------------------");
		System.out.println("Cliente: " + conta.getCliente().getNome());
		System.out.println("Nr Conta: " + conta.getNrConta());
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 - Alterar Conta");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Saldo");
		System.out.println("6 - Sair");
		System.out.println("-------------------------");
	}

	public Pessoa buscarPessoa(Scanner sc) {

		Pessoa pessoa = null;
		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o id da Pessoa---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Pessoa p : MainClass.pessoas) {

				if (p.getId().equals(escolha)) {
					pessoa = p;
					break;
				}
			}
			if (pessoa == null) {
				System.out.println("------------------------------");
				System.out.println("-----Conta Não Encontrada-----");
				System.out.println("------------------------------");	
			}

		} while (pessoa == null);

		return pessoa;
	}

	public Conta buscarConta(Scanner sc) {

		Conta conta = null;
		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o número da Conta---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Conta c : MainClass.contas) {

				if (c.getNrConta().equals(escolha)) {
					conta = c;
					break;
				}
			}
			if (conta == null) {
				System.out.println("------------------------------");
				System.out.println("-----Conta Não Encontrada-----");
				System.out.println("------------------------------");	
			}

		} while (conta == null);

		return conta;
	}
}
