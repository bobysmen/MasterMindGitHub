import static utilidadesGenerico.Teclado.*;
public class Menu {

	public void configurarPartida() {
		int opcion;
		System.out.println("Elige entre los 3 niveles de dificultad: Facil, Normal y Dificil.");
		System.out.println("Pulse 1 para la dificultad Facil.\nPulse 2 para la dificultad Normal.\nPulse 3 para la dificultad Dificil.");
		opcion=leerEntre(1,3, Incluido.TODOS, Tipos.INT);
	}
	
}
