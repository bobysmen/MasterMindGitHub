
public abstract class Jugador {

	private Tablero tablero;
	private Dificultad dificultad;
	
	Jugador(Dificultad dificultad){
		this.dificultad=dificultad;
	}
	
	public abstract Combinacion addCombinacion();
	
	public abstract Combinacion addCombinacionOculta();
	
}
