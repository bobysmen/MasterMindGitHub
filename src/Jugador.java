
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
	
	/*public abstract Jugada addJugada();*/
	
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
		if(rojo!=4) {
			ganado=false;
		}
		return ganado;
	}



	//Esto es comun en maquina y humano
	public Combinacion algoritmoRespuesta(Combinacion combinacionOtroJugador) {
		Ficha combinacionOculta[];
		Ficha combinacionComparar[];
		Combinacion respuesta = new Combinacion(dificultad.getCasillas());
		int i,j;
		boolean fichaPuesta=false;
		
		combinacionOculta=tablero.getCombinacionOculta().getCombinacionFicha();
		combinacionComparar=combinacionOtroJugador.getCombinacionFicha();
		//Sin repeticion de colores, si hubiera repeticion tengo que a�adir un contador o boolean en las condiciones dentro del for
		for(i=0;i<combinacionOculta.length;i++) {
			for(j=0;j<combinacionComparar.length;j++) {
				if(i==j && combinacionOculta[i].equals(combinacionComparar[j])) {
					respuesta.addFicha(Colores.ROJO, i);
					fichaPuesta=true;
				}else if(combinacionOculta[i].equals(combinacionComparar[j])) {
					respuesta.addFicha(Colores.BLANCO, i);
					fichaPuesta=true;
				}
			}
			if(!fichaPuesta) {
				respuesta.addFicha(Colores.NEGRO, i);
			}
			fichaPuesta=false;
		}
		
		return respuesta;
	}
	
}
