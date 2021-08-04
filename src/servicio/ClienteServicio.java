package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	private List<Cliente> listaClientes;

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
				System.out.println("Categoría del Cliente: " + p.getNombreCategoria());
				System.out.println("\n-----------------------------------------");
			});
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

	public Cliente existeCliente(String run) {//Método que verifica la existencia de un cliente, retorna el cliente
		Cliente cliente = listaClientes.stream().filter(r -> r.getRunCliente().equals(run)).findAny().orElse(null);
		if (cliente == null) {
			return null;
		} else {
			return cliente;
		}

	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
