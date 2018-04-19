import static utilidadesGenerico.Teclado.*;

import utilidadesGenerico.Teclado.Tipos;

public class Humano extends Jugador {

	private Tablero tablero;
	private Dificultad dificultad;
	
	Humano(Dificultad dificultad){
		super(dificultad);
	}

	public Combinacion addCombinacion() {
		int opcion;
		int posicionFicha;	//Posicion en la que se introduce el color
		
		Combinacion c = new Combinacion(dificultad.getCasillas());
		
		System.out.println("Introduzca un numero correspondiente al color segun la siguiente tabla.");
		System.out.printf("1-Color Rojo %s\n", Colores.ROJO);
		System.out.printf("2-Color Verde %s\n", Colores.VERDE);
		System.out.printf("3-Color Amarillo %s\n", Colores.AMARILLO);
		System.out.printf("4-Color Azul %s\n", Colores.AZUL);
		System.out.printf("5-Color Morado %s\n", Colores.MORADO);
		System.out.printf("6-Colores Celeste %s\n", Colores.CELESTE);
		System.out.printf("7-Colores Blanco %s\n", Colores.BLANCO);
		System.out.printf("8-Colores Negro %s\n", Colores.NEGRO);
		opcion=leerNumero(Tipos.INT);
		
		switch(opcion) {
		
		}
		
		return c;
	}
	
	//Este metodo añade la combinacion a jugada
	public Jugada addJugada() {
		return new Jugada(addCombinacion());
	}

	public Combinacion addCombinacionOculta() {
		return null;
	}
	
	

}
