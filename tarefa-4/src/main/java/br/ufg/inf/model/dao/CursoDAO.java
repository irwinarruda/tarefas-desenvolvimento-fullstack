package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.ctrl.exception.CursoException;
import br.ufg.inf.model.entities.Curso;

public class CursoDAO {
    EntityManager entityManager = DaoFactory.getEntityManager();

    public Curso inserir(Curso curso) throws CursoException {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(curso);
        this.entityManager.getTransaction().commit();
        return curso;
    }

    public List<Curso> buscaTodos() throws CursoException {
        return this.entityManager.createQuery("from Curso", Curso.class).getResultList();
    }

    public Curso buscaPorId(Integer id) throws CursoException {
        Curso newCurso = this.entityManager.find(Curso.class, id);
        return newCurso;
    }

    public Curso alterar(Curso curso) throws CursoException {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(curso);
        this.entityManager.getTransaction().commit();
        return curso;
    }

    public void excluir(Integer id) throws CursoException {
        this.entityManager.remove(this.buscaPorId(id));
    }

    public List<Curso> buscaPorNome(String str) throws CursoException {
        String sql = "from Curso d where d.nmCurso like :str";
        TypedQuery<Curso> query = this.entityManager.createQuery(sql, Curso.class);
        query.setParameter("str", "%"+str+"%");
        return query.getResultList();
    }
}
