package br.com.mesttra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //Indica uma entidade/tabela no banco de dados
public class Carro {

	@Id //Indica chave primária
	private String placa;
	
	@Column(nullable = false) //NOT NULL
	private String cor;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(name = "vel_max") //Indica o nome que este atributo terá no banco (vel_max)
	private double velMax;
	
	public Carro() {
		
	}
	
	public Carro(String placa, String cor, String marca, String modelo, double velMax) {
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.velMax = velMax;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
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

	public double getVelMax() {
		return velMax;
	}

	public void setVelMax(double velMax) {
		this.velMax = velMax;
	}

	@Override
	public String toString() {
		return "Placa: " + placa +
				"\nCor: " + cor +
				"\nMarca: " + marca +
				"\nModelo: " + modelo +
				"\nVelocidade máxima: " + velMax;
	}
}
