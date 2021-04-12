package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.AlunoException;
import br.ufg.inf.model.entities.Aluno;

public class AlunoDAO {
    EntityManager entityManager = DaoFactory.getEntityManager();

    public Aluno inserir(Aluno aluno) throws AlunoException {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(aluno);
        this.entityManager.getTransaction().commit();
        return aluno;
    }

    public List<Aluno> buscaTodos() throws AlunoException {
        return this.entityManager.createQuery("from Aluno", Aluno.class).getResultList();
    }

    public Aluno buscaPorId(Integer id) throws AlunoException {
        Aluno newAluno = this.entityManager.find(Aluno.class, id);
        return newAluno;
    }

    public Aluno alterar(Aluno aluno) throws AlunoException {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(aluno);
        this.entityManager.getTransaction().commit();
        return aluno;
    }

    public void excluir(Integer id) throws AlunoException {
        this.entityManager.remove(this.buscaPorId(id));
    }
}

