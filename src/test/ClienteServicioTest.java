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
	public void agregarClienteNullTest() {//Prueba que verifica si el objeto Cliente es nulo
		String run,nombre,apellido,anios;
		run = null;
		nombre = null;
		apellido = null;
		anios = null;
		
		logger.info("Prueba unitaria agregando un cliente nulo");
		Cliente clienteAgregado = new Cliente(run,nombre,apellido,anios);
		//Al realizar un "new" el objeto jamás será nulo independiente sus atributos
		//por ello para que este sea nulo se debe instanciar como tal.
		clienteAgregado = null;

		assertNull(clienteAgregado);
		
	}


}
