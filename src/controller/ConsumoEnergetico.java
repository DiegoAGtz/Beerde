package controller;

public class ConsumoEnergetico {
	
	private int id;
	private String ciudad;
	private float domestico;
	private float agricola;
	private float industrial;
	private float velocidad;
	
	public ConsumoEnergetico(int id, String ciudad, float domestico, float agricola, float industrial, float velocidad) {
		this.id=id;
		this.ciudad=ciudad;
		this.domestico=domestico;
		this.agricola=agricola;
		this.industrial=industrial;
		this.velocidad=velocidad;
	}
	
	public ConsumoEnergetico(int id) {
		this.ciudad="";
		this.domestico=0;
		this.agricola=0;
		this.industrial=0;
	}

	public int getId() {
		return id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public float getDomestico() {
		return domestico;
	}

	public void setDomestico(float domestico) {
		this.domestico = domestico;
	}

	public float getAgricola() {
		return agricola;
	}

	public void setAgricola(float agricola) {
		this.agricola = agricola;
	}

	public float getIndustrial() {
		return industrial;
	}

	public void setIndustrial(float industrial) {
		this.industrial = industrial;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad=velocidad;
	}
	
	public float getVelocidad() {
		return velocidad;
	}
}
