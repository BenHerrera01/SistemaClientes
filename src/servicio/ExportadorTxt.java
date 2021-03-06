package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;
import utilidades.Utilidad;

public class ExportadorTxt extends Exportador{

	private Utilidad utilidad = new Utilidad();
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		File archivo = new File(fileName+".txt");
		
		if(archivo.exists()) {
			System.out.println("El archivo ya existe, se sobreescribirá");
		} 
		try {
			archivo.createNewFile();
			System.out.println("se ha creado el archivo txt");
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if(!listaClientes.isEmpty()) {
				bw.write("Clientes registrados:\n");
				for (Cliente cliente : listaClientes) {
					bw.write("\n-----------------------------------------\n\n");
					bw.write("RUN del cliente: " + cliente.getRunCliente()+"\n");
					bw.write("Nombre del Cliente: " + cliente.getNombreCliente()+"\n");
					bw.write("Apellido del Cliente: " + cliente.getApellidoCliente()+"\n");
					bw.write("Tiempo como Cliente: " + cliente.getAniosCliente()+"\n");
					bw.write("Categoría del Cliente: " + utilidad.primeraLetraMayuscula(cliente.getNombreCategoria()) +"\n");
				}
				
			}
			String ruta = archivo.getAbsolutePath();
			System.out.println("Archivo guardado en: " + ruta);
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	

}
