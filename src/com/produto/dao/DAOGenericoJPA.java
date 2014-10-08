package com.produto.dao;

import java.lang.reflect.*;
import java.util.*;

import javax.persistence.*;

public class DAOGenericoJPA<T> {
	private EntityManager em;
	private EntityManagerFactory emf;

	public DAOGenericoJPA() {
		emf = Persistence.createEntityManagerFactory("up_CRUD");
		em = emf.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getClasse() {
		Class<T> classe = null;
		ParameterizedType pt = (ParameterizedType) ((Class<?>) getClass())
				.getGenericSuperclass();
		classe = (Class<T>) pt.getActualTypeArguments()[0];
		return classe;
	}

	public void inserir(T objeto) {
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();
	}

	public void atualizar(T objeto) {
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();
	}

	public T consultarPeloId(Long id) {
		return em.find(getClasse(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> consultarTodos() {
		String sql = "SELECT C FROM " + getClasse().getName() + " C ";
		return em.createQuery(sql).getResultList();
	}

	// A classe de entidade deve ter o findAll
	@SuppressWarnings("unchecked")
	public List<T> consultarTodosNamedQuery() {
		return em.createNamedQuery("findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> consultarPorQuery(String sql) {
		return em.createQuery(sql).getResultList();
	}

	public void excluir(T objeto) {
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
	}
}
