
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
			combinacionOculta=jugador2.addCombinacion();
			jugador2.getTablero().setCombinacionOculta(combinacionOculta);
			do {
				combinacionJugada = jugador1.addCombinacion();
				respuesta = jugador2.addRespuesta(combinacionJugada);
				jugador1.getTablero().setCombinacionOcultaContraria(combinacionOculta);
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
				jugador1.getTablero().setCombinacionOcultaContraria(combinacionOculta);
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
		Combinacion combinacionJugada, respuesta, combinacionOculta;
	}
	
	public void partidaDificil() {
		
	}
	
}
