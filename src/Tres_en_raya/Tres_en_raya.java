package Tres_en_raya;

import java.util.Scanner;
import java.util.Arrays;

public class Tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String[] nombres = {"", ""};
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Jugador " + (i + 1) + ", ingresa tu nombre: ");
				nombres[i] = s.nextLine();
		}
		
		
		
	}

}
