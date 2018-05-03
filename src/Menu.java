import static utilidadesGenerico.Teclado.*;
public class Menu {

	public Partida configurarPartida() {
		int opcion;
		boolean opcion2;
		Partida partida = null;
		System.out.println("Elige entre los 3 niveles de dificultad: Facil, Normal y Dificil.");
		System.out.println("Pulse 1 para la dificultad Facil.\nPulse 2 para la dificultad Normal.\nPulse 3 para la dificultad Dificil.");
		opcion=leerEntre(1,3, Incluido.TODOS, Tipos.INT);
		
		switch (opcion) {
			case 1:
				Humano humanoF = new Humano(Dificultad.FACILHUMANO);
				Maquina maquinaF = new Maquina(Dificultad.FACILMAQUINA);
				opcion2=leerBoolean("¿Que tipo de jugador quieres ser?","Ser humano","Ser maquina");
				if(opcion2) {
					partida = new Partida(humanoF, maquinaF, Dificultad.FACILHUMANO);
				}else {
					partida = new Partida(maquinaF, humanoF, Dificultad.FACILMAQUINA);
				}
				break;
			case 2:
				Humano humanoN = new Humano(Dificultad.NORMAL);
				Maquina maquinaN = new Maquina(Dificultad.NORMAL);
				partida = new Partida(humanoN, maquinaN, Dificultad.NORMAL);
				break;
			case 3:
				Maquina maquinaD1 = new Maquina(Dificultad.DIFICIL);
				Maquina maquinaD2 = new Maquina(Dificultad.DIFICIL);
				partida = new Partida(maquinaD1, maquinaD2, Dificultad.DIFICIL);
				break;
		}
		
		return partida;
	}
	
}
