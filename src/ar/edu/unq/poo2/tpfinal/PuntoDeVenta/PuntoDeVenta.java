package ar.edu.unq.poo2.tpfinal.PuntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.Sem.SEM;
import ar.edu.unq.poo2.tpfinal.ZonaDeEstacionamiento.*;
import ar.edu.unq.poo2.tpfinal.RegistroDeCompra.*;
import ar.edu.unq.poo2.tpfinal.RegistroDeEstacionamiento.*;

public class PuntoDeVenta {
	
	private SEM sem ;
	public String nombre;
	
	public PuntoDeVenta (SEM sem, String nombre) {
		this.sem = sem;
		this.nombre = nombre;
	}
	
	private int generarNumeroDeRegistro() {
	//Se utiliza para generar un numero de registro de cinco cifras de forma aleatoria
        double numeroDeRegistroNuevo = Math.random()*10000;
		
		numeroDeRegistroNuevo = Math.toIntExact(Math.round(numeroDeRegistroNuevo));
		
		return (int) numeroDeRegistroNuevo;

	}
	
	public void cargarCreditoSEM(double monto, int numeroDeCelular) {
		this.sem.cargarCredito(monto, numeroDeCelular);
		
				
		RegistroDeRecarga registro = new RegistroDeRecarga(this.generarNumeroDeRegistro(),monto,numeroDeCelular,LocalDateTime.now(),this);
		
		this.sem.registrarCompra(registro);
	}
	
	
	public void registrarVehiculo(RegistroDeEstacionamientoPuntual registro) {
						
		this.sem.registrarEstacionamientoPuntual(registro)
	
		RegistroDeCompraPuntual registroCompra = new RegistroDeCompraPuntual(this.generarNumeroDeRegistro(),registro.horasEstacionamiento,registro.fechaYHoraDeInicio,this);
		
		this.sem.registrarCompra(registroCompra)
		
	}
	
	
	

}
