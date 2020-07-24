/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg1_davidzavala;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 50431
 */
public class Lab1_DavidZavala {

    static Scanner read = new Scanner(System.in);
    static int Size = 9;

    public static void main(String[] args) {
        char sn = 's';
        while (sn == 's') {
            System.out.println("<Sistema Privado de Gobierno Corrupto>");
            System.out.println("    <Operaciones Classificadas> ");
            System.out.println("    <Simulador de Batalla Naval>");
            System.out.println("         <  1) Ejecutar  >");
            System.out.println("         <  2) Salir     >");
            int op = read.nextInt();
            switch (op) {
                case 1: {

                    char[][] Mar1 = new char[Size][Size];
                    char[][] Mar2 = new char[Size][Size];
                    int Life1 = 100;
                    int Life2 = 100;
                    int Hits1 = 0;
                    int Hits2 = 0;
                    String Jugador1 = JOptionPane.showInputDialog("Identificacion del Contrincante #1");
                    System.out.println("Mar de: " + Jugador1);

                    String Jugador2 = JOptionPane.showInputDialog("Identificacion del Contrincante #2");
                    System.out.println("Mar de: " + Jugador2);

                    //empiezan turnos
                    boolean tf = true;
                    while (tf) {
                        //jugador1
                        Mar1 = FillMAt(Mar1, Size);
                        PrintMat(Mar1, Size);
                        Mar2 = FillMAt(Mar2, Size);
                        PrintMat(Mar2, Size);
                        System.out.println(Jugador1 + " ingrese las coordenadas de su disparo");
                        int Lat1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese longitud(1-8): "));
                        char Lon1 = JOptionPane.showInputDialog("Ingrese latitud(A-H):").charAt(0);
                        int x = Lat1 - 48;
                        System.out.println(x);
                        int y = Lon1 - 65;
                        System.out.println(y);
                        Shots2(Mar2, x, y, Life2, Hits2);
                        System.out.println("");

                        //jugador2
                        Mar2 = FillMAt(Mar2, Size);
                        PrintMat(Mar2, Size);
                        Mar1 = FillMAt(Mar1, Size);
                        PrintMat(Mar1, Size);
                        System.out.println(Jugador1 + " ingrese las coordenadas de su disparo");
                        int Lat2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese longitud(1-8): "));
                        char Lon2 = JOptionPane.showInputDialog("Ingrese latitud(A-H):").charAt(0);
                        x = Lat1 - 48;
                        System.out.println(x);
                        y = Lon1 - 65;
                        System.out.println(y);
                        Shots1(Mar2, x, y, Life1, Hits1);
                        System.out.println();
                        
                        if (Hits1 == 12 || Hits1 == 3 && Hits2 == 0) {
                            System.out.println(Jugador1 + " ha derrotado a su contrincante " + Jugador2);
                        } else if (Hits1 == 12 || Hits1 == 3 && Hits2 == 0) {
                            System.out.println(Jugador2 + " ha derrotado a su contrincante " + Jugador1);

                        }
                    }

                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "Adios");
                    sn = 'n';
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
                }
            }
        }

    }

    static void Shots1(char[][] Mat, int X, int Y, int Life1, int Hits1) {
        if (X == 1 && Y == 1 || X == 1 && Y == 2 || X == 1 && Y == 3 || X == 2 && Y == 7 || X == 2 && Y == 8 || X == 3 && Y == 4 || X == 3 && Y == 7 || X == 4 && Y == 5 || X == 5 && Y == 6 || X == 8 && Y == 6 || X == 8 && Y == 7 || X == 8 && Y == 8) {
            Mat[X][Y] = 'X';
            Hits1++;
            Life1 -= ((Hits1 / 12) * 100);
        } else {
            Mat[X][Y] = '~';
        }
    }

    static void Shots2(char[][] Mat, int X, int Y, int Life2, int Hits2) {
        if (X == 2 && Y == 2 || X == 2 && Y == 3 || X == 2 && Y == 6 || X == 2 && Y == 7 || X == 2 && Y == 8 || X == 3 && Y == 3 || X == 6 && Y == 1 || X == 6 && Y == 2 || X == 6 && Y == 3 || X == 6 && Y == 6 || X == 7 && Y == 5 || X == 5 && Y == 7) {
            Mat[X][Y] = 'X';
            Hits2++;
            Life2 -= ((Hits2 / 12) * 100);
        } else {
            Mat[X][Y] = '~';
        }
    }

    static char[][] FillMAt(char[][] Mat, int tam) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                int A = i + 64;
                int B = j + 48;
                if (i == 0 && j == 0 || i != 0 && j != 0) {
                    Mat[i][j] = ' ';
                } else if (i == 0 && j > 0) {
                    Mat[i][j] = (char) B;
                } else if (j == 0 && i > 0) {
                    Mat[i][j] = (char) A;
                }
            }
        }
        return Mat;
    }

    static void PrintMat(char Mat[][], int tam) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print("{" + Mat[i][j] + "}");
            }
            System.out.println("");
        }
    }

}
