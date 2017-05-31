package edu.utn.controller;

import java.util.ArrayList;
import java.util.Comparator;

import edu.utn.model.Jugador;

public class JugadorController implements Comparator {
	private ArrayList<Jugador> listaJugadores;

	public JugadorController() {
		this.listaJugadores = new ArrayList<Jugador>();

	}
	
	public void agregaJugador(Jugador jugador){
		this.listaJugadores.add(jugador); 
	}

	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	
	public ArrayList<Jugador> tomarLosMejores(int nro){
		ArrayList<Jugador> listaMejores = new ArrayList<Jugador>();
		try{
			for (int i = 1; i <= 5; i++) { // recorre por posición para seleccionar los mejores por posicion
				ArrayList<Jugador> listaAux = new ArrayList<Jugador>(nro);
				for (Jugador jugador : listaJugadores) {
					String posicion = jugador.eligePosicion(i);
					if(posicion == jugador.getPosicion()){
						if(listaAux.size()==0)
							listaAux.add(jugador); //si la listaAux está vacía, agrega al jugador
						else{
							if(listaAux.size()==1)
								if(jugador.getCalificacion() > listaAux.get(0).getCalificacion()){
									listaAux.add(jugador);
									Jugador jugadorAux = listaAux.get(0);
									listaAux.set(0, listaAux.get(1));
									listaAux.set(1, jugadorAux);
								}else
									listaAux.add(jugador);
							else{
								if(listaAux.size()==2){
									if(jugador.getCalificacion() > listaAux.get(1).getCalificacion()){
										listaAux.add(jugador);
										Jugador jugadorAux = listaAux.get(1);
										listaAux.set(1, listaAux.get(2));
										listaAux.set(2, jugadorAux);
									}else
										listaAux.add(jugador);
								}
								else{
									if(jugador.getCalificacion() > listaAux.get(2).getCalificacion())
										listaAux.set(2, jugador);
									else{
										if(jugador.getCalificacion() == listaAux.get(2).getCalificacion()){
											listaAux.add(jugador);
										}
									}
									
								}
							}
						
						}
					}
				}
				listaMejores.addAll(listaAux);
			}
		}catch(Exception e){
			System.err.println(e);
		}
		
	
			

		return listaMejores;
	}

	@Override
	public int compare(Object o1, Object o2) {
	
		return 0;
	}
	
}
