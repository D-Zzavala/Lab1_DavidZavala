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
                    
                    String Jugador1 = JOptionPane.showInputDialog("Identificacion de Contrincante #1");
                    System.out.println("Mar de" + Jugador1);
                    Mar1 = FillMAt(Mar1, Size);
                    PrintMat(Mar1, Size);
                    
                    String Jugador2 = JOptionPane.showInputDialog("Identificacion de Contrincante #2");
                    System.out.println("Mar de" + Jugador2);
                    Mar2 = FillMAt(Mar2, Size);
                    PrintMat(Mar2, Size);
                    
                    boolean tf = true;
                    while (tf) {
                        //empiezan turnos
                        //jugador1
                        System.out.println(Jugador1+"ingrese las coordenadas a atacar");
                        JOptionPane.showInputDialog("Ingrese longitud:");
                        
                        //jugador2
                        System.out.println(Jugador1+"ingrese las coordenadas a atacar");
                        JOptionPane.showInputDialog("Ingrese longitud:");
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

    void Shots(char[][] Mat, int A, char B) {
        if (A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2 || A == 0 && B == 2) {

        } else {

        }
    }

    static char[][] FillMAt(char[][] Mat, int tam) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                int a = 65 + j;
                int b = 61 + i;
                if (i != 0 && j != 0) {
                    Mat[i][j] = ' ';
                } else if (i == 0 && j != 0) {
                    Mat[i][j] = (char) a;
                } else if (j == 0 && i != 0) {
                    Mat[i][j] = (char) a;
                }
            }
        }
        return Mat;
    }

    static void PrintMat(char matriz[][], int tam) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print("[" + matriz[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

}
