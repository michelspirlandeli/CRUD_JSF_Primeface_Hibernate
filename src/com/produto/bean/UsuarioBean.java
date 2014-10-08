package com.produto.bean;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.produto.dao.DAOUsuario;

@Entity(name="tab_usuario")
public class UsuarioBean{
	@Id
	@GeneratedValue
    private Integer id;
    private String nome;
    private String login;
    private String senha;
    @javax.persistence.Transient
    private String mensagem;
    @javax.persistence.Transient
    private DAOUsuario persistencia;
    
    public UsuarioBean(){
    	this.persistencia = new DAOUsuario();
    }
    
    public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void Usuario(){    	
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
	
    public String login()
    {
        if(false)
        {
            return "home";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("login", new FacesMessage("Invalid UserName and Password"));
            return "UsuarioLogin";
        }
    }
    
	public String efetuarRegistro(){
		return "UsuarioLogin";		
	}
    
	public String registrar(){
		return "UsuarioRegistrar";		
	}
	
	public String cancela(){
		return "UsuarioLogin";
	}
}