import java.util.LinkedList;

public class Tablero implements Dibujable {

	private LinkedList <Jugada> jugadas = new LinkedList <Jugada>();
	private Combinacion combinacionOculta;
	private Combinacion combinacionOcultaContraria;
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
	

	public void setCombinacionOcultaContraria(Combinacion combinacionOcultaContraria) {
		this.combinacionOcultaContraria = combinacionOcultaContraria;
	}


	public Combinacion getCombinacionOculta() {
		return combinacionOculta;
	}


	public void dibujar() {
		int i;
		if (dificultad==Dificultad.FACILHUMANO) {
			System.out.print("Combinacion Oculta: ");
			combinacionOcultaContraria.dibujar();
		}
		System.out.println("\n-------------------------------------------");
		for(i=0;i<jugadas.size();i++) {
			System.out.printf("Jugada %d ", i+1);
			jugadas.get(i).dibujar();
			System.out.println();
		}
		System.out.println();
	}
	
}
