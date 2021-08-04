package test;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import modelo.Cliente;
import servicio.ClienteServicio;




public class ClienteServicioTest {

	ClienteServicio clienteServicio = new ClienteServicio();
	
	private static Logger logger = Logger.getLogger("test.ClienteServicioTest");
	
	@Test
	public void agregarClienteTest() {//Prueba que verifica que el cliente agregado tenga los valores correctos y exista
		String run,nombre,apellido,anios;
		run = "19.773.278-4";
		nombre = "Benjamin";
		apellido = "Herrera";
		anios = "1 año";
		
		logger.info("Prueba unitaria agregando un cliente");
		clienteServicio.agregarCliente(run, nombre, apellido, anios);
		Cliente clienteAgregado = clienteServicio.existeCliente(run);
		
		assertEquals("19.773.278-4",clienteAgregado.getRunCliente());
		assertEquals("Benjamin",clienteAgregado.getNombreCliente());
		assertEquals("Herrera",clienteAgregado.getApellidoCliente());
		assertEquals("1 año",clienteAgregado.getAniosCliente());		
		
	}

	@Test
	public void agregarClienteNullTest() {//Prueba que verifica que el objeto creado no sea nulo
		String run,nombre,apellido,anios;

		run = null;
		nombre = null;
		apellido = null;
		anios = null;
		
		logger.info("Prueba unitaria agregando un cliente con campos nulos");
		Cliente clienteAgregado = new Cliente(run, nombre, apellido, anios);

		assertNotNull(clienteAgregado);
		
	}


}
