package com.produto.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.produto.dao.DAOProduto;
import com.produto.bean.Produto;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB implements Serializable {

	@EJB
	private DAOProduto service = new DAOProduto();

	private Long idSelecionado;

	private List<Produto> produtos;

	private Produto produto;

	public ProdutoMB() {

	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public Produto getProduto() {
		return produto;
	}

	public void incluir() {
		produto = new Produto();
	}

	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		produto = service.consultarPeloId(idSelecionado);
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = service.consultarTodos();
		}
		return produtos;
	}

	public String salvar() {
		service.atualizar(produto);
		return "ProdutoListar";
	}

	public String remover() {
		service.excluir(produto);
		return "ProdutoListar";
	}

}
