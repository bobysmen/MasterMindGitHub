import java.util.LinkedList;

public class Tablero implements Dibujable {

	private LinkedList <Jugada> jugadas = new LinkedList <Jugada>();
	private Combinacion combinacionOculta;
	private Dificultad dificultad;
	
	Tablero(Dificultad dificultad){
		this.dificultad=dificultad;
	}
	
	
	
	public LinkedList<Jugada> getJugadas() {
		return jugadas;
	}



	public void addColectionJugada(Jugada jugada) {
		jugadas.addLast(jugada);
	}

	public void setCombinacionOculta(Combinacion combinacionOculta) {
		this.combinacionOculta = combinacionOculta;
	}
	


	public Combinacion getCombinacionOculta() {
		return combinacionOculta;
	}


	public void dibujar() {
		int i;
		System.out.println("\n-------------------------------------------");
		for(i=0;i<jugadas.size();i++) {
			System.out.printf("Jugada %d ", i+1);
			jugadas.get(i).dibujar();
			System.out.println();
		}
		System.out.println();
	}
	
}
