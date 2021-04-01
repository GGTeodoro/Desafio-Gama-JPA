package com.gama.accenture.dao;

import com.gama.accenture.modelo.Marca;
import com.gama.accenture.modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class MarcaDAO {
    private EntityManager em;
    public MarcaDAO(EntityManager em) {
        this.em = em;
    }

    public void criar(Marca marca) {
        this.em.persist(marca);
    }

    public void alterar(Marca marca) {
        this.em.merge(marca);
    }

    public void apagar(Marca marca) {
        marca = em.merge(marca);
        this.em.remove(marca);
    }

    public Marca buscarPorId(Long id) {
        return em.find(Marca.class, id);
    }

    public List<Marca> buscarTodos() {
        String jpql = "SELECT p FROM Marca p";
        return em.createQuery(jpql, Marca.class).getResultList();
    }
}
