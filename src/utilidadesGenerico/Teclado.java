package utilidadesGenerico;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Teclado {
	public static enum Comparacion {
		MAYORIGUAL, MENORIGUAL, MAYOR, MENOR
	}
	
	public static enum Incluido {
		TODOS, NINGUNO, MINIMO, MAXIMO
	}
	public static enum Tipos {
		BYTE, SHORT, INT, LONG, FLOAT, DOUBLE
	}
	
//DECLARACIONES-------------------------------------------------------------------------------------------------------------------------------
	public static Scanner teclado=new Scanner (System.in);
	public static final String ERROR_NUM_IMPUT="El número introducido no es correcto. Vuelva a Introducirlo.";
		
//FUNCIÓN CERRAR TECLADO----------------------------------------------------------------------------------------------------------------------
	public static void cerrarTeclado (){
		teclado.close();
	}

//LEER CARACTERES-----------------------------------------------------------------------------------------------------------------
	public static char leerChar (){
		char caracter;
		caracter=teclado.nextLine().charAt(0);
		return caracter;
	}
	
//LEER CADENAS-----------------------------------------------------------------------------------------------------------------	
	public static String leerString (){
		String cadena;
		cadena=teclado.nextLine();
		return cadena;
	}

//LEER BOOLEAN-----------------------------------------------------------------------------------------------------------------
	public static boolean leerBoolean(String pregunta, String opciontrue, String opcionfalse){
		byte res;
		boolean resultado=true;
		do{
			System.out.printf("%s:\n\t1.- %s\n\t2.- %s\n",pregunta,opciontrue,opcionfalse);
			res=leerNumero(Tipos.BYTE);
		}while(res!=1&&res!=2);
		resultado=(res==1)?true:false;
		return resultado;
	}

//LEER NÚMEROS-----------------------------------------------------------------------------------------------------------------		
	@SuppressWarnings("unchecked")
	public static <N> N leerNumero(Tipos tipo){
		N numero=null;
		boolean valorValido=true;
		
		do{
			try {
				switch (tipo) {
				case BYTE:
					numero=(N) Byte.valueOf(teclado.nextByte());
					valorValido=true;
					break;
				case SHORT:
					numero=(N) Short.valueOf(teclado.nextShort());
					valorValido=true;
					break;
				case INT:
					numero=(N) Integer.valueOf(teclado.nextInt());
					valorValido=true;
					break;
				case LONG:
					numero=(N) Long.valueOf(teclado.nextLong());
					valorValido=true;
					break;
				case FLOAT:
					numero=(N) Float.valueOf(teclado.nextFloat());
					valorValido=true;
					break;
				case DOUBLE:
					numero=(N) Double.valueOf(teclado.nextDouble());
					valorValido=true;
					break;
				}
			} catch (InputMismatchException e){
				System.out.println(ERROR_NUM_IMPUT);
				valorValido=false;
			} finally{
				teclado.nextLine(); //Se limpia el buffer.
			}		
		}while(!valorValido);
		return numero;
	}
	

//PEDIR NÚMERO COMPARANDOLO CON OTRO------------------------------------------------------------------------------------------------
	public static <N> N leerComparacion(Comparacion comparacion, Tipos tipo, N comparado){
		N numero=null;
		boolean valorValido=true;
		do{
			try {	
				switch (comparacion) {
				case MAYORIGUAL:
					switch (tipo) {
					case BYTE:
						numero = leerNumero(Tipos.BYTE);
						if (!((byte)numero >= (byte)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case SHORT:
						numero = leerNumero(Tipos.SHORT);
						if (!((short)numero >= (short)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case INT:
						numero = leerNumero(Tipos.INT);
						if (!((int)numero >= (int)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case LONG:
						numero = leerNumero(Tipos.LONG);
						if (!((long)numero >= (long)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case FLOAT:
						numero = leerNumero(Tipos.FLOAT);
						if (!((float)numero >= (float)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case DOUBLE:
						numero = leerNumero(Tipos.DOUBLE);
						if (!((double)numero >= (double)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					}
					break;
				case MENORIGUAL:
					switch (tipo) {
					case BYTE:
						numero = leerNumero(Tipos.BYTE);
						if (!((byte)numero <= (byte)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case SHORT:
						numero = leerNumero(Tipos.SHORT);
						if (!((short)numero <= (short)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case INT:
						numero = leerNumero(Tipos.INT);
						if (!((int)numero <= (int)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case LONG:
						numero = leerNumero(Tipos.LONG);
						if (!((long)numero <= (long)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case FLOAT:
						numero = leerNumero(Tipos.FLOAT);
						if (!((float)numero <= (float)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case DOUBLE:
						numero = leerNumero(Tipos.DOUBLE);
						if (!((double)numero <= (double)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					}
					
					break;
				case MAYOR:
					switch (tipo) {
					case BYTE:
						numero = leerNumero(Tipos.BYTE);
						if (!((byte)numero > (byte)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case SHORT:
						numero = leerNumero(Tipos.SHORT);
						if (!((short)numero > (short)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case INT:
						numero = leerNumero(Tipos.INT);
						if (!((int)numero > (int)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case LONG:
						numero = leerNumero(Tipos.LONG);
						if (!((long)numero > (long)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case FLOAT:
						numero = leerNumero(Tipos.FLOAT);
						if (!((float)numero > (float)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case DOUBLE:
						numero = leerNumero(Tipos.DOUBLE);
						if (!((double)numero > (double)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					}
					
					break;
				case MENOR:
					switch (tipo) {
					case BYTE:
						numero = leerNumero(Tipos.BYTE);
						if (!((byte)numero < (byte)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case SHORT:
						numero = leerNumero(Tipos.SHORT);
						if (!((short)numero < (short)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case INT:
						numero = leerNumero(Tipos.INT);
						if (!((int)numero < (int)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case LONG:
						numero = leerNumero(Tipos.LONG);
						if (!((long)numero < (long)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %d, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case FLOAT:
						numero = leerNumero(Tipos.FLOAT);
						if (!((float)numero < (float)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					case DOUBLE:
						numero = leerNumero(Tipos.DOUBLE);
						if (!((double)numero < (double)comparado)) {
							System.out.printf("El número introducido NO es mayor o igual a %.2f, INTENTELO DE NUEVO: ", comparado);
							valorValido = false;
						}else
							valorValido = true;
						break;
					}
					break;	
				}
					
			} catch (InputMismatchException e){
				System.out.println(ERROR_NUM_IMPUT);
				valorValido=false;
			} 	
		}while(!valorValido);
		return numero;
	}
		

	
//PEDIR NÚMERO EN UN RANGO DADO-----------------------------------------------------------------------------------------------------------------
	public static <N> N leerEntre( N minimo, N maximo, Incluido incluido, Tipos tipo) throws IllegalArgumentException{
		N numero=null;
		boolean valorValido=true;
		
		switch (tipo) {
		case BYTE:
			if((byte)minimo>(byte)maximo)
				throw new IllegalArgumentException();
			do {
				switch (incluido) {
				case TODOS:
					numero=leerNumero(Tipos.BYTE);
					if (!((byte)numero >= (byte)minimo && (byte)numero <= (byte)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor o igual que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case NINGUNO:
					numero=leerNumero(Tipos.BYTE);
					if (!((byte)numero > (byte)minimo && (byte)numero < (byte)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MINIMO:
					numero=leerNumero(Tipos.BYTE);
					if (!((byte)numero >= (byte)minimo && (byte)numero < (byte)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MAXIMO:
					numero=leerNumero(Tipos.BYTE);
					if (!((byte)numero > (byte)minimo && (byte)numero <= (byte)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor o igual que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				}
			} while (!valorValido);	
			break;
		case SHORT:
			if((short)minimo>(short)maximo)
				throw new IllegalArgumentException();
			do {
				switch (incluido) {
				case TODOS:
					numero=leerNumero(Tipos.SHORT);
					if (!((short)numero >= (short)minimo && (short)numero <= (short)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor o igual que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case NINGUNO:
					numero=leerNumero(Tipos.SHORT);
					if (!((short)numero > (short)minimo && (short)numero < (short)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MINIMO:
					numero=leerNumero(Tipos.SHORT);
					if (!((short)numero >= (short)minimo && (short)numero < (short)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MAXIMO:
					numero=leerNumero(Tipos.SHORT);
					if (!((short)numero > (short)minimo && (short)numero <= (short)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor o igual que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				}
			} while (!valorValido);	
			break;
		case INT:
			if((int)minimo>(int)maximo)
				throw new IllegalArgumentException();
			do {
				switch (incluido) {
				case TODOS:
					numero=leerNumero(Tipos.INT);
					if (!((int)numero >= (int)minimo && (int)numero <= (int)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor o igual que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case NINGUNO:
					numero=leerNumero(Tipos.INT);
					if (!((int)numero > (int)minimo && (int)numero < (int)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MINIMO:
					numero=leerNumero(Tipos.INT);
					if (!((int)numero >= (int)minimo && (int)numero < (int)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MAXIMO:
					numero=leerNumero(Tipos.INT);
					if (!((int)numero > (int)minimo && (int)numero <= (int)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor o igual que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				}
			} while (!valorValido);	
			break;
		case LONG:
			if((long)minimo>(long)maximo)
				throw new IllegalArgumentException();
			do {
				switch (incluido) {
				case TODOS:
					numero=leerNumero(Tipos.LONG);
					if (!((long)numero >= (long)minimo && (long)numero <= (long)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor o igual que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case NINGUNO:
					numero=leerNumero(Tipos.LONG);
					if (!((long)numero > (long)minimo && (long)numero < (long)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor que %d, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MINIMO:
					numero=leerNumero(Tipos.LONG);
					if (!((long)numero >= (long)minimo && (long)numero < (long)maximo)) {
						System.out.printf("El numero no es mayor o igual que %d y menor que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MAXIMO:
					numero=leerNumero(Tipos.LONG);
					if (!((long)numero > (long)minimo && (long)numero <= (long)maximo)) {
						System.out.printf("El numero no es mayor que %d y menor o igual que %d, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				}
			} while (!valorValido);	
			break;
		case FLOAT:
			if((float)minimo>(float)maximo)
				throw new IllegalArgumentException();
			do {
				switch (incluido) {
				case TODOS:
					numero=leerNumero(Tipos.FLOAT);
					if (!((float)numero >= (float)minimo && (float)numero <= (float)maximo)) {
						System.out.printf("El numero no es mayor o igual que %.2f y menor o igual que %.2f, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case NINGUNO:
					numero=leerNumero(Tipos.FLOAT);
					if (!((float)numero > (float)minimo && (float)numero < (float)maximo)) {
						System.out.printf("El numero no es mayor que %.2f y menor que %.2f, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MINIMO:
					numero=leerNumero(Tipos.FLOAT);
					if (!((float)numero >= (float)minimo && (float)numero < (float)maximo)) {
						System.out.printf("El numero no es mayor o igual que %.2f y menor que %.2f, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MAXIMO:
					numero=leerNumero(Tipos.FLOAT);
					if (!((float)numero > (float)minimo && (float)numero <= (float)maximo)) {
						System.out.printf("El numero no es mayor que %.2f y menor o igual que %.2f, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				}
			} while (!valorValido);	
			break;
		case DOUBLE:
			if((double)minimo>(double)maximo)
				throw new IllegalArgumentException();
			do {
				switch (incluido) {
				case TODOS:
					numero=leerNumero(Tipos.DOUBLE);
					if (!((double)numero >= (double)minimo && (double)numero <= (double)maximo)) {
						System.out.printf("El numero no es mayor o igual que %.2f y menor o igual que %.2f, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case NINGUNO:
					numero=leerNumero(Tipos.DOUBLE);
					if (!((double)numero > (double)minimo && (double)numero < (double)maximo)) {
						System.out.printf("El numero no es mayor que %.2f y menor que %.2f, intentelo de nuevo: ", minimo,maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MINIMO:
					numero=leerNumero(Tipos.DOUBLE);
					if (!((double)numero >= (double)minimo && (double)numero < (double)maximo)) {
						System.out.printf("El numero no es mayor o igual que %.2f y menor que %.2f, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				case MAXIMO:
					numero=leerNumero(Tipos.DOUBLE);
					if (!((double)numero > (double)minimo && (double)numero <= (double)maximo)) {
						System.out.printf("El numero no es mayor que %.2f y menor o igual que %.2f, intentelo de nuevo: ",minimo, maximo);
						valorValido = false;
					} else
						valorValido = true;
					break;
				}
			} while (!valorValido);	
			break;
		}
		
		return numero;
	}
	
}
