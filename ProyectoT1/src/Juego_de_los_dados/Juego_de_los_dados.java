/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego_de_los_dados;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zapsobdi
 */
public class Juego_de_los_dados {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int moneyP1 = 100; //dinero del jugador
        int moneyM = 100; //dinero de la maquina
        int banca = 0; //dinero de la banca
        boolean finalJuego = false; //iniciamos esto en false para inidicar que el juego no esta terminado
        boolean win = false; //iniciamos esta variable en falso por que no se ha ganado
        boolean ronda = true; //inidica si la ronda sigue siendo valida
        System.out.println("Reglas del juego:\nTiramos dados para decidir el orden\nAl que le haya tocado tirara los dados");
        System.out.println("Si te toca un 7 o un 11 ganaras la ronda automaticamente");
        System.out.println("Si te toca un 2, 3 o 12 perderas la ronda automaticamente");
        System.out.println("Si te toca algo diferente tiraras una segunda vez");
        System.out.println("Si la segunda tirada sale igual que la anterior, ganaras la ronda");
        System.out.println("Si la tirada sale un 7 perderas la ronda");
        System.out.println("Si sale algo diferente a su anterior tirada o 7, volveras a tirar hasta que toque alguno de esos resultados");
        System.out.println("Ganar significa ganar 15 euros, perder significa perder 15 euros y mandarles a la banca");
        System.out.println("Podras jugar todas las veces que quieras, mientras que tu y yo tengamos mas de 15 euros");
        System.out.println("Quieres jugar contra mi? (S/N)");
        String juego = sc.nextLine();
        while (juego.toUpperCase().charAt(0) != 'N' && juego.toUpperCase().charAt(0) != 'S' || juego.length() > 1) {
            System.out.println("Opcion no valida \nIntroduzca de nuevo");
            System.out.println("Quieres jugar contra mi? (S/N)");
            juego = sc.nextLine();
        }
        if (juego.toUpperCase().charAt(0) == 'N') {
            System.out.println("Tenga un buen dia :)");
        } else {
            do {

                System.out.println("Tirada de salida");
                System.out.printf("Tu dinero %d%nMi dinero %d%nDinero de la banca %d%n", moneyP1, moneyM, banca);
                System.out.println("Quien saque mas alto empieza!!");
                do {

                    int dP1Tds = 0; //las inicio aqui para que no haya problemas con el bucle
                    int dMTds = 0;
                    System.out.printf("Tu tirada fue %d%n", dP1Tds);
                    System.out.printf("Mi tirada fue %d%n", dMTds);
                    do {

                        System.out.println("Nuestras tiradas fueron iguales, volveremos a tirar");
                        dP1Tds = r.nextInt(1, 13);
                        //dado jugador Tirada de salida
                        dMTds = r.nextInt(1, 13);
                        //dado Maquina Tirada de salida
                        System.out.printf("%nTu tirada fue %d%n", dP1Tds);
                        System.out.printf("Mi tirada fue %d%n%n", dMTds);
                        if (dP1Tds == dMTds) {

                        }
                    } while (dP1Tds == dMTds);
                    int tirada1 = 0; //las inicio aqui para usarlo en ambos lados
                    int tirada2 = 0;
                    tirada1 = r.nextInt(1, 13); //inicio
                    if (dP1Tds > dMTds) {
                        System.out.println("Te toca a ti");
                        System.out.printf("\nResultado de tu primera tirada %d%n", tirada1);
                        do {
                            tirada2 = r.nextInt(1, 13);
                            if (tirada1 == 7 || tirada1 == 11) {
                                finalJuego = true;
                                win = true;
                                ronda = false;
                            } else if (tirada1 == 2 || tirada1 == 3 || tirada1 == 12) {
                                finalJuego = true;
                                ronda = false;
                                win = false;
                            } else if (tirada1 == tirada2) {

                                System.out.printf("Tu tirada para el punto %d%n", tirada2);
                                System.out.println("\nTu segunda tirada es igual que la primera");

                                finalJuego = true;
                                win = true;
                                ronda = false;
                            } else if (tirada1 != 7 && tirada2 == 7) {
                                System.out.printf("Tu tirada para el punto %d%n", tirada2);
                                System.out.println("\nSacaste un 7 antes de sacar tu punto");
                                finalJuego = true;
                                ronda = false;
                                win = false;
                            }

                        } while (ronda == true);
                        if (win == true && finalJuego == true) {
                            System.out.println("Enorabuena, has ganado");
                            moneyP1 += 15;
                        } else if (win == false && finalJuego == true) {
                            System.out.println("Que pena has perdido :(");
                            moneyP1 -= 15;
                            banca += 15;
                        }
                    } else {
                        System.out.println("Me toca a mi");
                        System.out.printf("Resultado de mi tirada es %d%n", tirada1);
                        do {
                            tirada2 = r.nextInt(1, 13);
                            if (tirada1 == 7 || tirada1 == 11) {
                                finalJuego = true;
                                win = true;
                                ronda = false;
                            } else if (tirada1 == 2 || tirada1 == 3 || tirada1 == 12) {
                                finalJuego = true;
                                ronda = false;
                                win = false;
                            } else if (tirada1 == tirada2) {

                                System.out.printf("Mi tiradada para el punto %d%n", tirada2);
                                System.out.println("\nMi segunda tirada fue igual que la primera");

                                finalJuego = true;
                                win = true;
                                ronda = false;
                            } else if (tirada1 != 7 && tirada2 == 7) {
                                System.out.printf("Mi tirada para el punto %d%n", tirada2);
                                System.out.println("\nHe sacado un 7 antes de sacar mi punto");
                                finalJuego = true;
                                ronda = false;
                                win = false;
                            }
                            System.out.printf("Mi tirada para el punto: %d%n", tirada2);
                        } while (ronda == true);
                        if (win == true && finalJuego == true) {
                            System.out.println("\nHe ganado");
                            moneyM += 15;
                        } else if (win == false && finalJuego == true) {
                            System.out.println("\nHe perdido");
                            moneyM -= 15;
                            banca += 15;
                        }
                    }
                    System.out.printf("%nTu dinero %d%nMi dinero %d%nDinero de la banca %d%n", moneyP1, moneyM, banca);
                } while (finalJuego == false);
                System.out.println("Quieres volver a jugar? (S/N)");
                juego = sc.nextLine(); //copio toda la comprobacion de vuelta
                while (juego.toUpperCase().charAt(0) != 'N' && juego.toUpperCase().charAt(0) != 'S' || juego.length() > 1) {
                    System.out.println("Opcion no valida \nIntroduzca de nuevo");
                    System.out.println("Quieres volver a jugar? (S/N)");
                    juego = sc.nextLine();
                }
                if (juego.toUpperCase().charAt(0) == 'N') {
                    System.out.println("Gracias por jugar\nTenga un buen dia :)");
                    return;
                }
            } while (juego.toUpperCase().charAt(0) == 'S' && moneyM > 15 && moneyP1 > 15);
            System.out.println("Cantidad final de la partida");
            System.out.printf("Dinero del Jugador %d%nDinero de la maquina %d%nDinero de la banca %d%n", moneyP1, moneyM, banca);
            if (moneyM < 15) {
                System.out.println("No tengo la cantidad minima para seguir jugando, un placer haber jugado");
            } else if (moneyP1 < 15) {
                System.out.println("No tienes suficiente dinero, una pena :(");
            }
            System.out.println("No se puede continuar jugando\nGracias por jugar");
        }
    }
}
