package Tres_en_raya;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;  

public class Tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Random r = new Random(); 
		
		boolean casillasRellenadas = false;
		
		String[] nombres = {"", ""}; //Delcaración del array donde se introducen los nombres de los jugadores
		char[][] posiciones = {{'_', '_', '_'},
							   {'_', '_', '_'},	
							   {'_', '_', '_'}};	
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Jugador " + (i + 1) + ", ingresa tu nombre: ");
				nombres[i] = s.nextLine();
		}
		
		int ji = r.nextInt(2) + 1; //Genera un numero entre 1 y 2 de forma aleatoria.  ji significa JugadaInicial
		
		//Dependiendo del número generado, el programa informa de que jugador empieza.
		if (ji == 1) {
			System.out.print("Empieza el jugador " + nombres[0]);
		} else if (ji == 2) {
			System.out.print("Empieza el jugador " + nombres[1]);
		}
		
		while (!casillasRellenadas) {
			
			for (int i = ji; i < 2; i++) {
				
				System.out.println();
				
				if (ji == 0) {
					System.out.print("Turno para el jugador " + nombres[0]);
				} else if (ji == 1) {
					System.out.print("Turno para el jugador " + nombres[1]);
				}
				
				System.out.print("Visualización de la tabla");
				
				for (int ii = 0; i < posiciones.length; i++) {
					for (int j = 0; j < posiciones.length; j++) {
						System.out.print(posiciones[j][i] + " ");
					}
					System.out.println();
				}
				
				for (int ii = 0; i < posiciones.length; i++) {
					for (int j = 0; j < posiciones.length; j++) {
						if (posiciones[j][i] == '_') {
							casillasRellenadas = true;
						}
					}
				}
				
			}
			
		}
		
	}

}
