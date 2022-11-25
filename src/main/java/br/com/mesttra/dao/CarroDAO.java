package br.com.mesttra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.mesttra.entity.Carro;

public class CarroDAO {
 
	///private Connection conn;
	private EntityManager manager;
	
	public CarroDAO() {
		//this.conn = new ConnectionFactory().getConnection();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		this.manager = factory.createEntityManager();
		
		System.out.println("Conectado\n");
	}
	
	public void inserirCarro(Carro carro) {		
//		String sql = "INSERT INTO Carro VALUES (?, ?, ?, ?, ?)";
//		
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, carro.getPlaca());
//			stmt.setString(2, carro.getCor());
//			stmt.setString(3, carro.getMarca());
//			stmt.setString(4, carro.getModelo());
//			stmt.setDouble(5, carro.getVelMax());
//			stmt.execute();
//			stmt.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		manager.getTransaction().begin(); //Começa a transação com o banco
		manager.persist(carro); //Insere no banco
		manager.getTransaction().commit(); //Salva essa mudança
		
		System.out.println("Carro inserido\n");
	}
	
	public void removerCarro(String placa) {
//		String sql = "DELETE FROM Carro WHERE placa = ?";
//		
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, placa);
//			stmt.execute();
//			stmt.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		Carro carro = manager.find(Carro.class, placa); //Retorna um carro do banco de acordo com a chave primária
		
		if (carro!=null) {
			manager.getTransaction().begin();
			manager.remove(carro); //Remove do banco
			manager.getTransaction().commit();
			
			System.out.println("Carro removido");
			
		} else {
			System.out.println("Este carro não existe");
		}
	}
	
	public Carro verCarro(String placa) {
//		String sql = "SELECT * FROM Carro WHERE placa = ?";
//		
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, placa);
//			
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Carro carro = new Carro();
//				
//				carro.setPlaca(rs.getString("placa"));
//				carro.setCor(rs.getString("cor"));
//				carro.setMarca(rs.getString("marca"));
//				carro.setModelo(rs.getString("modelo"));
//				carro.setVelMax(rs.getDouble("velMax"));
//				
//				return carro;
//			}
//			
//		} catch (SQLException e) {
//				e.printStackTrace();
//		}
//		
//		return null;
		
		return manager.find(Carro.class, placa);
	}
	
	public List<Carro> verCarros() {
//		String sql = "SELECT * FROM Carro";
//		List<Carro> carros = new ArrayList<Carro>();
//		
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Carro carro = new Carro();
//				
//				carro.setPlaca(rs.getString("placa"));
//				carro.setCor(rs.getString("cor"));
//				carro.setMarca(rs.getString("marca"));
//				carro.setModelo(rs.getString("modelo"));
//				carro.setVelMax(rs.getDouble("velMax"));
//				
//				carros.add(carro);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return carros;
		
		//Retorna uma query com múltiplos carros do banco
		Query query = manager.createQuery("SELECT c FROM Carro as c"); 
		return query.getResultList();
	}
}
