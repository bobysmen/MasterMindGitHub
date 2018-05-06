import java.util.HashMap;

public abstract class Jugador {

	protected Tablero tablero;
	protected Jugada jugada;
	protected Dificultad dificultad;
	
	Jugador(Dificultad dificultad){
		this.dificultad=dificultad;
		tablero = new Tablero(dificultad);
		
	}
	
	
	
	public Tablero getTablero() {
		return tablero;
	}



	public abstract Combinacion addCombinacion();
	
	
	public abstract Combinacion addCombinacionOculta();
	
	public abstract Combinacion addRespuesta(Combinacion combinacionOtroJugador);
	
	
	
	public Jugada getJugada(Combinacion combinacionJugada, Combinacion respuesta) {
		jugada = new Jugada();
		jugada.setCombinacionJugada(combinacionJugada);
		jugada.setRespuesta(respuesta);
		return jugada;
	}
	
	public boolean hasGanado(Combinacion respuesta) {
		boolean ganado=true;
		int rojo=0;
		for(int i=0;i<respuesta.getCombinacionFicha().length;i++) {
			if(respuesta.getCombinacionFicha()[i].getColor().equals(Colores.ROJO)) {
				rojo++;
			}
		}
		if(rojo!=dificultad.getCasillas()) {
			ganado=false;
		}
		return ganado;
	}


	//Esto es comun en maquina y humano
	public Combinacion algoritmoRespuesta(Combinacion combinacionOtroJugador) {
		Ficha combinacionOculta[];
		Ficha combinacionComparar[];
		HashMap<Integer,Ficha>mapaOculta = new HashMap<Integer,Ficha>();
		HashMap<Integer,Ficha>mapaComparar = new HashMap<Integer,Ficha>();
		//Incrementa segun si es roja[0], blanca[1] o negra [2]
		int contador[] = new int[3];
		Combinacion respuesta = new Combinacion(dificultad.getCasillas());
		boolean salir=false;
		int i,j;
		
		combinacionOculta=tablero.getCombinacionOculta().getCombinacionFicha();
		combinacionComparar=combinacionOtroJugador.getCombinacionFicha();
		//Relleno los mapas
		for(i=0;i<combinacionOculta.length;i++) {
			mapaOculta.put(i, combinacionOculta[i]);
		}
		for(i=0;i<combinacionComparar.length;i++) {
			mapaComparar.put(i, combinacionComparar[i]);
		}
		//Miro los mapas y busco las Rojas
		for(i=0;i<dificultad.getCasillas();i++) {
			if(mapaOculta.get(i).equals(mapaComparar.get(i))) {
				contador[0]++;
				mapaOculta.remove(i);
				mapaComparar.remove(i);
			}
		}
		//Miro los mapas y busco las Blancas
		for(i=0;i<dificultad.getCasillas();i++) {
			for(j=0;j<dificultad.getCasillas() && !salir;j++) {
				if(mapaOculta.containsKey(i) && mapaComparar.containsKey(j)) {
					if(mapaOculta.get(i).equals(mapaComparar.get(j))) {
						contador[1]++;
						mapaComparar.remove(j);
						salir=true;
					}
				}
			}
			mapaOculta.remove(i);
			salir=false;
		}
		
		//Las negras las saco por eliminacion
		contador[2]=dificultad.getCasillas()-(contador[0]+contador[1]);
		
		//Combinacion segun contador por color
		for(i=0;i<contador[0];i++) {
			respuesta.addFicha(Colores.ROJO, i);
		}
		for(i=contador[0];i<contador[0]+contador[1];i++) {
			respuesta.addFicha(Colores.BLANCO, i);
		}
		for(i=contador[0]+contador[1];i<dificultad.getCasillas();i++) {
			respuesta.addFicha(Colores.NEGRO, i);
		}
		
		return respuesta;
	}
	
}
