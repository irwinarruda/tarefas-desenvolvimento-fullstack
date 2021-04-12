package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.AlunoException;
import br.ufg.inf.ctrl.negocio.AlunoNegocio;
import br.ufg.inf.model.entities.Aluno;

public class AlunoCtrl {

	AlunoNegocio negocio = new AlunoNegocio();

	public Aluno inserir(Aluno aluno) {
		try {
			aluno = negocio.inserir(aluno);
			System.out.println("Aluno cadastrado com sucesso: " + aluno);
		} catch (AlunoException e) {
			System.out.println("Erro ao tentar cadastrar aluno.");
			System.out.println(e.getMessage());
		}
		return aluno;
	}

	public List<Aluno> buscaTodos() {
		List<Aluno> alunos = null;
		try {
			alunos = negocio.buscaTodos();
		} catch (AlunoException e) {
			System.out.println("Erro tentar buscar os alunos cadastrados.");
			System.out.println(e.getMessage());
		}
		return alunos;
	}

	public Aluno buscaPorId(Integer id) {
		Aluno aluno = null;
		try {
			aluno = negocio.buscaPorId(id);
		} catch (AlunoException e) {
			System.out.println("Erro tentar buscar aluno de ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return aluno;
	}

	public Aluno alterar(Aluno aluno) {
		try {
			aluno = negocio.alterar(aluno);
			System.out.println("Aluno alterado com sucesso: " + aluno);
		} catch (AlunoException e) {
			System.out.println("Erro ao tentar alterar aluno com ID: " + aluno.getIdAluno() + ".");
			System.out.println(e.getMessage());
		}
		return aluno;
	}

	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Aluno excluído com sucesso.");
		} catch (AlunoException e) {
			System.out.println("Erro ao tentar excluir aluno");
			System.out.println(e.getMessage());
		}
	}
}


