package Tres_en_raya;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;  

public class Tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Random r = new Random(); 
		
		boolean casillasRellenadas = false; //Indica si se han rellenado todas las casillas.
		boolean primeraPartida = true; //Indica si es la primera partida
		boolean ganaJ1 = false; //Indica si el jugador 1 ha ganado.
		boolean ganaJ2 = false; //Indica si el jugador 2 ha ganado.
		int f = 0; //Define la fila seleccionada por el jugador
		int c = 0; //Define la columna seleccionada por el jugador
		int rev = 2; //Indica si va a haber revancha.
		int revJ1 = 2;
		int revJ2 = 2;
		int contRellenados = 0;
		String[] nombres = {"", ""}; //Delcaración del array donde se introducen los nombres de los jugadores
		char[][] posiciones = {{'□', '□', '□'},
							   {'□', '□', '□'},	
							   {'□', '□', '□'}};	
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Jugador " + (i + 1) + ", ingresa tu nombre: ");
				nombres[i] = s.nextLine();
		}
		
		int ji = r.nextInt(2); //Genera un numero entre 0 y 1 de forma aleatoria.  ji significa JugadaInicial
		
		//Dependiendo del número generado, el programa informa de que jugador empieza.
		if (ji == 0) {
			System.out.print("Empieza el jugador " + nombres[0]);
		} else if (ji == 1) {
			System.out.print("Empieza el jugador " + nombres[1]);
		}
		
		while (true) {
			
			if (rev == 1) {
				for (int i = 0; i < posiciones.length; i++) {
					for (int ii = 0; ii < posiciones.length; ii++) {
						posiciones[i][ii] = '□';
					}
				}
				casillasRellenadas = false;
			}
			
			if (!primeraPartida) {ji = 0;} //Esta condición permite que en la primera partida empieze un jugador al azar y que, después, puedan seguir jugando el resto de jugadores.
			
			for (int i = ji; i < 2; i++) {
				
				primeraPartida = false;
				
				System.out.println();
				System.out.println();
				
				if (i == 0) {
					System.out.println("Turno para el jugador " + nombres[0]);
				} else if (i == 1) {
					System.out.println("Turno para el jugador " + nombres[1]);
				}
				
				System.out.println();
				System.out.println("Visualización de la tabla");
				
				for (int ii = 0; ii < posiciones.length; ii++) {
					for (int j = 0; j < posiciones.length; j++) {
						System.out.print(posiciones[ii][j] + " ");
					}
					System.out.println();
				}
				
				while (true) {
					do { //Mientras el jugador ponga un numero inválido, el programa seguirá pidiendo indefinidamente que ponga un numero correcto.
						System.out.print("¿Que fila quieres seleccionar (Opciones: 1, 2 ,3)? "); //Pide al usuario poner un numero del 1 al 3.
						f = s.nextInt();
						if (f != 1 && f != 2 && f != 3) {System.out.println("¡NUMERO INVÁLIDO!");} //En caso de poner un numero que no sea 1, ni 2, ni 3, informa de que el numero no es válido.
					} while (f != 1 && f != 2 && f != 3); //Si el jugador ha puesto 1, 2 o 3, entyonces el programa termina el bucle, dado que el numero puesto es válido.
						
					System.out.println();
						
					do {
						System.out.print("¿Qué columna quieres seleccionar (Opciones: 1, 2, 3)? ");
						c = s.nextInt();
						if (c != 1 && c != 2 && c != 3) {System.out.println("¡NUMERO INVÁLIDO!");}
					} while (c != 1 && c != 2 && c != 3);
					
					if (posiciones[f - 1][c - 1] == '□') {break;}
					System.out.println("YA SE HA JUGADO ESA SELECCIÓN");
				}
				
				if (i == 0) {
					posiciones[f - 1][c - 1] = 'O'; //Si es el turno del jugador 1, marca la casilla vacía con O
				} else if (i == 1) {
					posiciones[f - 1][c - 1] = 'X'; //Si es el turno del jugador 2, marca la casilla vacía con X
				}
				
				for (int ii = 0; ii < posiciones.length; ii++) {
						
						//Revisa si se han alineado X o O horizontalmente
						if (posiciones[ii][0] == 'O' && posiciones[ii][1] == 'O' && posiciones[ii][2] == 'O') {
							ganaJ1 = true;
						}
						if (posiciones[ii][0] == 'X' && posiciones[ii][1] == 'X' && posiciones[ii][2] == 'X') {
							ganaJ2 = true;
						}
						
						//Revisa si se han alineado X o O verticalmente
						if (posiciones[0][ii] == 'O' && posiciones[1][ii] == 'O' && posiciones[2][ii] == 'O') {
							ganaJ1 = true;
						}
						if (posiciones[0][ii] == 'X' && posiciones[1][ii] == 'X' && posiciones[2][ii] == 'X') {
							ganaJ2 = true;
						}
						
						//Revisa si se han alineado X o O diagonalmente
						if (posiciones[0][0] == 'O' && posiciones[1][1] == 'O' && posiciones[2][2] == 'O') {
							ganaJ1 = true;
						}
						if (posiciones[0][0] == 'X' && posiciones[1][1] == 'X' && posiciones[2][2] == 'X') {
							ganaJ2 = true;
						}
						
						//Revisa si se han alineado X o O diagonalmente en sentido opuesto
						if (posiciones[2][0] == 'O' && posiciones[1][1] == 'O' && posiciones[0][2] == 'O') {
							ganaJ1 = true;
						}
						if (posiciones[2][0] == 'X' && posiciones[1][1] == 'X' && posiciones[0][2] == 'X') {
							ganaJ2 = true;
						}
						
				}
				
				contRellenados = 0;
				
				for (int ii = 0; ii < posiciones.length; ii++) {
					for (int j = 0; j < posiciones.length; j++) {
						if (posiciones[ii][j] != '□') {
							contRellenados++;
						}
						if (contRellenados == 9){
							casillasRellenadas = true;
						}
					}
				}
				if (casillasRellenadas) {
					System.out.println("¡EMAPTE ENTRE AMBOS JUGADORES!");
					do {
						System.out.print(nombres[0] + ", ¿Quieres revancha? (0 = No | 1 = Sí)");
						revJ1 = s.nextInt();
						if (revJ1 != 0 && revJ1 != 1) {System.out.println("¡NUMERO INVÁLIDO!");};
					} while (revJ1 != 0 && revJ1 != 1);
					do {
						System.out.print(nombres[1] + ", ¿Quieres revancha? (0 = No | 1 = Sí)");
						revJ2 = s.nextInt();
						if (revJ2 != 0 && revJ2 != 1) {System.out.println("¡NUMERO INVÁLIDO!");};
					} while (revJ2 != 0 && revJ2 != 1);
					
				}
				if (revJ1 == 1 && revJ2 == 1) {
					rev++;
				} else if (casillasRellenadas){ rev = 0; }

				if (ganaJ1 || ganaJ2 || rev == 0) {break;}
				
			}
			//if (ganaJ1 || ganaJ2 || rev == 1) {break;}
		}
	}
}
