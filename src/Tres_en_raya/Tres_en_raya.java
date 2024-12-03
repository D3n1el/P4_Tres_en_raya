package Tres_en_raya;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;  

public class Tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		String[] nombres = {"", ""};
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Jugador " + (i + 1) + ", ingresa tu nombre: ");
				nombres[i] = s.nextLine();
		}
		
		int jugadaInicial = r.nextInt(2) + 1;
		
		if (jugadaInicial == 1) {
			System.out.print("Empieza el jugador " + nombres[0]);
		} else if (jugadaInicial == 2) {
			System.out.print("Empieza el jugador " + nombres[1]);
		}
		
	}

}
