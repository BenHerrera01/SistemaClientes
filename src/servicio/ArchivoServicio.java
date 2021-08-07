package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;


public class ArchivoServicio extends Exportador {
	

	public List<Cliente> cargarDatos(String fileName) {
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		File archivo = new File(fileName);
		String ruta = archivo.getAbsolutePath();
		if(archivo.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
				String contenido = "";
				
				while ((contenido = br.readLine()) != null){   
					String[] arrayClientes = contenido.split(",");
					String run = arrayClientes[0];
					String nombre = arrayClientes[1];
					String apellido = arrayClientes[2];
					String anios = arrayClientes[3];
					String estado = arrayClientes[4];

					CategoriaEnum categoria = CategoriaEnum.valueOf(estado.toUpperCase());
					listaClientes.add(new Cliente(run,nombre,apellido,anios,categoria));

				}
				System.out.println("Archivo importado desde: " + ruta);
			} catch (Exception e){
				
			}
		} else if(!archivo.exists()) {
			System.out.println("El archivo no existe en la ruta " + ruta);
		}
		
		return listaClientes;
	}
	
	
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		/*
		 * 
		 * Método sobreescrito
		 * 
		 */
	}

	

}
