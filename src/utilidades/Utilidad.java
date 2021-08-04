package utilidades;

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
	
}
