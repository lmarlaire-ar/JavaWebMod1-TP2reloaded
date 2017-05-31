package edu.utn.model;

public class Jugador extends Persona implements IPosicion {

	private double altura;
	private String posicion; 
	private int calificacion;
	
	public Jugador(int id, String nombre, String apellido, double altura) {
		super(id, nombre, apellido);
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String eligePosicion(int posicion) {
		switch (posicion) {
		case 1:
			return "BASE";
		case 2:
			return "AYUDA BASE";
		case 3:
			return "ALA";
		case 4: 
			return "ALA PIVOT";
		case 5:
			return "PIVOT";
		default:
			break;
		}
		
		return "No corresponde a ninguna posicion";
	}

	@Override
	public String toString() {
		return "Jugador [" +super.toString()+ "altura=" + altura + ", posicion=" + posicion + ", calificacion=" + calificacion + "]";
	}
	

//	@Override
//	public String toString() {
//		return "Jugador [altura=" + altura + ", posicion=" + posicion + ", calificacion=" + calificacion + "]";
//	}

	

}
