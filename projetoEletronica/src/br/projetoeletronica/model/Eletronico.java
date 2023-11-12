package br.projetoeletronica.model;

public class Eletronico {
	private String marca;
	private String modelo;
	private String numSerial;
	
	
	public Eletronico(String marca, String modelo, String numSerial) {
		this.marca = marca;
		this.modelo = modelo;
		this.numSerial = numSerial;
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


	public String getNumSerial() {
		return numSerial;
	}


	public void setNumSerial(String numSerial) {
		this.numSerial = numSerial;
	}
	
	
	
	
}
