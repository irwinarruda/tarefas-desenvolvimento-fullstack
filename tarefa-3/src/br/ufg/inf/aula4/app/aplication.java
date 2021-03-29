package br.ufg.inf.aula4.app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Driver;

import br.ufg.inf.aula4.ctrl.AlunoCtrl;
import br.ufg.inf.aula4.ctrl.CursoCtrl;
import br.ufg.inf.aula4.ctrl.DisciplinaCtrl;
import br.ufg.inf.aula4.ctrl.OfertaCtrl;
import br.ufg.inf.aula4.ctrl.PessoaCtrl;
import br.ufg.inf.aula4.ctrl.ProfessorCtrl;
import br.ufg.inf.aula4.model.entities.Aluno;
import br.ufg.inf.aula4.model.entities.Curso;
import br.ufg.inf.aula4.model.enums.Dia;

public class aplication {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {

		System.out.println("Come�ando por aqui");
		Class.forName("com.mysql.jdbc.Driver");
	
		/* CursoCtrl ctrl = new CursoCtrl(); 
		
		Curso curso1 = new Curso(null, "Des. FullStack");
		Curso curso2 = new Curso(null, "Programação");
		Curso curso3 = new Curso(null, "Inteligência Artificial");

		ctrl.inserir(curso1);
		ctrl.inserir(curso2);
		ctrl.inserir(curso3);	
		
		System.out.println("--------------------------------------------------");

		System.out.println("Disciplinas Cadastradas");
		for (Curso cur : ctrl.buscaTodos()) {
			System.out.println(cur);
		}

		System.out.println("--------------------------------------------------");
		System.out.println("Buscar pelo id 2: " + ctrl.buscaPorId(2));

		System.out.println("--------------------------------------------------");
		curso3.setNmCurso("Novo Nome");;
		ctrl.alterar(curso3); */

		CursoCtrl cursoCtrl = new CursoCtrl(); 
		PessoaCtrl pessoaCtrl = new PessoaCtrl(); 
		
		AlunoCtrl alunoCtrl = new AlunoCtrl(); 

		Aluno aluno1 = new Aluno(
			null, 
			new SimpleDateFormat("yyyy-MM-dd").parse("2021-3-10"), 
			true, 
			pessoaCtrl.buscaPorId(6), 
			cursoCtrl.buscaPorId(10)
		);

		alunoCtrl.inserir(aluno1);

		aluno1.setAtivo(false);

		alunoCtrl.alterar(aluno1);
	}
}
