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

	/*
	 * 
	 * M�todo que lista los objetos de tipo Cliente que est�n almacenados en la listaClientes 
	 * (si la lista no est� vac�a).
	 * 
	 */
	
	public void listarClientes() {
		if(!listaClientes.isEmpty()) {
			listaClientes.stream().forEach(p -> {
				System.out.println("------------Datos del Cliente------------\n");
				System.out.println("RUN del cliente: " + p.getRunCliente());
				System.out.println("Nombre del Cliente: " + p.getNombreCliente());
				System.out.println("Apellido del Cliente: " + p.getApellidoCliente());
				System.out.println("A�os como Cliente: " + p.getAniosCliente());
				System.out.println("Categor�a del Cliente: " + utilidad.primeraLetraMayuscula(p.getNombreCategoria()));
				System.out.println("\n-----------------------------------------");
			});
			estadisticas();
			System.out.println("");
		} else {
			System.out.println("La lista de clientes est� vac�a");
		}
		
		
	}

	/*
	 * 
	 * M�todo que recibe por par�metro los atributos de un cliente, crea un objeto de 
	 * tipo Cliente a partir de esos atributos y lo agrega a la lista.
	 * 
	 */
	
	public void agregarCliente(String run, String nombre, String apellido, String anios) {
		Cliente cliente = new Cliente(run, nombre, apellido, anios);
		listaClientes.add(cliente);
	}

	/*
	 * 
	 * M�todo que recibe una opci�n que ingres� el usuario, un objeto de tipo Cliente y los atributos.
	 * 
	 * dependiendo de la opci�n, se modifica el atributo del cliente.
	 * 
	 */
	
	public void editarCliente(int opcion, Cliente cliente, String nuevoRun, String nombre, String apellido,
			String anios) {//M�todo que edita los atributos del cliente de acuerdo a la opci�n ingresada por el usuario
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

	/*
	 * 
	 * M�todo que recibe una selecci�n y un objeto de tipo Cliente.
	 * 
	 * Se cambia el estado del cliente (ACTIVO-INACTIVO) dependiendo de la opci�n.
	 * 
	 */
	
	public void editarCliente(int seleccion, Cliente cliente) {// M�todo que edita el estado del cliente
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
	 * M�todo que verifica si existe un cliente en la lista con un rut espec�fico,
	 * Retorna el cliente encontrado o null si es que no existe.
	 * 
	 */
	
	public Cliente existeCliente(String run) {
		Cliente cliente = listaClientes.stream().filter(r -> r.getRunCliente().equals(run)).findAny().orElse(null);
		return cliente;
	}

	
	
	/*
	 * 
	 * M�todo que obtiene una lista de clientes y remueve aquellos que ya se encuentren registrados
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
	 * M�todo que imprime la cantidad de clientes registrados, as� tambi�n aquellos que
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
