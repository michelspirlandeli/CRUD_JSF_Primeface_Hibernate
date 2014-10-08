package com.produto.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="tab_produto")

public class ProdutoBean {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private String unidadedecompra;
	private Double precocusto;
	private Double precovenda;
	private String observacao;
	private Calendar dtcadastro;
	
    public ProdutoBean(){

    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidadedecompra() {
		return unidadedecompra;
	}
	public void setUnidadedecompra(String unidadedecompra) {
		this.unidadedecompra = unidadedecompra;
	}
	public Double getPrecocusto() {
		return precocusto;
	}
	public void setPrecocusto(Double precocusto) {
		this.precocusto = precocusto;
	}
	public Double getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(Double precovenda) {
		this.precovenda = precovenda;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Calendar getDtcadastro() {
		return dtcadastro;
	}
	public void setDtcadastro(Calendar dtcadastro) {
		this.dtcadastro = dtcadastro;
	}	
	public String novoProduto(){
		return "cadastrar_produto";
	}
	public String cancela() {
		return "index";
	}
	
	public List<String> getListaUnidades(){
		List<String> lista = new ArrayList();  
		lista.add("CX");
		lista.add("UN");
		lista.add("PC");
		lista.add("LT");
		lista.add("SC");
		Collections.sort(lista);
		return lista;
	}	
	
	public String salvaProduto() throws Exception{
		return "index";
	}
}
