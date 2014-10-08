package com.produto.bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQuery;

import com.produto.dao.DAOUsuario;

@Entity(name = "t_usuario")
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String login;
	private String senha;

	public Usuario() {

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String registrar() {
		return "UsuarioRegistrar";
	}

}