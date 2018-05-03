
public enum Dificultad {

	FACILHUMANO(4,8,false,10), FACILMAQUINA(4,8,false,10), NORMAL(5,8,false,15), DIFICIL(8,10,true,-1);
	private int casillas;
	private int numColores;
	private boolean repeticionColores;
	private int numIntentos;
	
	Dificultad(int casillas, int numColores, boolean repeticionColores, int numIntentos){
		this.casillas=casillas;
		this.numColores=numColores;
		this.repeticionColores=repeticionColores;
		this.numIntentos=numIntentos;
	}

	public int getCasillas() {
		return casillas;
	}

	public int getNumColores() {
		return numColores;
	}

	public boolean isRepeticionColores() {
		return repeticionColores;
	}

	public int getNumIntentos() {
		return numIntentos;
	}
	
	
}
