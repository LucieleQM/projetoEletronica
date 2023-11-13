package br.projetoeletronica.model;

public abstract class Pessoa {
	private long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	
	public Pessoa() {
		this.nome = null;
		this.cpf = null;
		this.endereco = null;
		this.telefone = null;
		this.email = null;
	}
	

	public Pessoa(long id,String nome, String cpf, String endereco, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	

}


