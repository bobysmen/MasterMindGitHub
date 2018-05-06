import static utilidadesGenerico.Teclado.*;

import java.util.ArrayList;


import utilidadesGenerico.Teclado.Tipos;

public class Humano extends Jugador {
	
	Humano(Dificultad dificultad){
		super(dificultad);
	}

	public Combinacion addCombinacion() {
		int opcion;
		int posicionFicha=0;	//Posicion en la que se introduce el color
		String color="";
		
		Combinacion c = new Combinacion(dificultad.getCasillas());
		
		System.out.printf("Introduzca %d numeros correspondiente al color segun la siguiente tabla.\n", dificultad.getCasillas());
		System.out.printf("1-Color Rojo %s\n", Colores.ROJO);
		System.out.printf("2-Color Verde %s\n", Colores.VERDE);
		System.out.printf("3-Color Amarillo %s\n", Colores.AMARILLO);
		System.out.printf("4-Color Azul %s\n", Colores.AZUL);
		System.out.printf("5-Color Morado %s\n", Colores.MORADO);
		System.out.printf("6-Color Celeste %s\n", Colores.CELESTE);
		System.out.printf("7-Color Blanco %s\n", Colores.BLANCO);
		System.out.printf("8-Color Negro %s\n", Colores.NEGRO);
		
		for (posicionFicha = 0; posicionFicha < dificultad.getCasillas(); posicionFicha++) {
			
			opcion = leerEntre(1, dificultad.getNumColores(), Incluido.TODOS, Tipos.INT);
			
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
	
	public Combinacion addRespuesta(Combinacion combinacionOtroJugador) {
		Combinacion respuesta = new Combinacion(dificultad.getCasillas());
		Combinacion respuestaAlgoritmo = new Combinacion(dificultad.getCasillas());
		int opcion, posicionFicha=0,i;
		int rojo=0, blanco=0, negro=0, rojoAlgo=0, blancoAlgo=0, negroAlgo=0;
		String color="";
		boolean respuestasCorrectas=false;
		
		do {
			System.out.println("Introduzca un numero correspondiente al color segun la siguiente tabla.");
			System.out.println("1-Si ha acertado el color y posicion");
			System.out.println("2-Si ha acertado el color");
			System.out.println("3-Si no ha acertado");
			for (posicionFicha = 0; posicionFicha < dificultad.getCasillas(); posicionFicha++) {
				opcion = leerEntre(1, 3, Incluido.TODOS, Tipos.INT);
				switch (opcion) {
				case 1:
					color = Colores.ROJO;
					break;
				case 2:
					color = Colores.BLANCO;
					break;
				case 3:
					color = Colores.NEGRO;
					break;
				}
				respuesta.addFicha(color, posicionFicha);
			}
			//Metodo de Jugador(Padre)
			respuestaAlgoritmo = algoritmoRespuesta(combinacionOtroJugador);
			//Recorro los array de combinacion para ver cuantos Rojos, Blancos y negros tienen.
			for (i = 0; i < respuesta.getCombinacionFicha().length; i++) {
				if (respuesta.getCombinacionFicha()[i].getColor().equals(Colores.ROJO)) {
					rojo++;
				} else if (respuesta.getCombinacionFicha()[i].getColor().equals(Colores.BLANCO)) {
					blanco++;
				} else {
					negro++;
				}
			}
			for (i = 0; i < respuestaAlgoritmo.getCombinacionFicha().length; i++) {
				if (respuestaAlgoritmo.getCombinacionFicha()[i].getColor().equals(Colores.ROJO)) {
					rojoAlgo++;
				} else if (respuestaAlgoritmo.getCombinacionFicha()[i].getColor().equals(Colores.BLANCO)) {
					blancoAlgo++;
				} else {
					negroAlgo++;
				}
			} 
			if(rojo==rojoAlgo && blanco==blancoAlgo && negro==negroAlgo) {
				respuestasCorrectas=true;
			}else {
				System.out.println("Has introducido mal la respuesta. Por favor vuelva a intentarlo");
				//Vuelvo a inicializar a cero
				rojo=0;
				blanco=0;
				negro=0;
				rojoAlgo=0;
				blancoAlgo=0;
				negroAlgo=0;
			}
		} while (!respuestasCorrectas);
		return respuesta;
	}
	

	public Combinacion addCombinacionOculta() {
		Combinacion co;
		Ficha array[];
		ArrayList<Ficha> repeticion = new ArrayList<Ficha>();
		int i;
		boolean flag=false;
		do {
			flag=false;
			co = addCombinacion();
			array = co.getCombinacionFicha();
			for (i = 0; i < dificultad.getCasillas() && flag == false; i++) {
				if (!repeticion.contains(array[i])) {
					repeticion.add(array[i]);
				} else {
					flag = true;
				}
			}
			if(flag) {
				System.out.println("La combinacion oculta tiene algun color repetido. Vuelva a introducirla");
			}
			repeticion.clear();
		} while (flag);
		
		return co;
	}
	
	

}
