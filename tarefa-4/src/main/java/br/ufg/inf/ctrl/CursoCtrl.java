package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.CursoException;
import br.ufg.inf.ctrl.negocio.CursoNegocio;
import br.ufg.inf.model.entities.Curso;

public class CursoCtrl {

	CursoNegocio negocio = new CursoNegocio();

	public Curso inserir(Curso curso) {
		try {
			curso = negocio.inserir(curso);
			System.out.println("Curso cadastrado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar cadastrar curso.");
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public List<Curso> buscaTodos() {
		List<Curso> cursos = null;
		try {
			cursos = negocio.buscaTodos();
		} catch (CursoException e) {
			System.out.println("Erro tentar buscar os cursos cadastrados.");
			System.out.println(e.getMessage());
		}
		return cursos;
	}

	public Curso buscaPorId(Integer id) {
		Curso curso = null;
		try {
			curso = negocio.buscaPorId(id);
			System.out.println("Curso buscado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro tentar buscar curso do ID: " + id + ".");
			System.out.println(e.getMessage());
		}		
		return curso;
	}

	public Curso alterar(Curso curso) {
		try {
			curso = negocio.alterar(curso);
			System.out.println("Curso alterado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar alterar curso com ID: " + curso.getIdCurso() + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Curso excluído com sucesso.");
		} catch (CursoException e) {
			System.out.println("Erro ao tentar excluir curso");
			System.out.println(e.getMessage());
		}
	}

	public List<Curso> buscaPorNome(String str) {
		List<Curso> busca = null;
		try {
			busca = negocio.buscaPorNome(str);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar Buscar por nome");
			System.out.println(e.getMessage());
		}
		return busca;
	}
}

