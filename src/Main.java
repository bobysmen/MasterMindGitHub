import static utilidadesGenerico.Teclado.*;
public class Main {

	public static void main(String[] args) {
		boolean volverJugar;
		Menu menu = new Menu();
		
		do {
			menu.configurarPartida().empezarPartida();
			volverJugar = leerBoolean("\n\n¿Quieres jugar otra partida?", "Si", "No");
		} while (volverJugar);

	}

}
