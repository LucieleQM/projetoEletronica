package br.projetoeletronica.model;

public class Eletronico {
	private String numSerial;
	private String tipo;
	private String marca;
	private String modelo;
	private Cliente cliente;
	private String avarias;
	private String defeito;

	public Eletronico() {
		
	}
	
	public Eletronico(String numSerial,String tipo,String marca, String modelo, Cliente cliente, String avarias, String defeito) {
		this.numSerial = numSerial;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente = cliente;
		this.avarias = avarias;
		this.defeito = defeito;
	}


	public String getAvarias() {
		return avarias;
	}

	public void setAvarias(String avarias) {
		this.avarias = avarias;
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

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	
	
	
}
