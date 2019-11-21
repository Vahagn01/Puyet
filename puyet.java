/*
 * puyet.java
 * 
 * Los chinos es un juego de azar que consiste en intentar adivinar el número total de monedas que varios jugadores (al menos dos) guardan en su mano cerrada. 
 * Se utilizan tres monedas por jugador y se pueden sacar 0, 1, 2 o 3 monedas. El numero que elija el primero no podrá repetirse.
 * 
 * Nombre : Puyet
 * 
 * Propósito: crear el juego de los chinos 
 * 
 * Entradas : 
 * 
 * - int numUsuario , totalCPU 
 * - char respuesta 
 * 
 * Salidas :
 * 
 * - int totalUsuario 
 * - int ganador
 * - int rondas
 * - int turno
 * 
 * Variables :
 * 
 * - int totalUsuario 
 * - int victorias
 * - int numUsuario 
 * - int totalCPU 
 * - char respuesta
 * - int turno 
 * - int total
 * 
 * Restricciones : 
 * - El numero de piedras que elija el usuario y la cpu debe ser mayor o igual que 0 y menor o igual que 3.
 * - El orden de comienzo se elige de manera aleatoria
 * - El numero total debe ser mayor o igual que 0 y menor o igual que 6
 * - El numero total de piedras que elija el que empieze la ronda no lo puede repetir el siguiente.
 * - El total elegido por el usuario o generado por la CPU debe ser igual o mayor al numero de piedras en su mano.
 * - El primero que llegue  a 3 victorias gana.
 * 
 * PSEUDOCÓDIGO GENERALIZADO
 * 
 * INICIO
 * 
 * Empezamos pidiendo al usuario que elija las piedras que quiere guardar en su mano.
 * Leemos y validamos el numero de piedras.
 * Generamos un numero aletorio entre 0 y 3 para asignar el numero de piedras que tendra la CPU en la mano.
 * Sumamos el numero del usuario y el de la CPU para ver el total.
 * De manera aleatoria elegimos quien empieza.
 * Preguntamos al usuario o CPU(dependiendo el que comienze) cuantas piedras cree que hay en total entre los dos.
 * Leemos y validamos el numero total.
 * Leemos y validamos el numero total del segundo.
 * Comparamos el total que ha dicho el usuario y el que ha generado la CPU con el total real.
 * Decimos el ganador y sumamos un punto al que haya ganado, en caso de que no haya ganado nadie no se suma nada a ninguno.
 * Preguntamos si quiere seguir jugando la siguiente ronda o si quiere salir.
 * Cuando uno de los dos llegue a 3 victorias preguntamos si quiere jugar de nuevo.
 * 
 */

import java.util.Scanner;
import java.util.Random; 
public class puyet {
	
