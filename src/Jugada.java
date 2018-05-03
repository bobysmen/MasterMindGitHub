
public class Jugada implements Dibujable {

	private Combinacion combinacionJugada;
	private Combinacion respuesta;
	
	

	public void setCombinacionJugada(Combinacion combinacionJugada) {
		this.combinacionJugada = combinacionJugada;
	}

	public void setRespuesta(Combinacion respuesta) {
		this.respuesta = respuesta;
	}
	
	public void dibujar() {
		combinacionJugada.dibujar();
		System.out.print("|| ");
		respuesta.dibujar();
	}
	
	
}
