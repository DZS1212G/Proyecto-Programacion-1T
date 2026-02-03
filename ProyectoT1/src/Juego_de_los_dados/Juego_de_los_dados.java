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

    static final int BET = 15; //creamos la constante del dinero que se resta y se suma
    static final int INITIALPLAYERMONEY = 100;
    static final int INITIALBANKMONEY = 0;

    public static void main(String[] args) {

        //aqui declaro todas las variiables
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int moneyPlayer = INITIALPLAYERMONEY; //dinero del jugador
        int playerWinCount = 0; // contador de victorias del jugador
        int moneyBot = INITIALPLAYERMONEY; //dinero de la maquina
        int botWinCount = 0; // contador de victorias de la maquina
        int bank = INITIALBANKMONEY; //dinero de la banca
        int roll1; //variables que determinan las tiradas
        int roll2;
        long timePlayed; //variable que va a inidicar los segundos transcurridos
        boolean finish; //iniciamos esto en false para inidicar que el juego no esta terminado
        boolean round; //inidica si la ronda sigue siendo valida, se inicia como true por que en este punto se juega la primera ronda
        boolean money = false; //variable que determina si la ronda fue ganada o perdida para asignar el dinero
        boolean win = true; // variable que maneja el turno del jugador
        boolean playerTurn = true; //indica quien le toca si es true le toca al jugador si es falso le toca a la maquina
        String game; //variable que inserta el jugador para aceptar o rechazar la partida  
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*       Quieres jugar contra mi?         *");
        System.out.println("*                                        *");
        System.out.println("*       Apuesta Apuesta Apuesta          *");
        System.out.println("*           GANA GANA GANA               *");
        System.out.println("*                                        *");
        System.out.println("******************************************");

        System.out.println("\n\nIntroduce su respuesta (S/N)");
        game = sc.nextLine();
        // esto valida si se introduce una opcion no valida

        while (game.length() == 0 || game.toUpperCase().charAt(0) != 'N' && game.toUpperCase().charAt(0) != 'S' || game.length() != 1) { //creo una validacion exclusiva por si el usuario mete un enter sin nada
            System.out.println("Opcion no valida \nIntroduzca de nuevo");
            System.out.println("\nQuieres jugar contra mi? (S/N)");
            game = sc.nextLine();
        }
        // esto detecta que el jugador no quiere jugar y cierra el programa
        if (game.toUpperCase().charAt(0) == 'N') {
            System.out.println("Tenga un buen dia :)");
        } else {
            Date startTime = new Date(); //almacena cuando se ha iniciado la partida
            System.out.printf("Jugador: %d euros%nMaquina: %d euros%nBanca: %d euros%n", moneyPlayer, moneyBot, bank);
            System.out.println("Quien saque mas alto empieza!!\n");

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

            if (playerDice < botDice) {
                playerTurn = false;
            }
            do {
                do {
                    finish = false;
                    round = true; //esto se les da estos valores aqui para que se reinicien al principio de cada ronda
                    roll1 = r.nextInt(2, 13); //inicio
                    if (playerTurn == true) {
                        System.out.println("Juegas....");
                        System.out.printf("%nTirada de salida %d", roll1);
                        if (roll1 == 7 || roll1 == 11 || roll1 == 2 || roll1 == 3 || roll1 == 12) {

                        } else {
                            System.out.printf("   Tu punto es %d%n", roll1);
                        }
                        do {
                            roll2 = r.nextInt(2, 13);
                            // todas las posibles condiciones para que la ronda termine y lo que pasa en cada caso
                            // aqui no polgo else if para que revise todas las opciones posibles, si no solo se queda con la primera

                            if (roll1 == 7 || roll1 == 11 || roll1 == 2 || roll1 == 3 || roll1 == 12 || (roll1 != 7 && roll2 == 7) || roll1 == roll2) {
                                finish = true;
                                round = false;
                            }
                            if (roll1 == 7 || roll1 == 11 || (roll1 == roll2)) {
                                money = true;
                                win = true;
                            }
                            if (roll1 == 2 || roll1 == 3 || roll1 == 12 || (roll1 != 7 && roll2 == 7)) {
                                money = false;
                                win = false;
                            }
                            if (finish == false && round == true) {
                                System.out.printf("Tu tirada para el punto %d%n", roll2);
                            }
                            if (roll1 != 7 && roll2 == 7) {
                                System.out.printf("%nTu tirada para el punto %d%n", roll2);
                                System.out.println("\nSacaste un 7 antes de sacar tu punto");
                            }
                            if (roll1 == roll2) {
                                System.out.printf("%nTu tirada para el punto %d%n", roll2);
                                System.out.println("\nTu tirada es igual que el punto");
                            }

                        } while (round == true);
                        if (money == true && finish == true) {
                            System.out.println("\nEnorabuena, has ganado 15 euros\n");
                            moneyPlayer += BET;
                            moneyBot -= BET;
                            playerWinCount++;
                        } else if (money == false && finish == true) {
                            System.out.println("\nQue pena has perdido :(\n15 euros para la banca\n");
                            moneyPlayer -= BET;
                            bank += BET;
                        }
                    }
                    if (playerTurn == false) {
                        System.out.println("Juego....");
                        System.out.printf("%nTirada de salida %d", roll1);
                        if (roll1 == 7 || roll1 == 11 || roll1 == 2 || roll1 == 3 || roll1 == 12) {

                        } else {
                            System.out.printf("   Mi punto es %d%n", roll1);
                        }
                        do {
                            roll2 = r.nextInt(2, 13);
                            // todas las posibles condiciones para que la ronda termine y lo que pasa en cada caso
                            //aqui no polgo else if para que revise todas las opciones posibles, si no solo se queda con la primera
                            if (roll1 == 7 || roll1 == 11 || roll1 == 2 || roll1 == 3 || roll1 == 12 || roll1 != 7 && roll2 == 7 || roll1 == roll2) {
                                finish = true;
                                round = false;
                            }
                            if (roll1 == 7 || roll1 == 11 || (roll1 == roll2)) {
                                money = true;
                                win = false;
                            }
                            if (roll1 == 2 || roll1 == 3 || roll1 == 12 || roll1 != 7 && roll2 == 7) {
                                money = false;
                                win = true;
                            }
                            if (finish == false && round == true) {
                                System.out.printf("Mi tirada para el punto %d%n", roll2);
                            }
                            if (roll1 != 7 && roll2 == 7) {
                                System.out.printf("Mi tirada para el punto %d%n", roll2);
                                System.out.println("\nHe sacado un 7 antes de sacar mi punto");
                            }
                            if (roll1 == roll2) {
                                System.out.printf("Mi tirada para el punto %d%n", roll2);
                                System.out.println("\nMi tirada es igual que el punto");
                            }

                        } while (round == true);
                        if (money == true && finish == true) {
                            System.out.println("\nHe ganado\n15 euros para mi\n");
                            moneyBot += BET;
                            moneyPlayer -= BET;
                            botWinCount++;
                        } else if (money == false && finish == true) {
                            System.out.println("\nHe perdido\nLa banca se lleva 15 euros mios\n");
                            moneyBot -= BET;
                            bank += BET;
                        }
                    }

                } while (finish == false);
                System.out.printf("Jugador: %d euros%nMaquina %d euros%nBanca %d euros%n", moneyPlayer, moneyBot, bank);

                if (win == true) {
                    playerTurn = true;
                }
                if (win == false) {
                    playerTurn = false;
                }
                if (moneyBot >= BET && moneyPlayer >= BET) {
                    if (playerTurn == true) {
                        System.out.println("En la siguiente ronda te tocara a ti");
                    }
                    if (playerTurn == false) {
                        System.out.println("En la siguiente ronda me tocara a mi");
                    }
                    System.out.println("\nQuieres jugar contra mi? (S/N)");
                    game = sc.nextLine();
                    while (game.length() == 0 || game.toUpperCase().charAt(0) != 'N' && game.toUpperCase().charAt(0) != 'S' || game.length() != 1) { //creo una validacion exclusiva por si el usuario mete un enter sin nada
                        System.out.println("Opcion no valida \nIntroduzca de nuevo");
                        System.out.println("\nQuieres jugar contra mi? (S/N)");
                        game = sc.nextLine();
                    }
                }

            } while (game.toUpperCase().charAt(0) == 'S' && moneyBot > BET && moneyPlayer > BET);
            Date endTime = new Date(); //almacena cuando se ha terminado la partida
            timePlayed = (endTime.getTime() - startTime.getTime()) / 1000;
            //calcula el tiempo en segundos trascurrido entre el principio y el final de la partida
            System.out.println("\n\nCantidad final de la partida");
            System.out.printf("Jugador %d%nMaquina %d%nBanca %d%n", moneyPlayer, moneyBot, bank);

            //aqui no pongo else if para que no entren en caso de no querer boluntarieamnete jugar mas 
            if (moneyBot < BET) {
                System.out.println("No tengo la cantidad minima para seguir jugando, un placer haber jugado");
            }
            if (moneyPlayer < BET) {
                System.out.println("No tienes suficiente dinero, una pena :(");
            }
            System.out.printf("%nNuestra partida ha durado %d segundos %n", timePlayed);
            System.out.printf("%nContador de victorias%nYo he ganado un total de %d veces%nTu has ganado una cantidad de %d veces%n", botWinCount, playerWinCount);
            System.out.println("\nGracias por jugar\nTenga un buen dia :)");
        }
    }
}
