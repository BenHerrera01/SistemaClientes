package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		File archivo = new File(fileName+".txt");
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("se ha creado el archivo txt");
				escribir(archivo, listaClientes);
			} catch (IOException e) {
				System.out.println(e);
			}
		} else if (archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("Sobreescribiendo archivo txt existente...");
				escribir(archivo, listaClientes);
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		
	}
	
	private void escribir(File archivo, List<Cliente> listaClientes) {
		try {
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if(!listaClientes.isEmpty()) {
				bw.write("Clientes registrados:\n\n");
				for (Cliente cliente : listaClientes) {
					bw.write("RUN del cliente: " + cliente.getRunCliente()+"\n");
					bw.write("Nombre del Cliente: " + cliente.getNombreCliente()+"\n");
					bw.write("Apellido del Cliente: " + cliente.getApellidoCliente()+"\n");
					bw.write("Tiempo como Cliente: " + cliente.getAniosCliente()+"\n");
					bw.write("Categoría del Cliente: " + cliente.getNombreCategoria()+"\n\n");
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
