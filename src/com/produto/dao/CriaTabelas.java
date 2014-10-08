package com.produto.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("up_CRUD");
		factory.close();
		System.out.println("Tabelas criadas com sucesso!");
	}
}
