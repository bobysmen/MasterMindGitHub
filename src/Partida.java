
public class Partida {

	private Jugador jugador1;
	private Jugador jugador2;
	private Dificultad dificultad;
	
	Partida(Jugador jugador1, Jugador jugador2, Dificultad dificultad){
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		this.dificultad=dificultad;
	}
	
	public void empezarPartida() {
		if(dificultad==Dificultad.FACILHUMANO || dificultad==Dificultad.FACILMAQUINA) {
			partidaFacil();
		}else if(dificultad==Dificultad.NORMAL) {
			partidaNormal();
		}else {
			partidaDificil();
		}
	}
	
	public void partidaFacil() {
		Combinacion combinacionJugada, respuesta, combinacionOculta;
		int numIntento=0;
		if(dificultad==Dificultad.FACILHUMANO) {
			combinacionOculta=jugador2.addCombinacionOculta();
			jugador2.getTablero().setCombinacionOculta(combinacionOculta);
			do {
				combinacionJugada = jugador1.addCombinacion();
				respuesta = jugador2.addRespuesta(combinacionJugada);
				jugador1.getTablero().addColectionJugada(jugador1.getJugada(combinacionJugada, respuesta));
				jugador1.getTablero().dibujar();
				numIntento++;
			} while (!jugador1.hasGanado(respuesta) && numIntento<dificultad.getNumIntentos());
			//Mostrar la combinacion oculta y un mensaje ganador o perdedor.
			if(jugador1.hasGanado(respuesta)) {
				System.out.println("Has ganado. Una Tostadora nunca podra vencer a un humano");
				System.out.print("Combinacion Oculta: ");
				jugador2.getTablero().getCombinacionOculta().dibujar();
			}else {
				System.out.println("Has perdido. Eres la deshonra de la raza humana");
				System.out.print("Combinacion Oculta: ");
				jugador2.getTablero().getCombinacionOculta().dibujar();
			}
		//La maquina es ahora el jugador1 y el humano el jugador2
		}else {
			System.out.println("Introduzca una combinacion oculta que la maquina deba adivinar: ");
			combinacionOculta=jugador2.addCombinacionOculta();
			jugador2.getTablero().setCombinacionOculta(combinacionOculta);
			do {
				combinacionJugada = jugador1.addCombinacion();
				combinacionJugada.dibujar();
				System.out.print(" Combinacion oculta: ");
				combinacionOculta.dibujar();
				System.out.println();
				respuesta = jugador2.addRespuesta(combinacionJugada);
				jugador1.getTablero().addColectionJugada(jugador1.getJugada(combinacionJugada, respuesta));
				jugador1.getTablero().dibujar();
				numIntento++;
			} while (!jugador1.hasGanado(respuesta) && numIntento<dificultad.getNumIntentos());
			if(jugador1.hasGanado(respuesta)) {
				System.out.println("Ha ganado la Maquina. Preparate para el apocalipsis, Skynet esta aqui");
				System.out.print("Combinacion Oculta: ");
				jugador2.getTablero().getCombinacionOculta().dibujar();
			}else {
				System.out.println("Ha ganado el Humano. Prueba a jugar contra una lavadora, quizas sea mas \"inteligente\"");
				System.out.print("Combinacion Oculta: ");
				jugador2.getTablero().getCombinacionOculta().dibujar();
			}
		}
	}
	
	public void partidaNormal() {
		Combinacion combinacionJugada, respuesta, combinacionOcultaJ1, combinacionOcultaJ2;
		int numIntento=0;
		int ganador=-1;	//ganador en caso de empate
		boolean salir=false;
		
		//Combinaciones Oculta de los 2 jugadores
		System.out.println("Introduce la combinacion oculta");
		combinacionOcultaJ1=jugador1.addCombinacionOculta();
		jugador1.getTablero().setCombinacionOculta(combinacionOcultaJ1);
		combinacionOcultaJ2=jugador2.addCombinacionOculta();
		jugador2.getTablero().setCombinacionOculta(combinacionOcultaJ2);
		
		do {
			combinacionJugada = jugador1.addCombinacion();
			respuesta = jugador2.addRespuesta(combinacionJugada);
			jugador1.getTablero().addColectionJugada(jugador1.getJugada(combinacionJugada, respuesta));
			System.out.println("Jugador Humano");
			jugador1.getTablero().dibujar();
			
			if (!jugador1.hasGanado(respuesta)) {
				combinacionJugada = jugador2.addCombinacion();
				System.out.print("Combinacion Maquina: ");
				combinacionJugada.dibujar();
				System.out.print(" Combinacion oculta: ");
				jugador1.getTablero().getCombinacionOculta().dibujar();
				System.out.println();
				respuesta = jugador1.addRespuesta(combinacionJugada);
				jugador2.getTablero().addColectionJugada(jugador2.getJugada(combinacionJugada, respuesta));
				System.out.println("Jugador Maquina");
				jugador2.getTablero().dibujar();
				System.out.println("Jugador Humano");
				jugador1.getTablero().dibujar();
				if(jugador2.hasGanado(respuesta)) {
					salir=true;
				}
			}else {
				salir=true;
			}
			numIntento++;
		} while (!salir && numIntento<dificultad.getNumIntentos());
		//En caso de hacer todos los intentos y que no haya ganado nadie. se comprobara el numero de rojas y blancas que hay colocadas en la ultima respuesta
		if(numIntento==dificultad.getNumIntentos() && !jugador1.hasGanado(respuesta) && !jugador2.hasGanado(respuesta)) {
			
			ganador=contadorRespuesta(jugador1.getTablero().getJugadas().getLast().getRespuesta(), jugador2.getTablero().getJugadas().getLast().getRespuesta());
		}
		if(jugador1.hasGanado(respuesta) || ganador==1) {
			System.out.println("Ha ganado el Humano. Prueba a jugar contra una lavadora, quizas sea mas \"inteligente\"");
			System.out.print("Combinacion Oculta Maquina: ");
			jugador2.getTablero().getCombinacionOculta().dibujar();
		}else if(jugador2.hasGanado(respuesta) || ganador==2) {
			System.out.println("Ha ganado la Maquina. Preparate para el apocalipsis, Skynet esta aqui");
			System.out.print("Combinacion Oculta Humano: ");
			jugador1.getTablero().getCombinacionOculta().dibujar();
		}else if(ganador==0) {
			System.out.println("EMPATE");
			jugador1.getTablero().getJugadas().getLast().dibujar();
			System.out.println();
			jugador2.getTablero().getJugadas().getLast().dibujar();
			System.out.println();
			System.out.print("Combinacion Oculta Humano: ");
			jugador1.getTablero().getCombinacionOculta().dibujar();
			System.out.print("\nCombinacion Oculta Maquina: ");
			jugador2.getTablero().getCombinacionOculta().dibujar();
		}
	}
	
