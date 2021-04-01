package com.gama.accenture.dao;

import com.gama.accenture.modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO {
    private EntityManager em;
    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public void criar(Usuario usuario) {
        this.em.persist(usuario);
    }

    public void alterar(Usuario usuario) {
        this.em.merge(usuario);
    }

    public void apagar(Usuario usuario) {
        usuario = em.merge(usuario);
        this.em.remove(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos() {
        String jpql = "SELECT p FROM Usuario p";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }
//    public List<Usuario> buscarPorNome(String nome) {
//        String jpql = "SELECT p FROM Produtos p WHERE p.nome = :nome";
//        return em.createQuery(jpql, Usuario.class)
//                .setParameter("nome", nome)
//                .getResultList();
//    }
//    public List<Usuario> buscarPorParteDoNome(String nome) {
//        String jpql = "SELECT p FROM Produtos p WHERE p.nome LIKE :nome";
//        return em.createQuery(jpql, Usuario.class)
//                .setParameter("nome", "%" +nome+ "%")
//                .getResultList();
//    }
}
