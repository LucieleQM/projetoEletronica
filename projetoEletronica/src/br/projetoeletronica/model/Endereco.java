package br.projetoeletronica.model;

public class Endereco {
	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;

	
	public Endereco() {
		this.rua = null;
		this.numero = null;
		this.bairro = null;
		this.cep = null;
		this.cidade = null;
		this.uf = null;
	}


	public Endereco(String rua, String numero, String bairro, String cep, String cidade, String uf) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return rua + ", " + numero + ", " + bairro + ", " + cep  + ", " + cidade  + ", " + uf ; 
	}
	


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}

}
