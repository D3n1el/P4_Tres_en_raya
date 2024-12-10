
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
		int revJ1 = 2; //Indica que quiere hacer el jugador 1 después de finalizar una partida.
		int revJ2 = 2; //Indica que quiere hacer el jugador 2 después de finalizar una partida.
		int contRellenados = 0; //Cuenmta la cantidad total de casillas rellenadas con X o O.
		String[] nombres = {"", ""}; //Delcaración del array donde se introducen los nombres de los jugadores
		char[][] posiciones = {{'□', '□', '□'}, //Define las casillas
							   {'□', '□', '□'},	
							   {'□', '□', '□'}};	
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Jugador " + (i + 1) + ", ingresa tu nombre: ");
				nombres[i] = s.nextLine();
		}
		
		int ji = r.nextInt(2); //Genera un numero entre 0 y 1 de forma aleatoria.  ji significa JugadaInicial
		
		//Dependiendo del número generado, el programa informa de que jugador empieza.
		if (ji == 0) {
			System.out.print("Empieza el jugador " + nombres[0]); //Muestra el nombre del jugador 1
		} else if (ji == 1) {
			System.out.print("Empieza el jugador " + nombres[1]); //Muestra el nombre del jugador 2
		}
		
		while (true) { //Permite repetir la partida de forma infinita
			
			if (rev == 1) { //Si se ha escogido revancha y, por lo tanto, "rev" se incrementa en 1, se reestablecen todas las casillas con □
				for (int i = 0; i < posiciones.length; i++) {
					for (int ii = 0; ii < posiciones.length; ii++) {
						posiciones[i][ii] = '□';
						revJ1 = 2;
						revJ2 = 2;
					}
				}
				casillasRellenadas = false; //Cambia el estado del boolean "casillasRellenadas"
				rev = 2;
			}
			
			if (!primeraPartida) {ji = 0;} //Esta condición permite que en la primera partida empieze un jugador al azar y que, después, puedan seguir jugando el resto de jugadores.
			
			for (int i = ji; i < 2; i++) { //Reliza los turnos de cada jugador
				
				primeraPartida = false; //Como ya se han realizado todas las  condiciones con este boolean, lo dejamos en "false", porque ya ha pasado la primera partida. 
				
				System.out.println();
				System.out.println();
				
				if (i == 0) { //Indica quién tiene el turno.
					System.out.println("Turno para el jugador " + nombres[0]);
				} else if (i == 1) {
					System.out.println("Turno para el jugador " + nombres[1]);
				}
				
				System.out.println();
				System.out.println("Visualización de la tabla");
				
				for (int ii = 0; ii < posiciones.length; ii++) { //Visualiza el estado de cada casilla de la tabla
					for (int j = 0; j < posiciones.length; j++) {
						System.out.print(posiciones[ii][j] + " ");
					}
					System.out.println();
				}
				
				while (true) { //Bucle que impide continuar si se ha querido usar una posición que ya se han usado anteriormente.
					do { //Mientras el jugador ponga un numero inválido, el programa seguirá pidiendo indefinidamente que ponga un numero correcto.
						System.out.print("¿Que fila quieres seleccionar? (Opciones: 1, 2 ,3) "); //Pide al usuario poner un numero del 1 al 3.
						f = s.nextInt();
						if (f != 1 && f != 2 && f != 3) {System.out.println("¡NUMERO INVÁLIDO!");} //En caso de poner un numero que no sea 1, ni 2, ni 3, informa de que el numero no es válido.
					} while (f != 1 && f != 2 && f != 3); //Si el jugador ha puesto 1, 2 o 3, entyonces el programa termina el bucle, dado que el numero puesto es válido.
						
					System.out.println();
						
					do { //Mientras el jugador ponga un numero inválido, el programa seguirá pidiendo indefinidamente que ponga un numero correcto.
						System.out.print("¿Qué columna quieres seleccionar? (Opciones: 1, 2, 3) "); //Pide al usuario poner un numero del 1 al 3.
						c = s.nextInt();
						if (c != 1 && c != 2 && c != 3) {System.out.println("¡NUMERO INVÁLIDO!");} //En caso de poner un numero que no sea 1, ni 2, ni 3, informa de que el numero no es válido.
					} while (c != 1 && c != 2 && c != 3); //Si el jugador ha puesto 1, 2 o 3, entyonces el programa termina el bucle, dado que el numero puesto es válido.
					
					if (posiciones[f - 1][c - 1] == '□') {break;} //Si se ha seleccionado una posición vacía, entonces sale del bucle.
					System.out.println("YA SE HA JUGADO ESA SELECCIÓN"); //Si no, sale un aviso de que ya se ha utilizado esa posición.
				}
				
				if (i == 0) {
					posiciones[f - 1][c - 1] = 'O'; //Si es el turno del jugador 1, marca la casilla vacía con O
				} else if (i == 1) {
					posiciones[f - 1][c - 1] = 'X'; //Si es el turno del jugador 2, marca la casilla vacía con X
				}
				
				for (int ii = 0; ii < posiciones.length; ii++) {
						
						//Revisa si se han alineado X o O horizontalmente
						if (posiciones[ii][0] == 'O' && posiciones[ii][1] == 'O' && posiciones[ii][2] == 'O') { //Comprueba si se han alineado O
							ganaJ1 = true;
						}
						if (posiciones[ii][0] == 'X' && posiciones[ii][1] == 'X' && posiciones[ii][2] == 'X') { //Comprueba si se han alienado X
							ganaJ2 = true;
						}
						
						//Revisa si se han alineado X o O verticalmente
						if (posiciones[0][ii] == 'O' && posiciones[1][ii] == 'O' && posiciones[2][ii] == 'O') { //Comprueba si se han alineado O
							ganaJ1 = true;
						}
						if (posiciones[0][ii] == 'X' && posiciones[1][ii] == 'X' && posiciones[2][ii] == 'X') { //Comprueba si se han alienado X
							ganaJ2 = true;
						}
						
						//Revisa si se han alineado X o O diagonalmente
						if (posiciones[0][0] == 'O' && posiciones[1][1] == 'O' && posiciones[2][2] == 'O') { //Comprueba si se han alineado O
							ganaJ1 = true;
						}
						if (posiciones[0][0] == 'X' && posiciones[1][1] == 'X' && posiciones[2][2] == 'X') { //Comprueba si se han alienado X
							ganaJ2 = true;
						}
						
						//Revisa si se han alineado X o O diagonalmente en sentido opuesto
						if (posiciones[2][0] == 'O' && posiciones[1][1] == 'O' && posiciones[0][2] == 'O') { //Comprueba si se han alineado O
							ganaJ1 = true;
						}
						if (posiciones[2][0] == 'X' && posiciones[1][1] == 'X' && posiciones[0][2] == 'X') { //Comprueba si se han alienado X
							ganaJ2 = true;
						}	
				}
				
				contRellenados = 0; //Renicia el contador de casillas rellenadas
				
				//Recorre cada posición de la matriz, y revisa si todas las casillas están rellenadas con X o O.
				for (int ii = 0; ii < posiciones.length; ii++) {
					for (int j = 0; j < posiciones.length; j++) {
						if (posiciones[ii][j] != '□') { //Si la casilla difiere de "□" (Es decir, ya se ha rellenado esa posición con X o O), entonces suma 1 al contador de numeros rellenados. 
							contRellenados++;
						}
						if (contRellenados == 9 && ganaJ1 == false && ganaJ2 == false){ //Si el numero del contador de rellenados es 9 (La cantidad total de casillas que hay en el juego), el estado de "casillasRellenadas" pasa a verdadero, afirmando así que todas las casillas ya están rellenadas.
							casillasRellenadas = true;
						}
					}
				}
				if (casillasRellenadas) { //Lo que ocurre si el estado de "casillasRellenadas" es verdadero
					System.out.println("¡EMAPTE ENTRE AMBOS JUGADORES!");
					do { //Este "do-while" impide que se pongan numeros inválidos, de forma que siempre se repite este código si el numero introducido se considera inválido.
						System.out.print(nombres[0] + ", ¿Quieres revancha? (0 = No | 1 = Sí) ");
						revJ1 = s.nextInt();
						if (revJ1 != 0 && revJ1 != 1) {System.out.println("¡NUMERO INVÁLIDO!");}; //Este mensaje sale si se intoduce un numero inválido.
					} while (revJ1 != 0 && revJ1 != 1);
					do { //Este "do-while" impide que se pongan numeros inválidos, de forma que siempre se repite este código si el numero introducido se considera erróneo.
						System.out.print(nombres[1] + ", ¿Quieres revancha? (0 = No | 1 = Sí) ");
						revJ2 = s.nextInt();
						if (revJ2 != 0 && revJ2 != 1) {System.out.println("¡NUMERO INVÁLIDO!");}; //Este mensaje sale si se intoduce un numero inválido.
					} while (revJ2 != 0 && revJ2 != 1);
					
				}
				if (revJ1 == 1 && revJ2 == 1) { rev = 1; //Si los dos han optado por hacer revancha, la variable "rev" pasa a 1.
				} else if (casillasRellenadas){ rev = 0; } //Si alguno de los dos ha optado por no hacer revancha, la variable "rev" pasa a 0.

				if (ganaJ1 || ganaJ2 || rev == 0) {break;} //Si alguno de los jugdores ha ganado o alguno de los jugadores (O ambos) han optado por no hacer revancha, finaliza el bucle de turnos de jugadores.
				
			} //Final del bucle para hacer los turnos de cada jugador
			
			if (ganaJ1 || ganaJ2 || rev == 0) {break;} //Si alguno de los jugdores ha ganado o alguno de los jugadores (O ambos) han optado por no hacer revancha, finaliza el bucle de repetición de partida en caso de revancha.
	
		} //Fin del bucle while-true para repetir la partida en caso de revancha.
		
		for (int ii = 0; ii < posiciones.length; ii++) { //Muestra como ha quedado la tabla finalmente, al finalizar la partida.
			for (int j = 0; j < posiciones.length; j++) {
				System.out.print(posiciones[ii][j] + " ");
			}
			System.out.println();
		}
		if (ganaJ1) {System.out.println(nombres[0] + " ¡Has ganado!"); //Si ha ganado el jugador 1, sale un mensaje diciendo que ha ganado este mismo. 
		} else if (ganaJ2) {System.out.println(nombres[1] + " ¡Has ganado!"); //Si ha ganado el jugador 2, sale un mensaje diciendo que ha ganado este mismo. 
		} else if (rev == 0) {System.out.println("El juego ha concluido en empate");} //Si no ha ganado nadie y no se ha querido hacer revancha, entonces sale un mensaje diciendo que el jugeo ha concluido en empate. 
		
	}
}