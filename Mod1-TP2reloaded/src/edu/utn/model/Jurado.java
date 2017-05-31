package edu.utn.model;

import java.util.ArrayList;

public class Jurado {
	private ArrayList<DirectorTecnico> listaDTs;
	
	public Jurado() {
		this.listaDTs = new ArrayList<DirectorTecnico>();
	}
	
	public void agregaDTalJurado(DirectorTecnico dt){
		this.listaDTs.add(dt);
	}
	
	public void agregaDTalJurado(DirectorTecnico dt1, DirectorTecnico dt2){
		this.listaDTs.add(dt1);
		this.listaDTs.add(dt2);
	}

	public ArrayList<DirectorTecnico> getListaDTs() {
		return listaDTs;
	}
	
}
