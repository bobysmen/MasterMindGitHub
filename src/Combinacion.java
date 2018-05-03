
public class Combinacion implements Dibujable {

	private Ficha combinacionFicha[];
	
	Combinacion(int numFicha){
		combinacionFicha = new Ficha[numFicha];
	}
	
	public void addFicha(String color, int posicion) {
		Ficha ficha = new Ficha(color);
		
		combinacionFicha[posicion]=ficha;
	}
	
	
	
	public Ficha[] getCombinacionFicha() {
		return combinacionFicha;
	}

	public void dibujar() {
		for (int i = 0; i < combinacionFicha.length; i++) {
			combinacionFicha[i].dibujar();
		}
	}
	
}
