package com.gama.accenture.service;

import com.gama.accenture.dao.MarcaDAO;
import com.gama.accenture.modelo.Marca;
import com.gama.accenture.util.JPAUtil;

import javax.persistence.EntityManager;

public class MarcaService {
    public static void main(String[] args) {
        Marca newMarca = new Marca("Nike");
        EntityManager em = JPAUtil.getEntityManager();
        MarcaDAO marcaDao = new MarcaDAO(em);
        em.getTransaction().begin();
        marcaDao.criar(newMarca);
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarMarca(String nome) {
        Marca newMarca = new Marca(nome);
        EntityManager em = JPAUtil.getEntityManager();
        MarcaDAO marcaDao = new MarcaDAO(em);
        em.getTransaction().begin();
        marcaDao.criar(newMarca);
        em.getTransaction().commit();
        em.close();
    }
}
