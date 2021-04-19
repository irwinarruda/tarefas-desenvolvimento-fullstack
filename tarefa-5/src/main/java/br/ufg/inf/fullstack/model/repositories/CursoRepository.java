package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fullstack.model.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}