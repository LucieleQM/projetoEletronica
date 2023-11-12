package br.projetoeletronica.model;

public class Cliente extends Pessoa {
	long id;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf, String endereco, String telefone, String email, long id) {
		super(nome, cpf, endereco, telefone, email);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
