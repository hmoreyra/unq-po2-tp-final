package ar.edu.unq.poo2.tpfinal.RegistroDeEstacionamiento;

import java.time.LocalTime;

import ar.edu.unq.poo2.tpfinal.ZonaDeEstacionamiento.*;

public class RegistroDeEstacionamientoPuntual extends RegistroDeEstacionamiento{
	
	public LocalTime horasEstacionamiento;
	
	public LocalTime fechaYHoraDeInicio;
	
	public RegistroDeEstacionamientoPuntual(String patente, LocalTime horasEstacionamiento, LocalTime fechaYHoraDeInicio, ZonaDeEstacionamiento zonaDeEstacionamiento) {
		this.patente = patente;
		this.horasEstacionamiento = horasEstacionamiento;
		this.fechaYHoraDeInicio = fechaYHoraDeInicio;
		this.zonaDeEstacionamiento = zonaDeEstacionamiento;
		this.vigencia = true;
	}
	
	public LocalTime getHorasEstacionamiento() {
		return this.horasEstacionamiento;
	}
	
		

}
