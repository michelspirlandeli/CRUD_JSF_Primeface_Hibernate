package com.produto.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.produto.dao.DAOUsuario;
import com.produto.bean.Usuario;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {

	@EJB
	private DAOUsuario service = new DAOUsuario();

	private Long idSelecionado;
	private List<Usuario> usuarios;
	private Usuario usuario;

	public UsuarioMB() {
		usuario = new Usuario();
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void incluir() {
		usuario = new Usuario();
	}

	public String efetuarRegistro() {

		FacesContext context = FacesContext.getCurrentInstance();

		if (this.usuario.getLogin().isEmpty()
				|| this.usuario.getSenha().isEmpty()) {
			context.addMessage("login", new FacesMessage(
					"Usuário e senha inválidos."));
			return "UsuarioRegistrar";
		}

		String sql = "select a from t_usuario a where a.login = '"
				+ usuario.getLogin() + "'";

		if (!service.consultarPorQuery(sql).isEmpty()) {
			context.addMessage("login", new FacesMessage(
					"Ja existe um usuário com o Login informado."));
			return "UsuarioRegistrar";
		} else {
			service.inserir(usuario);
			return "UsuarioLogin";
		}
		
	}

	public String efetuarLogin() {

		FacesContext context = FacesContext.getCurrentInstance();

		if (this.usuario.getLogin().isEmpty()
				|| this.usuario.getSenha().isEmpty()) {
			context.addMessage("login", new FacesMessage(
					"Usuário e senha inválidos."));
			return "UsuarioLogin";
		}

		String sql = "select a from t_usuario a where a.login = '"
				+ usuario.getLogin() + "' and a.senha = '" + usuario.getSenha()
				+ "'";

		if (!service.consultarPorQuery(sql).isEmpty()) {
			
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("username", usuario.getLogin());
			
			return "ProdutoListar";
		} else {
			
			context.addMessage("login", new FacesMessage(
					"Usuário e senha inválidos."));
			return "UsuarioLogin";
		
		}

	}

	public String cancela() {
		return "UsuarioLogin";
	}

	public String salvar() {
		service.atualizar(usuario);
		return "UsuarioListar";
	}

	public String remover() {
		service.excluir(usuario);
		return "UsuarioListar";
	}

	public String registrar() {
		return "UsuarioRegistrar";
	}
	
	public String efetuarLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "UsuarioLogin";
	}

}
