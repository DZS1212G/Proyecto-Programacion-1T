/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego_de_los_dados;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zapsobdi
 */
public class Juego_de_los_dados {

    public static void main(String[] args) {
        //aqui declaro todas las variiables
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int moneyPlayer = 100; //dinero del jugador
        int moneyBot = 100; //dinero de la maquina
        int banca = 0; //dinero de la banca
        int roll1; //variables que determinan las tiradas
        int roll2;
        long timePlayed; //variable que va a inidicar los segundos transcurridos
        boolean finish = false; //iniciamos esto en false para inidicar que el juego no esta terminado
        boolean win = false; //variable que determina si la ronda fue ganada o perdida
        String game; //variable que inserta el jugador para aceptar o rechazar la partida       
        System.out.println("\nQuieres jugar contra mi? (S/N)");
        game = sc.nextLine();
        // esto valida si se introduce una opcion no validaa
        while (game.toUpperCase().charAt(0) != 'N' && game.toUpperCase().charAt(0) != 'S' || game.length() > 1) {
            System.out.println("Opcion no valida \nIntroduzca de nuevo");
            System.out.println("\nQuieres jugar contra mi? (S/N)");
            game = sc.nextLine();
        }
        // esto detecta que el jugador no quiere jugar y cierra el programa
        Date startTime = new Date();
        if (game.toUpperCase().charAt(0) == 'N') {
            System.out.println("Tenga un buen dia :)");

        } else {
            do {

                System.out.printf("Tu dinero: %d euros%nMi dinero: %d euros%nDinero de la banca: %d euros%n", moneyPlayer, moneyBot, banca);
                System.out.println("Quien saque mas alto empieza!!\n");

                do {
                    boolean round = true; //inidica si la ronda sigue siendo valida, se inicia como true por que en este punto se juega la primera ronda
                    //pongo apartir del 2 por que dos dados lo minimo que sale es un 2
                    int playerDice = r.nextInt(2, 13); //variables que deciden quien juega
                    int botDice = r.nextInt(2, 13);
                    System.out.printf("Tu tirada fue %d%n", playerDice);
                    System.out.printf("Mi tirada fue %d%n%n", botDice);
                    while (playerDice == botDice) { //uso un while en esta ocasion para que en caso de que no ocurra este suceso, no entre en el bucle
                        System.out.println("Nuestras tiradas fueron iguales, volveremos a tirar");
                        playerDice = r.nextInt(2, 13);
                        botDice = r.nextInt(2, 13);
                        System.out.printf("%nTu tirada fue %d%n", playerDice);
                        System.out.printf("Mi tirada fue %d%n%n", botDice);
                    }
                    roll1 = r.nextInt(2, 13); //inicio
                    if (playerDice > botDice) {
                        System.out.println("Te toca a ti");
                        System.out.printf("\nResultado de tu primera tirada %d%n", roll1);
                        do {
                            roll2 = r.nextInt(2, 13);
                            // todas las posibles condiciones para que la ronda termine y lo que pasa en cada caso
                            //aqui no polgo else if para que revise todas las opciones posibles, si no solo se queda con la primera

                            if (roll1 == 7 || roll1 == 11 || roll1 == 2 || roll1 == 3 || roll1 == 12 || roll1 != 7 && roll2 == 7 || roll1 == roll2) {
                                finish = true;
                                round = false;
                            }
                            if (roll1 == 7 || roll1 == 11 || roll1 == roll2) {
                                win = true;
                            }
                            if (roll1 == 2 || roll1 == 3 || roll1 == 12 || roll1 != 7 && roll2 == 7) {
                                win = false;
                            }
                            if (roll1 != 7 && roll2 == 7) {
                                System.out.printf("Tu tirada para el punto %d%n", roll2);
                                System.out.println("\nSacaste un 7 antes de sacar tu punto");
                            }
                            if (roll1 == roll2) {
                                System.out.printf("Tu tirada para el punto %d%n", roll2);
                                System.out.println("\nTu tirada es igual que el punto");
                            }
                            System.out.printf("Tu tirada para el punto %d%n", roll2);
                        } while (round == true);
                        if (win == true && finish == true) {
                            System.out.println("Enorabuena, has ganado 15 euros");
                            moneyPlayer += 15;
                            moneyBot -= 15;
                        } else if (win == false && finish == true) {
                            System.out.println("Que pena has perdido :(\n15 euros para la banca");
                            moneyPlayer -= 15;
                            banca += 15;
                        }
                    } else {
                        System.out.println("Me toca a mi");
                        System.out.printf("Resultado de mi tirada es %d%n", roll1);
                        do {
                            roll2 = r.nextInt(2, 13);
                            // todas las posibles condiciones para que la ronda termine y lo que pasa en cada caso
                            //aqui no polgo else if para que revise todas las opciones posibles, si no solo se queda con la primera
                            if (roll1 == 7 || roll1 == 11 || roll1 == 2 || roll1 == 3 || roll1 == 12 || roll1 != 7 && roll2 == 7 || roll1 == roll2) {
                                finish = true;
                                round = false;
                            }
                            if (roll1 == 7 || roll1 == 11 || roll1 == roll2) {
                                win = true;
                            }
                            if (roll1 == 2 || roll1 == 3 || roll1 == 12 || roll1 != 7 && roll2 == 7) {
                                win = false;
                            }
                            if (roll1 != 7 && roll2 == 7) {
                                System.out.printf("Mi tirada para el punto %d%n", roll2);
                                System.out.println("\nHe sacado un 7 antes de sacar mi punto");
                            }
                            if (roll1 == roll2) {
                                System.out.printf("Mi tirada para el punto %d%n", roll2);
                                System.out.println("\nMi tirada es igual que el punto");
                            }
                            System.out.printf("Mi tirada para el punto %d%n", roll2);
                        } while (round == true);
                        if (win == true && finish == true) {
                            System.out.println("\nHe ganado\n15 euros para mi");
                            moneyBot += 15;
                            moneyPlayer -= 15;
                        } else if (win == false && finish == true) {
                            System.out.println("\nHe perdido\nLa banca se lleva 15 euros mios");
                            moneyBot -= 15;
                            banca += 15;
                        }
                    }
                } while (finish == false);
                System.out.println("Quieres volver a jugar? (S/N)");
                game = sc.nextLine(); //copio toda la comprobacion de vuelta
                while (game.toUpperCase().charAt(0) != 'N' && game.toUpperCase().charAt(0) != 'S' || game.length() > 1) {
                    System.out.println("Opcion no valida \nIntroduzca de nuevo");
                    System.out.println("Quieres volver a jugar? (S/N)");
                    game = sc.nextLine();
                }
            } while (game.toUpperCase().charAt(0) == 'S' && moneyBot > 15 && moneyPlayer > 15);
            Date endTime = new Date();
            timePlayed = (endTime.getTime() - startTime.getTime()) / 1000;
            System.out.printf("%nNuestra partida ha durado %d segundos %n", timePlayed);
            System.out.println("Cantidad final de la partida");
            System.out.printf("Dinero del Jugador %d%nDinero de la maquina %d%nDinero de la banca %d%n", moneyPlayer, moneyBot, banca);
            //aqui no pongos else if para que no entren en caso de no querer boluntarieamnete jugar mas 
            if (moneyBot < 15) {
                System.out.println("No tengo la cantidad minima para seguir jugando, un placer haber jugado");
            }
            if (moneyPlayer < 15) {
                System.out.println("No tienes suficiente dinero, una pena :(");
            }
            System.out.println("Gracias por jugar\nTenga un buen dia :)");
        }
    }
}
