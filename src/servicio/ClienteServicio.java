package servicio;

import java.util.ArrayList;
import java.util.List;


import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {
	private List<Cliente> listaClientes;
	private Utilidad utilidad = new Utilidad();

	public ClienteServicio() {
		this.listaClientes = new ArrayList<Cliente>();
	}

	public void listarClientes() {
		if(!listaClientes.isEmpty()) {
			listaClientes.stream().forEach(p -> {
				System.out.println("------------Datos del Cliente------------\n");
				System.out.println("RUN del cliente: " + p.getRunCliente());
				System.out.println("Nombre del Cliente: " + p.getNombreCliente());
				System.out.println("Apellido del Cliente: " + p.getApellidoCliente());
				System.out.println("Años como Cliente: " + p.getAniosCliente());
				System.out.println("Categoría del Cliente: " + utilidad.primeraLetraMayuscula(p.getNombreCategoria()));
				System.out.println("\n-----------------------------------------");
			});
			estadisticas();
			System.out.println("");
		} else {
			System.out.println("La lista de clientes está vacía");
		}
		
		
	}

	public void agregarCliente(String run, String nombre, String apellido, String anios) {
		Cliente cliente = new Cliente(run, nombre, apellido, anios);
		listaClientes.add(cliente);
	}

	public void editarCliente(int opcion, Cliente cliente, String nuevoRun, String nombre, String apellido,
			String anios) {//Método que edita los atributos del cliente de acuerdo a la opción ingresada por el usuario
		switch (opcion) {
		case 1:
			cliente.setRunCliente(nuevoRun);
			break;
		case 2:
			cliente.setNombreCliente(nombre);
			break;
		case 3:
			cliente.setApellidoCliente(apellido);
			break;
		case 4:
			cliente.setAniosCliente(anios);
			break;
		default:
			break;
		}
	}

	public void editarCliente(int seleccion, Cliente cliente) {// Método que edita el estado del cliente
		if (seleccion == 1) {
			cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
		} else if (seleccion == 2) {
			cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
		}
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	/*
	 * 
	 * Método que verifica si existe un cliente en la lista con un rut específico,
	 * Retorna el cliente encontrado o null si es que no existe.
	 * 
	 */
	
	public Cliente existeCliente(String run) {
		Cliente cliente = listaClientes.stream().filter(r -> r.getRunCliente().equals(run)).findAny().orElse(null);
		return cliente;
	}

	
	
	/*
	 * 
	 * Método que obtiene una lista de clientes y remueve aquellos que ya se encuentren registrados
	 * en la lista principal [listaClientes].
	 * 
	 * Retorna lista modificada
	 * 
	 */
	
	
	public List<Cliente> eliminarRepetidos(List<Cliente> listaArchivo){
		List<Cliente> listaActualizada = new ArrayList<Cliente>(listaArchivo);
		
		listaArchivo.stream().forEach(cli -> {
			for (Cliente cliente : listaClientes) {
				if(cliente.getRunCliente().equals(cli.getRunCliente())) {
					listaActualizada.remove(cli);
				}
			}
		});
		return listaActualizada;
	}
	
	
	/*
	 * 
	 * Método que imprime la cantidad de clientes registrados, así también aquellos que
	 * se encuentran "Activos" e "Inactivos"
	 * 
	 */
	
	public void estadisticas() {

		int contadorClientes = 0,contadorActivos = 0, contadorInactivos = 0;
		
		for (Cliente cliente : listaClientes) {
			contadorClientes++;
			if(cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
				contadorActivos++;
			} else if(cliente.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
				contadorInactivos ++;
			}
		}
		
		System.out.println("Cantidad de Clientes registrados: " + contadorClientes);
		System.out.println("Cantidad de Clientes activos: " + contadorActivos);
		System.out.println("Cantidad de Clientes inactivos: " + contadorInactivos);
	}
	
	

}
