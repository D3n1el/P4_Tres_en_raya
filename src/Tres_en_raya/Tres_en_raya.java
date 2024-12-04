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
		int f = 0; //Define la fila seleccionada por el jugador
		int c = 0; //Define la columna seleccionada por el jugador
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
		
		while (!casillasRellenadas) {
			
			if (!primeraPartida) {ji = 0;} //Esta condición permite que en la primera partida empieze un jugador al azar i que, después, puedan seguir jugando el resto de jugadores.
			
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
					for (int j = 0; j < posiciones.length; j++) {
						if (posiciones[ii][j] != '□') {
							casillasRellenadas = true;
						}
						if (posiciones[ii][j] == '□') {
							casillasRellenadas = false;
						}
					}
				}
			}
		
		} 
	}
}
