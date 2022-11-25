package br.com.mesttra.carro;

import java.util.List;
import java.util.Scanner;

import br.com.mesttra.dao.CarroDAO;
import br.com.mesttra.entity.Carro;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CarroDAO carroDAO = new CarroDAO();
		
		while (true) {
			int resp = menu(sc);
			
			switch (resp) {
			
			case 1:
				inserir(sc, carroDAO);
				break;
				
			case 2:
				remover(sc, carroDAO);
				break;
				
			case 3:
				ver(sc, carroDAO);
				break;
				
			case 4:
				verTodos(carroDAO);
				break;
				
			case 5:
				System.exit(0);
			}	
		}
	}

	private static int menu(Scanner sc) {
		System.out.println("1-Inserir carro");
		System.out.println("2-Remover carro");
		System.out.println("3-Ver carro");
		System.out.println("4-Ver todos");
		System.out.println("5-Sair");
		return sc.nextInt();
	}

	private static void verTodos(CarroDAO carroDAO) {
		System.out.println("Ver todos os carros");
		List<Carro> carros = carroDAO.verCarros();
		for (Carro carro : carros) {
			System.out.println(carro);
		}
	}

	private static void ver(Scanner sc, CarroDAO carroDAO) {
		System.out.println("Ver carro");
		System.out.print("Placa: ");
		String placa = sc.next();
		
		Carro carro = carroDAO.verCarro(placa);
		System.out.println(carro);
	}

	private static void remover(Scanner sc, CarroDAO carroDAO) {
		System.out.println("Remover carro");
		System.out.print("Placa: ");
		String placa = sc.next();
		
		carroDAO.removerCarro(placa);
	}

	private static void inserir(Scanner sc, CarroDAO carroDAO) {
		System.out.println("Inserir carro");
		System.out.print("Placa: ");
		String placa = sc.next();
		
		System.out.print("Cor: ");
		String cor = sc.next();
		
		System.out.print("Marca: ");
		String marca = sc.next();
		
		System.out.print("Modelo: ");
		String modelo = sc.next();
		
		System.out.print("Velocidade máxima: ");
		double velMax = sc.nextDouble();
		
		carroDAO.inserirCarro(new Carro(placa, cor, marca, modelo, velMax));
	}

}
