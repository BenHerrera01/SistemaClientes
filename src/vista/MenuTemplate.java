package vista;

import java.util.Scanner;

public abstract class MenuTemplate {
	
	protected Scanner scan = new Scanner(System.in);
	
	public final void iniciarMenu(){
		String opcion;
		do {
			System.out.println("------------Menú de Clientes------------");
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente ");
			System.out.println("3. Editar Cliente ");
			System.out.println("4. Cargar Datos ");
			System.out.println("5. Exportar Datos ");
			System.out.println("6. Salir ");
			System.out.println("Ingrese una opción: ");
			opcion = scan.nextLine();
			switch (opcion) {
			case "1":
				listarClientes();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente();
				break;
			case "4":
				importarDatos();
				break;
			case "5":
				exportarDatos();
				break;
			case "6":
				terminarPrograma();
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}
		} while(!opcion.equals("6"));
	}
	
	public abstract void listarClientes();
	public abstract void agregarCliente();
	public abstract void editarCliente();
	public abstract void importarDatos();
	public abstract void exportarDatos();
	public abstract void terminarPrograma();
}
