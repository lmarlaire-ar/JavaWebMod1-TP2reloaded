package edu.utn.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.utn.controller.*;
import edu.utn.model.*;

public class EjecucionTP2 {

	private static final String FILENAME1 = "C:\\Temp\\ListaJugadores.txt";
	private static final String FILENAME2 = "C:\\Temp\\ListaMejoresJugadores.txt";
	
	public static void main(String[] args) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		//1 - Alta DTs
		DirectorTecnico dt1 = new DirectorTecnico(123, "Marcelo", "Bielsa");
		DirectorTecnico dt2 = new DirectorTecnico(321, "Edgardo", "Bauza");
		DirectorTecnico dt3 = new DirectorTecnico(445, "Cholo", "Simeone");
		DirectorTecnico dt4 = new DirectorTecnico(123, "Ramón", "Diaz");
		
		
		//2 - Asignacion Jurados
		Jurado jurado1 = new Jurado();
		jurado1.agregaDTalJurado(dt1, dt2);
		
		Jurado jurado2 = new Jurado();
		jurado2.agregaDTalJurado(dt3, dt4);
		
		//3 - Alta Jugadores
		JugadorController jugadorCtl = new JugadorController();
		
		jugadorCtl.agregaJugador(new Jugador(101,"Manu","Ginobilli",1.90));
		jugadorCtl.agregaJugador(new Jugador(102,"Chelo","Gino",2.05));
		jugadorCtl.agregaJugador(new Jugador(103,"Pipo","Johny",1.95));
		jugadorCtl.agregaJugador(new Jugador(104,"Gato","Lipa",1.98));
		jugadorCtl.agregaJugador(new Jugador(105,"Manu","Loma",1.98));
		jugadorCtl.agregaJugador(new Jugador(106,"Nombre6","Apellido6",1.98));
		jugadorCtl.agregaJugador(new Jugador(107,"Nombre7","Apellido7",2.05));
		jugadorCtl.agregaJugador(new Jugador(108,"Nombre8","Apellido8",2.05));
		jugadorCtl.agregaJugador(new Jugador(109,"Nombre9","Apellido9",2.05));
		jugadorCtl.agregaJugador(new Jugador(110,"Nombre10","Apellido10",2.05));
		jugadorCtl.agregaJugador(new Jugador(111,"Nombre11","Apellido11",2.05));
		jugadorCtl.agregaJugador(new Jugador(112,"Nombre12","Apellido12",2.05));
		jugadorCtl.agregaJugador(new Jugador(113,"Nombre13","Apellido13",1.98));
		jugadorCtl.agregaJugador(new Jugador(114,"Nombre14","Apellido14",2.05));
		jugadorCtl.agregaJugador(new Jugador(115,"Nombre15","Apellido15",1.98));
		jugadorCtl.agregaJugador(new Jugador(116,"Nombre16","Apellido16",2.05));
		jugadorCtl.agregaJugador(new Jugador(117,"Nombre17","Apellido17",1.98));
		jugadorCtl.agregaJugador(new Jugador(118,"Nombre18","Apellido18",2.05));
		jugadorCtl.agregaJugador(new Jugador(119,"Nombre19","Apellido19",1.98));
		jugadorCtl.agregaJugador(new Jugador(120,"Nombre20","Apellido20",2.05));
		
		
		//4 - Calificacion Jugadores
		int contPos=0;
		for (Jugador jugador : jugadorCtl.getListaJugadores()) {
			Random rn = new Random();
			int auxRn = rn.nextInt()%101;
			if(auxRn < 0){
				auxRn = auxRn * (-1);
			}
			jugador.setCalificacion(auxRn);
			//El jurado le asigna la posición			
			if(contPos < 4)
				jugador.setPosicion(jugador.eligePosicion(1));
			else {
				if(contPos < 8){
					jugador.setPosicion(jugador.eligePosicion(2));
				}
				else{
					if(contPos < 12)
						jugador.setPosicion(jugador.eligePosicion(3));
					else{
						if(contPos < 16)
							jugador.setPosicion(jugador.eligePosicion(4));
						else
							jugador.setPosicion(jugador.eligePosicion(5));
					}
				}
			}
			contPos++;
		}
		
		//5 - Determinar Jugadores Seleccionados
		// 	Guardar lista de jugadores en Archivo	

		System.out.println("================Lista de Jugadores=======================");
		try{
			
			fw = new FileWriter(FILENAME1);
			bw = new BufferedWriter(fw);
			for (Jugador jugador : jugadorCtl.getListaJugadores()){
				System.out.println(jugador);
				String content = jugador.toString()+"\n";
				bw.write(content);
			}
			System.out.println("====> Archivo copiado en "+ FILENAME1);
		} catch (IOException e){
			e.printStackTrace();
		}finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		
		ArrayList<Jugador> listaMejores = new ArrayList<Jugador>();
				
		listaMejores.addAll(jugadorCtl.tomarLosMejores(3));
		
		//6 - Guardar lista de jugadores en Archivo	
		System.out.println(" ");
		System.out.println("================Lista de Mejores=======================");
		try{
			
			fw = new FileWriter(FILENAME2);
			bw = new BufferedWriter(fw);
			for (Jugador jugador : listaMejores) {
				System.out.println(jugador);
				String content = jugador.toString()+"\n";
				bw.write(content);
			}
			System.out.println("====> Archivo copiado en "+ FILENAME2);
		} catch (IOException e){
			e.printStackTrace();
		}finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

				}
	
			}
		}
	}

}