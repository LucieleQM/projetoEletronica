package projetoEletronica;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private Endereco endereco;
	private String telefone;
	private String email;
	
	public Pessoa() {
		this.nome = null;
		this.cpf = null;
		this.endereco = null;
		this.telefone = null;
		this.email = null;
	}
	

	public Pessoa(String nome, String cpf, Endereco endereco, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
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


