package model;

public class TipoServico {
	private Long id;
	private String nome;
	private String descricao;
	private double precoBase;
	
	public TipoServico() {
		
	}
	
	public TipoServico(Long id, String nome, String descricao, double precoBase) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoBase = precoBase;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoBase() {
		return precoBase;
	}
	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	
	
}
