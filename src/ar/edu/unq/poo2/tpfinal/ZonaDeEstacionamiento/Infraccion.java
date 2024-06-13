package ar.edu.unq.poo2.tpfinal.ZonaDeEstacionamiento;

import java.time.LocalDateTime;

public class Infraccion {
	
	LocalDateTime fechaYHora;
	String patente;
	Inspector inspector;
	ZonaDeEstacionamiento zonaDeEstacionamiento;
	
	public Infraccion(LocalDateTime fechaYHora, ZonaDeEstacionamiento zonaDeEstacionamiento, Inspector inspector, String patente) {
		this.fechaYHora = fechaYHora;
		this.zonaDeEstacionamiento = zonaDeEstacionamiento;
		this.inspector = inspector;
		this.patente = patente;
	}
	
	public LocalDateTime getFechaYHora() {
		return this.fechaYHora;
	}
	
	public ZonaDeEstacionamiento getZonaDeEstacionamiento() {
		return this.zonaDeEstacionamiento;
	}
	
	public Inspector getInspector() {
		return this.inspector;
	}

}
