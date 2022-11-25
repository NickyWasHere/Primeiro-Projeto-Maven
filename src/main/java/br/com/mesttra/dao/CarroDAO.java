package br.com.mesttra.dao;

import java.sql.Connection;

import br.com.mesttra.connectionFactory.ConnectionFactory;

public class CarroDAO {
 
	private Connection conn;
	
	public CarroDAO() {
		this.conn = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
		System.out.println();
	}
}
