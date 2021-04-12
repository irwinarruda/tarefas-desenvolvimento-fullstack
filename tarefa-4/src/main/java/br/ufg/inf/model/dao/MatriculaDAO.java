package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.MatriculaException;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaDAO {
    EntityManager entityManager = DaoFactory.getEntityManager();

    public Matricula inserir(Matricula matricula) throws MatriculaException {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(matricula);
        this.entityManager.getTransaction().commit();
        return matricula;
    }

    public List<Matricula> buscaTodos() throws MatriculaException {
        return this.entityManager.createQuery("from Matricula", Matricula.class).getResultList();
    }

    public Matricula buscaPorId(Integer id) throws MatriculaException {
        Matricula newMatricula = this.entityManager.find(Matricula.class, id);
        return newMatricula;
    }

    public Matricula alterar(Matricula matricula) throws MatriculaException {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(matricula);
        this.entityManager.getTransaction().commit();
        return matricula;
    }

    public void excluir(Integer id) throws MatriculaException {
        this.entityManager.remove(this.buscaPorId(id));
    }
}

