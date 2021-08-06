package vista;


import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuTemplate{
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv;
	private ExportadorTxt exportadorTxt;
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	private Utilidad utilidad = new Utilidad();
	
	@Override
	public void listarClientes() {
			clienteServicio.listarClientes();
	}
	@Override
	public void agregarCliente() {//Agrega un cliente si es que ya no existe uno registrado con su rut
		utilidad.limpiarPantalla();
		String run, nombre, apellido, anios;
		
		System.out.println("------------Crear Cliente------------");
		do {
			System.out.println("Ingresa RUN del cliente:");
			run = scan.nextLine();
			if(clienteServicio.existeCliente(run)!=null) {
				System.out.println("No se puede agregar un cliente nuevo con un rut ya registrado");
			}
		} while (clienteServicio.getListaClientes().contains(clienteServicio.existeCliente(run)) || run.equals(""));
		
		System.out.println("Ingresa Nombre del cliente:");
		nombre = scan.nextLine();
		System.out.println("Inresa Apellido del Cliente");
		apellido = scan.nextLine();
		System.out.println("Ingresa años como Cliente");
		anios = scan.nextLine();
		clienteServicio.agregarCliente(run, nombre, apellido, anios);
		
	}
	@Override
	public void editarCliente() {
		int opcion;
		String run;
		System.out.println("------------Editar Cliente------------");
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("");
		System.out.println("Ingrese opción:");
		opcion = Integer.parseInt(scan.nextLine());
		switch (opcion) {
		case 1:
			System.out.println("Ingrese RUN del Cliente a editar: ");
			run = scan.nextLine();
			System.out.println("--------Actualizando estado del Cliente--------");
			Cliente cliente = clienteServicio.existeCliente(run);
			if(cliente!=null) {
				System.out.println("El estado actual es: "+ cliente.getNombreCategoria());
				int seleccion;
				do {		
					if(cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.-Si desea mantener el estado del Cliente en Activo");
					} else if(cliente.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
						System.out.println("1.-Si desea mantener el estado del Cliente en Inactivo");
						System.out.println("2.-Si desea cambiar el estado del Cliente a Activo");
					}
					seleccion = Integer.parseInt(scan.nextLine());
					if(seleccion==1 || seleccion ==2) {
						clienteServicio.editarCliente(seleccion,cliente);
					} 
				} while(seleccion!=1 && seleccion!=2);
			} else {
				System.out.println("El rut ingresado no se encuentra registrado");
			}
			break;
		case 2:
			System.out.println("Ingrese RUN del Cliente a editar: ");
			run = scan.nextLine();
			Cliente cliente2 = clienteServicio.existeCliente(run);
			if(cliente2!=null) {
				int opc1;
				System.out.println("----Actualizando datos del Cliente-----\n");
				System.out.println("1.-El RUN del Cliente es: " + cliente2.getRunCliente());
				System.out.println("2.-El Nombre del Cliente es: " + cliente2.getNombreCliente());
				System.out.println("3.-El Apellido del Cliente es: " + cliente2.getApellidoCliente());
				System.out.println("4.-Los años como Cliente son: " + cliente2.getAniosCliente());
				System.out.println("\nIngrese opcion a editar de los datos del cliente:");
				opc1 = Integer.parseInt(scan.nextLine());
				String nuevoRun="", nuevoNombre="", nuevoApellido="",nuevoAnio="";
				System.out.println("-----------------------------");
				switch (opc1) {
				
				case 1:
					System.out.println("1.-Ingrese nuevo RUN del Cliente:");
					nuevoRun = scan.nextLine();
					break;
				case 2:
					System.out.println("1.-Ingrese nuevo Nombre del Cliente:");
					nuevoNombre = scan.nextLine();
					break;
				case 3:
					System.out.println("1.-Ingrese nuevo Apellido del Cliente:");
					nuevoApellido = scan.nextLine();
					break;
				case 4:
					System.out.println("1.-Ingrese nuevo Tiempo como Cliente:");
					nuevoAnio = scan.nextLine();
					break;
				default:
					System.out.println("Ingrese una opción válida");
					break;
				}
				System.out.println("-----------------------------\n");
				clienteServicio.editarCliente(opc1,cliente2, nuevoRun, nuevoNombre, nuevoApellido, nuevoAnio);
			} else {
				System.out.println("El rut ingresado no se encuentra registrado");
			}
			
			break;
		default:
			System.out.println("Ingrese una opción válida");
			break;
		}
		
	}
	@Override
	public void importarDatos() {
		String ruta;
		System.out.println("------------Cargar Datos------------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		ruta = scan.nextLine();
		fileName1 = ruta+"/"+fileName1;
		List<Cliente> listaArchivo = archivoServicio.cargarDatos(fileName1);
		List<Cliente> listaConClientes = clienteServicio.getListaClientes();
		if(listaConClientes.isEmpty()) {
			clienteServicio.setListaClientes(listaArchivo);
		} else if(!listaConClientes.isEmpty()) {
			listaConClientes.addAll(listaArchivo);
		}
		fileName1 = "DBClientes.csv";
		if(!listaArchivo.isEmpty()) {
			System.out.println("Datos cargados correctamente en la lista");
		}

		
	}
	@Override
	public void exportarDatos() {
		String opcion,ruta;
		boolean seleccion = true;
		do {
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Seleccione el formato a exportar:");
			System.out.println("1.-Formato csv");
			System.out.println("2.-Formato txt");
			System.out.println("Ingrese una opción para exportar:");
			opcion = scan.nextLine();
			seleccion = (opcion.equals("1")) || (opcion.equals("2"));
		}while(opcion.equals("") || seleccion==false);
		
		do {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			ruta = scan.nextLine();
			fileName = ruta+fileName;
			if(opcion.equals("1") && !ruta.equals("")) {
				exportadorCsv = new ExportadorCsv();
				exportadorCsv.exportar(fileName, clienteServicio.getListaClientes());
			} else if(opcion.equals("2") && !ruta.equals("")) {
				exportadorTxt = new ExportadorTxt();
				exportadorTxt.exportar(fileName, clienteServicio.getListaClientes());
				
			} 
			fileName = "Clientes";
		}while(ruta.equals(""));
		
		
	}
	@Override
	public void terminarPrograma() {
		System.out.println("Saliendo del programa...");
		scan.close();
		utilidad.cargando();
		utilidad.limpiarPantalla();
		return;
	}

}
