package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		File archivo = new File(fileName+".csv");
		
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("se ha creado el archivo csv");
				escribir(archivo, listaClientes);
			} catch (IOException e) {
				System.out.println(e);
			}
		} else if(archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("Sobreescribiendo archivo csv existente...");
				escribir(archivo, listaClientes);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
	
	private void escribir(File archivo, List<Cliente> listaClientes) {
		try {
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if(!listaClientes.isEmpty()) {
				for (Cliente cliente : listaClientes) {
					bw.write(cliente.getRunCliente()+",");
					bw.write(cliente.getNombreCliente()+",");
					bw.write(cliente.getApellidoCliente()+",");
					bw.write(cliente.getAniosCliente()+",");
					bw.write(cliente.getNombreCategoria()+"\n");
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
