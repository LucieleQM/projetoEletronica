package br.projetoeletronica.model;

public class Eletronico {
	private String numSerial;
	private String tipo;
	private String marca;
	private String modelo;
	private Cliente cliente;

	public Eletronico() {
		
	}
	
	public Eletronico(String numSerial,String tipo,String marca, String modelo, Cliente cliente) {
		this.numSerial = numSerial;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente = cliente;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumSerial() {
		return numSerial;
	}

	public void setNumSerial(String numSerial) {
		this.numSerial = numSerial;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