	public void partidaDificil() {
		Combinacion combinacionJugada, respuesta, combinacionOcultaJ1, combinacionOcultaJ2;
		boolean salir=false;
		
		//Combinaciones Oculta de los 2 jugadores
				System.out.println("Empezaremos introduciendo las combinaciones ocultas de las 2 maquinas");
				combinacionOcultaJ1=jugador1.addCombinacionOculta();
				jugador1.getTablero().setCombinacionOculta(combinacionOcultaJ1);
				combinacionOcultaJ2=jugador2.addCombinacionOculta();
				jugador2.getTablero().setCombinacionOculta(combinacionOcultaJ2);
				
				do {
					combinacionJugada = jugador1.addCombinacion();
					respuesta = jugador2.addRespuesta(combinacionJugada);
					jugador1.getTablero().addColectionJugada(jugador1.getJugada(combinacionJugada, respuesta));
					System.out.println("Jugador Maquina1");
					jugador1.getTablero().dibujar();
					try {
						   Thread.sleep(5000); 
						} catch (Exception e) {
						   e.printStackTrace();
						}
					
					if (!jugador1.hasGanado(respuesta)) {
						combinacionJugada = jugador2.addCombinacion();
						respuesta = jugador1.addRespuesta(combinacionJugada);
						jugador2.getTablero().addColectionJugada(jugador2.getJugada(combinacionJugada, respuesta));
						System.out.println("Jugador Maquina2");
						jugador2.getTablero().dibujar();
						try {
							   Thread.sleep(5000); 
							} catch (Exception e) {
							   e.printStackTrace();
							}
						if(jugador2.hasGanado(respuesta)) {
							salir=true;
						}
					}else {
						salir=true;
					}
				} while (!salir);
				if(jugador1.hasGanado(respuesta)) {
					System.out.println("El ganador es la Maquina1");
					System.out.print("La combinacion oculta de la Maquina2: ");
					jugador2.getTablero().getCombinacionOculta().dibujar();
				}else if(jugador2.hasGanado(respuesta)) {
					System.out.println("El gandor es la Maquina2");
					System.out.print("La combinacion oculta de la Maquina1: ");
					jugador1.getTablero().getCombinacionOculta().dibujar();
				}
		
	}
	
	public int contadorRespuesta(Combinacion respuesta1, Combinacion respuesta2) {
		//Devuelve un int para indicar que si devuelve 1, gana jugador1. Si devuelve 2, gana jugador2. Si devuelve 0, empate.
		int respuesta=-1;
		int rojo1=0, blanco1=0, rojo2=0, blanco2=0;
		int i;
		
		for (i = 0; i < respuesta1.getCombinacionFicha().length; i++) {
			if (respuesta1.getCombinacionFicha()[i].getColor().equals(Colores.ROJO)) {
				rojo1++;
			} else if (respuesta1.getCombinacionFicha()[i].getColor().equals(Colores.BLANCO)) {
				blanco1++;
			}
		}
		for (i = 0; i < respuesta2.getCombinacionFicha().length; i++) {
			if (respuesta2.getCombinacionFicha()[i].getColor().equals(Colores.ROJO)) {
				rojo2++;
			} else if (respuesta2.getCombinacionFicha()[i].getColor().equals(Colores.BLANCO)) {
				blanco2++;
			}
		}
		
		if(rojo1<rojo2) {
			respuesta=2;
		}else if(rojo1>rojo2) {
			respuesta=1;
		}else if(rojo1==rojo2) {
			if(blanco1<blanco2) {
				respuesta=2;
			}else if(blanco1>blanco2) {
				respuesta=1;
			}else if(blanco1==blanco2) {
				respuesta=0;
			}
		}
		
		return respuesta;
	}
	
}
