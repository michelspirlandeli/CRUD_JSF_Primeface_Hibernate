package com.produto.bean;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="tab_embalagem")
public class EmbalagemBean {
	@Id
	@GeneratedValue
	private Long id;
	private Double qtunitaria;
	private Double fatorpreco;
	private long codbarras;
	private String descricaoemb;
	private String unidadevenda;
	@Temporal(TemporalType.DATE)
	private Calendar dtcadastro;
	@ManyToOne
	@JoinColumn(name="prod_id")
	private ProdutoBean produto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getQtunitaria() {
		return qtunitaria;
	}
	public void setQtunitaria(Double qtunitaria) {
		this.qtunitaria = qtunitaria;
	}
	public Double getFatorpreco() {
		return fatorpreco;
	}
	public void setFatorpreco(Double fatorpreco) {
		this.fatorpreco = fatorpreco;
	}
	public long getCodbarras() {
		return codbarras;
	}
	public void setCodbarras(long codbarras) {
		this.codbarras = codbarras;
	}
	public String getDescricaoemb() {
		return descricaoemb;
	}
	public void setDescricaoemb(String descricaoemb) {
		this.descricaoemb = descricaoemb;
	}
	public String getUnidadevenda() {
		return unidadevenda;
	}
	public void setUnidadevenda(String unidadevenda) {
		this.unidadevenda = unidadevenda;
	}
	public Calendar getDtcadastro() {
		return dtcadastro;
	}
	public void setDtcadastro(Calendar dtcadastro) {
		this.dtcadastro = dtcadastro;
	}
	public ProdutoBean getProduto() {
		return produto;
	}
	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}
	public String novaEmbalagem(){
		return "cadastrar_embalagem";		
	}
	public String cancela() {
		return "index";
	}
}
