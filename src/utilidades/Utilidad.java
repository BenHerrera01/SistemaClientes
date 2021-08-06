package utilidades;

import modelo.CategoriaEnum;

public class Utilidad {
	
	public void limpiarPantalla() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("");
	}
	
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
	 * Método que transforma la primera letra de una palabra en mayúscula
	 * y el resto en minúscula.
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
