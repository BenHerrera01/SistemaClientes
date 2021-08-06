package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;
import utilidades.Utilidad;

public class ExportadorCsv extends Exportador {
	private Utilidad utilidad = new Utilidad();
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		File archivo = new File(fileName+".csv");
		
		if(archivo.exists()) {
			System.out.println("El archivo ya existe, se sobreescribirá");
		} 
		try {
			archivo.createNewFile();
			System.out.println("se ha creado el archivo txt");
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if(!listaClientes.isEmpty()) {			
				for (Cliente cliente : listaClientes) {
					bw.write(cliente.getRunCliente()+",");
					bw.write(cliente.getNombreCliente()+",");
					bw.write(cliente.getApellidoCliente()+",");
					bw.write(cliente.getAniosCliente()+",");
					bw.write(utilidad.primeraLetraMayuscula(cliente.getNombreCategoria())+"\n");
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
