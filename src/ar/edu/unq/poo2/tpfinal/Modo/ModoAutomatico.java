package ar.edu.unq.poo2.tpfinal.Modo;

import java.time.LocalDateTime;
import java.util.Optional;

import ar.edu.unq.poo2.tpfinal.AppSem.GPS;
import ar.edu.unq.poo2.tpfinal.AppSem.IPantalla;
import ar.edu.unq.poo2.tpfinal.Notificacion.AlertaDeFin;
import ar.edu.unq.poo2.tpfinal.Notificacion.AlertaDeInicio;
import ar.edu.unq.poo2.tpfinal.Notificacion.Notificacion;
import ar.edu.unq.poo2.tpfinal.Notificacion.NotificacionMensajePersonalizado;
import ar.edu.unq.poo2.tpfinal.Registro.RegistroDeEstacionamiento.RegistroDeEstacionamiento;
import ar.edu.unq.poo2.tpfinal.Registro.RegistroDeEstacionamiento.RegistroDeEstacionamientoApp;
import ar.edu.unq.poo2.tpfinal.Sem.SEM;
import ar.edu.unq.poo2.tpfinal.ZonaDeEstacionamiento.ZonaDeEstacionamiento;

public class ModoAutomatico implements Modo {
	
	@Override
	public Notificacion registrarVehiculo(String patente, ZonaDeEstacionamiento zona, SEM sem, int numCel, IPantalla pantalla) {
		RegistroDeEstacionamientoApp miEstacionamiento = new RegistroDeEstacionamientoApp(patente, numCel, LocalDateTime.now(), zona);
		return sem.registrarEstacionamiento(miEstacionamiento);
	}

	@Override
	public Notificacion finalizarEstacionamientoPara(String patente, SEM sem) {
		return sem.finalizarEstacionamiento(patente);
	}

	@Override
	public Notificacion driving(boolean estaManejando, GPS unGps, String patente, SEM sem) {
		Notificacion notificacion = new NotificacionMensajePersonalizado("");
		if (!estaManejando) {
			ZonaDeEstacionamiento zonaActual = unGps.getZonaActual();
			Optional<RegistroDeEstacionamiento> opcionalEstacionamiento 
				= sem.getRegistrosDeEstacionamiento().stream().filter(e -> e.getPatente() == patente).findFirst();
			
			if(opcionalEstacionamiento.isPresent() 
			  && zonaActual == opcionalEstacionamiento.get().getZonaDeEstacionamiento()
			  && opcionalEstacionamiento.get().getVigencia()) {
				this.finalizarEstacionamientoPara(patente, sem);
				notificacion = new NotificacionMensajePersonalizado("Se ha realizado el fin del estacionamiento de forma automática.");
			}
		
		}
		return notificacion;
	}

	@Override
	public Notificacion walking(boolean estaManejando, String patente, SEM sem) {
		Notificacion notificacion = new NotificacionMensajePersonalizado("");
		if (estaManejando) {
			Optional<RegistroDeEstacionamiento> opcionalEstacionamiento 
				= sem.getRegistrosDeEstacionamiento().stream().filter(e -> e.getPatente() == patente).findFirst();
			if(opcionalEstacionamiento.isPresent() 
			   && !opcionalEstacionamiento.get().getVigencia()) {
					this.registrarVehiculo(patente, null, sem, 0, null); // arreglar
					notificacion = new NotificacionMensajePersonalizado("Se ha realizado el inicio del estacionamiento de forma automática.");
			}
		}
		return notificacion;
	} // hacer template method de esto, mucho código repetido, se puede pasar a Modo.
}
