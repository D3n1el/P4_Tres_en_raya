package Tres_en_raya;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;  

public class Tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Random r = new Random(); 
		
		
		String[] nombres = {"", ""}; //Delcaración del array donde se introducen los nombres de los jugadores
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Jugador " + (i + 1) + ", ingresa tu nombre: ");
				nombres[i] = s.nextLine();
		}
		
		int jugadaInicial = r.nextInt(2) + 1; //Genera un numero entre 1 y 2 de forma aleatoria
		
		//Dependiendo del número generado, el programa informa de que jugador empieza.
		if (jugadaInicial == 1) {
			System.out.print("Empieza el jugador " + nombres[0]);
		} else if (jugadaInicial == 2) {
			System.out.print("Empieza el jugador " + nombres[1]);
		}
		
		
		
	}

}
