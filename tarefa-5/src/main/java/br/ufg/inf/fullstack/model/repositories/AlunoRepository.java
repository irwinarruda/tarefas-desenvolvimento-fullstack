package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fullstack.model.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}