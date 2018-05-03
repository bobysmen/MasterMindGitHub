import java.util.ArrayList;
import java.util.Random;

public class Maquina extends Jugador {

	Maquina(Dificultad dificultad){
		super(dificultad);
	}

	@Override
	public Combinacion addCombinacion() {
		int posicionFicha=0, opcion=0;
		String color="";
		Combinacion c = new Combinacion(dificultad.getCasillas());
		ArrayList<Integer> repeticion = new ArrayList<Integer>();
		Random rnd = new Random();
		boolean flag=false;
		
		for(posicionFicha=0;posicionFicha<dificultad.getCasillas();posicionFicha++) {
			//Evitar repeticion
			do {
				opcion = rnd.nextInt((dificultad.getNumColores() - 1) + 1) + 1;
				flag=false;
					if (!repeticion.contains(opcion)) {
						repeticion.add(opcion);
					} else {
						flag = true;
					}
			} while (flag);
			
			switch (opcion) {
			case 1:
				color = Colores.ROJO;
				break;
			case 2:
				color = Colores.VERDE;
				break;
			case 3:
				color = Colores.AMARILLO;
				break;
			case 4:
				color = Colores.AZUL;
				break;
			case 5:
				color = Colores.MORADO;
				break;
			case 6:
				color = Colores.CELESTE;
				break;
			case 7:
				color = Colores.BLANCO;
				break;
			case 8:
				color = Colores.NEGRO;
				break;
			}
			c.addFicha(color, posicionFicha);
		}
		return c;
	}


	/*public Jugada addJugada() {
		return new Jugada(addCombinacion());
	}*/

	@Override
	public Combinacion addCombinacionOculta() {
		Combinacion co;
		co=addCombinacion();
		return co;
	}
	
	public Combinacion addRespuesta(Combinacion combinacionOtroJugador) {
		Combinacion respuesta = new Combinacion(dificultad.getCasillas());
		respuesta=algoritmoRespuesta(combinacionOtroJugador);
		return respuesta;
	}
	
	
}
