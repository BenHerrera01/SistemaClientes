package utilidades;

import modelo.CategoriaEnum;

public class Utilidad {
	
	/*
	 * 
	 * M?todo que simula una limpieza de pantalla 
	 * mediante la inserci?n de saltos de l?nea
	 * 
	 */
	
	public void limpiarPantalla() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("");
	}
	
	/*
	 * 
	 * M?todo que simula una pantalla de carga, pero al finalizar el programa
	 * 
	 */
	
	public void cargando() {
        for (int i = 0; i < 101; i++) {
            System.out.print("\rCerrando Programa:" + (i) + "%\t");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
	}
	
	/*
	 * M?todo que transforma la primera letra de una palabra en may?scula
	 * y el resto en min?scula.
	 * 
	 * Usado para listar el estado del cliente (Activo o Inactivo)
	 * 
	 */
	
	public String primeraLetraMayuscula(CategoriaEnum nombreCategoria) {
		String palabra = nombreCategoria.name().toLowerCase();
		String estado = palabra.substring(0, 1).toUpperCase()+palabra.substring(1);
		return estado;
	}
	
}
