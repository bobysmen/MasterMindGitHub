import java.util.LinkedHashSet;

public class Tablero {

	private LinkedHashSet <Jugada> jugadas;
	private Combinacion combinacionOculta;
	private Dificultad dificultad;
	
	Tablero(Dificultad dificultad){
		this.dificultad=dificultad;
	}
	
	public void addColectionJugada(Jugada jugada) {
		jugadas.add(jugada);
	}
	
}