	public static void main (String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Random ran = new Random();
		
		//Comenzamos declarando las variables que vamos a usar 
		
		int numUsuario, numCPU;
		int totalUsuario, totalCPU , total;
		int victoriasUsuario, victoriasCPU;
		int ronda, turno;
		char respuesta;
		
	do {
		
		//Asiganamos un valor a las variables, esto tambien nos sirve para reinciar su valor al volver a jugar
		ronda = 0;
		victoriasCPU = 0;
		victoriasUsuario = 0;
		respuesta = ' ';
		
		//Empezamos explicando como se juega al Puyet
		
		System.out.println ("Los chinos es un juego de azar que consiste en intentar adivinar el numero total de monedas que varios jugadores\n(al menos dos) guardan en su mano cerrada.Se utilizan tres monedas por jugador y se pueden sacar 0,1,2 o 3 monedas.\nDespues intentan adivinar el total de piedras que hay entre las dos manos,el numero que elija el que empieze no lo \npuede repetir el que le siga.");
		
		
		
		do {
			
			ronda++;
			//Imprimimos la ronda que es
			System.out.println("\n ///////////\n / RONDA "+ ronda + " /\n ///////////");
			
			//Pedimos al usuario que elija un numero de piedras que quiere guardar en su mano
			do{
				
				System.out.println ();
				System.out.println ("Escoje cuantas monedas quieres guardar en tu mano");
				numUsuario = teclado.nextInt ();
				
				if (numUsuario < 0 || numUsuario >3) {
					
					System.out.println ("Introduzca un numero valido por favor."); //Imprimimos un mensaje de error si el numero introducido no es valido 
					
					}
				
			} while(numUsuario < 0 || numUsuario >3);
				
				//Asignamos un numero aleatorio de piedras a la CPU, este numero esta comprendido entre 0 y 3, cogiendo ambos.
				numCPU = ran.nextInt(4);
				System.out.println("La CPU ya ha guardado x piedras en su mano\n");
				
				//Sumamos el numero elegido por la CPU y el numero elegido por el usuario para poder comprobar depues el resultado
				total = numCPU + numUsuario;
				
				//Elegimos el primero que empieza a decir el total de manera aleatoria
				turno = ran.nextInt (2); 
				
					//Si el turno es = 0 empezará el usuario y si turno=1 empezará la CPU
					
					if (turno==0){
						
						//Preguntamos al usuario el numero de piedras que cree que hay en total
						
						do{
							
							System.out.println("Cuantas piedras crees que hay en total? Sumando las tuyas y las de la CPU");
							totalUsuario = teclado.nextInt ();
							
							if  (totalUsuario<numUsuario){
								
								System.out.println("\nCuenta bien las que tienes en la mano, no creo que el total sea menor.");
								
								}
								
							if (totalUsuario>6){
								
								System.out.println("\nEl total de piedras no pude ser mayor que 6");
								
								}
							
						}while (totalUsuario<numUsuario || totalUsuario>6);
							
						//Asignamos un total aleatorio a la CPU, pero este debe ser mayor o igual que las piedras que haya guardado en su mano y menor o igual que 6.	
						
						do {
							
							totalCPU = ran.nextInt(7-numCPU);
							totalCPU = numCPU + totalCPU;
							
						} while(totalCPU>6 || totalCPU == totalUsuario );
						
							
							System.out.println ("La CPU ha supuesto que hay un total de "+ totalCPU+ " piedras");
							
							
							
						
						}
					
					else {
							
							//Asignamos un total aleatorio a la CPU, pero este debe ser mayor o igual que las piedras que haya guardado en su mano y menor o igual que 6.	
						do{
							
							totalCPU = ran.nextInt(7-numCPU);
							totalCPU = numCPU + totalCPU;
							
							System.out.println ("\nLa CPU ha supuesto que hay un total de "+ totalCPU+ " piedras");
							
							
							
						}while(totalCPU>6 );
						
						//Preguntamos al usuario el numero de piedras que cree que hay en total
						
						do {
							
							System.out.println("Cuantas piedras crees que hay en total? Sumando las tuyas y las de la CPU");
							totalUsuario = teclado.nextInt ();
							
							if  (totalUsuario<numUsuario){
								
								System.out.println("\nCuenta bien las que tienes en la mano, no creo que el total sea menor.");
								
								}
								
							if (totalUsuario>6){
								
								System.out.println("\nEl total de piedras no pude ser mayor que 6");
								
								}
							
							if (totalUsuario==totalCPU) {
								
								System.out.println ("\nNo puedes usar este numero porque lo ha elegido ya la CPU");
								
								}
							
							
							
						}while (totalUsuario<numUsuario || totalUsuario>6 || totalUsuario == totalCPU);
						
					}	
					
				if (totalUsuario == total){
					
					victoriasUsuario++;
					System.out.println("\nHas ganado esta ronda! Llevas " + victoriasUsuario + " victorias");
					
				}else
					
				if (totalCPU == total){
					
					victoriasCPU++;
					System.out.println("\nLa CPU ha ganado esta ronda! Lleva " + victoriasCPU + " victorias");
				}	
					
				else {
					
					System.out.println ("\nLastima, ambos perdieron");
					
					}
					
					if (victoriasUsuario < 3 && victoriasCPU < 3)	{
						
						System.out.println("\nQuieres seguir jugando? S/N");
						respuesta= teclado.next().charAt (0);
						System.out.println ();
					}
					
		}while (victoriasUsuario < 3 && victoriasCPU < 3  && respuesta == 'S');		
		
			
		

		
		if (victoriasUsuario == 3) {
			
			System.out.println("\n//////////////////////////////////////////////\n/// Has ganado la partida!, bien jugado :) ///\n//////////////////////////////////////////////");
			
			}
			
		if (victoriasCPU == 3) {
			
			System.out.println("\n/////////////////////////////////////////////////////////////////////\n/// La CPU ha ganado la partida!, la proxima vez seguro que ganas ///\n///////////////////////////////////////////////////////////////////// ");
			
			}
		
		System.out.println("\nQuieres volver a jugar al Puyet? S/N");
		respuesta= teclado.next().charAt (0);
		
			if (respuesta != 'S'){
				
				System.out.println("\nGracias por usar mi programa!");
				
				}
	
	}while (respuesta == 'S');
	
	teclado.close();
		
	}
}

