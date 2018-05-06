
public enum Dificultad {

	FACILHUMANO(4,8,10), FACILMAQUINA(4,8,10), NORMAL(5,8,15), DIFICIL(8,10,-1);
	private int casillas;
	private int numColores;
	private int numIntentos;
	
	Dificultad(int casillas, int numColores, int numIntentos){
		this.casillas=casillas;
		this.numColores=numColores;
		this.numIntentos=numIntentos;
	}

	public int getCasillas() {
		return casillas;
	}

	public int getNumColores() {
		return numColores;
	}

	public int getNumIntentos() {
		return numIntentos;
	}
	
	
}
