package com.gama.accenture.service;

import com.gama.accenture.dao.UsuarioDAO;
import com.gama.accenture.modelo.Usuario;
import com.gama.accenture.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioService {
    public static void main(String[] args) {
        Usuario newUser = new Usuario("Gustavo", "32132132123", "aluno", "12344321");
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        em.getTransaction().begin();
        usuarioDAO.criar(newUser);
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastarUsuario(String nome, String cpf, String login, String senha) {
        Usuario newUser = new Usuario(nome, cpf, login, senha);
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        em.getTransaction().begin();
        usuarioDAO.criar(newUser);
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarUsuario(Long id, String nome, String cpf, String login, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        em.getTransaction().begin();
        Usuario p = usuarioDAO.buscarPorId(id);
        p.setNome(nome);
        p.setCpf(cpf);
        p.setLogin(login);
        p.setSenha(senha);
        em.getTransaction().commit();
        em.close();
    }

    public static void apagarUsuario(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        em.getTransaction().begin();
        Usuario p = usuarioDAO.buscarPorId(id);
        usuarioDAO.apagar(p);
        em.getTransaction().commit();
        em.close();
    }

    public static Usuario buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        return usuarioDAO.buscarPorId(id);
    }

    public static List<Usuario> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        return usuarioDAO.buscarTodos();
    }

}
