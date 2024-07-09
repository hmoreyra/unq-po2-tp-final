package ar.edu.unq.poo2.tpfinal.RegistroDeCompra;

import java.time.LocalDateTime;

import ar.edu.unq.poo2.tpfinal.PuntoDeVenta.*;

public class RegistroDeCompraPuntual extends RegistroDeCompra{
	
	int cantidadDeHorasCompradas;
	
	public RegistroDeCompraPuntual(int numeroDeControl,int cantidadDeHoras, LocalDateTime fechaYHora, PuntoDeVenta puntoDeVenta) {
		this.numeroDeControl = numeroDeControl;
		this.cantidadDeHorasCompradas = cantidadDeHoras;
		this.fechaYHora = fechaYHora;
		this.puntoDeVenta = puntoDeVenta;
	}
	
	public int getCantidadDeHorasCompradas() {
		return this.cantidadDeHorasCompradas;
	}
	
}