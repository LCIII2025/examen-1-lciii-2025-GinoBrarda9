package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
            Estacionamiento estacionamiento = new Estacionamiento();
            Vehiculo vehiculo = new Vehiculo("AD709SD", "fiat",Vehiculo.Tipo.AUTO);
            boolean ingreso = estacionamiento.ingresarVehiculo("43695222", "Brarda Gino", vehiculo);
            assertTrue("debe ingresar el vehiculo en formato valido", ingreso);

            Ticket ticket = estacionamiento.retirarVehiculo("AD709SD");
            assertNotNull("No puede ser null el ticket", ticket);
            assertNotNull("debe tener hora de salida marcada", ticket.getHoraSalida());

            assertEquals(0, estacionamiento.listarVehiculosEstacionados().size());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Cliente cliente = new Cliente("43695222","Brarda Gino");
        Vehiculo vehiculo = new Vehiculo("AD799SD", "toyota",Vehiculo.Tipo.SUV);
        LocalDateTime horaEntrada = LocalDateTime.of(2025,5,22,10,0);
        LocalDateTime horaSalida = LocalDateTime.of(2025,5,22,12,30);
        Ticket ticket = new Ticket(cliente,vehiculo,horaEntrada,horaSalida);
        double precio = ticket.calcularPrecio();
        assertEquals(390.0, precio);
    }

}