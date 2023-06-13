/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolacion;

/**
 *
 * @author Antonio Luis Caballero Sosa
 * Técnico Superior de Desarrollo Multiplataforma
 */
import java.lang.Math;

public class NewClass {

    /**
     * @param args the command line arguments
     */
    //valor inicial para el cálculo del tamaño del vector árbol
    int n = 7;
    //valor del tamaño del vector de suma de ceros o huecos
    int m = 8;

    //cálculo del tamaño del vector que va a representar el árbol
    int calculo = (2 * n) + 1;

    int[] vector_pozo = new int[calculo];

    int[] vector = new int[m];

    //definir correctamente esta matriz
    //matriz de caminos para detectar la percolaciòn
    int[][] matriz_caminos = {{0, 1, 3, 7}, {0, 1, 4, 9}, {0, 1, 3, 8}, {0, 1, 4, 10}, {0, 2, 6, 14}, {0, 2, 7, 11}, {0, 2, 5, 12}, {0, 2, 6, 13}};

    //vector plantilla de vuelco de los datos de vector_pozo
    int[][] vector_suma = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};

    NewClass() {
    }

//rellenar vector con ceros
    void paso_primero() {
        for (int c = 0; c < vector_pozo.length; c++) {

            vector_pozo[c] = 0;

        }

        for (int c = 0; c < vector_pozo.length; c++) {

            System.out.print("  Vector_pozo_inicial: " + vector_pozo[c]);

        }
    }

    // rellenar vector con ceros, unos y does
    void paso_segundo() {
        System.out.println("***********************************************");
        for (int c = 0; c < vector_pozo.length; c++) {

            vector_pozo[c] = (int) (Math.random() * 3 + 0);

        }
        for (int c = 0; c < vector_pozo.length; c++) {

            System.out.print(" vector_pozo_aleatorio: " + vector_pozo[c]);

        }
    }

    // abrir si elemento es 1 y ponerlo a 0
    void paso_tercero() {
        for (int c = 0; c < vector_pozo.length; c++) {

            if (isopen(c)) {
                open(c);
            }

        }
    }

    //leer los caminos del árbol que están a ceros
    void paso_cuarto() {
        //int dato=0;
        for (int f = 0; f < matriz_caminos.length; f++) {

            for (int c = 0; c < matriz_caminos[f].length; c++) {

                System.out.println("fila: " + f + " columna: " + c);
           
                System.out.println("completo vector pozo: " + vector_pozo[matriz_caminos[f][c]]);
                if ((vector_pozo[matriz_caminos[f][c]]) == 0) {
                    vector_suma[f][c] = vector_pozo[matriz_caminos[f][c]];
                }
            }
        }
    }

    //leer el vector suma según se ha dado los caminos
    void paso_quinto() {
        for (int f = 0; f < vector_suma.length; f++) {
            for (int c = 0; c < vector_suma[f].length; c++) {
                System.out.println("fila: " + f + " Columna: " + c + " Resultados: " + vector_suma[f][c]);
            }

        }
    }

    //poner en vector los datos sumados para verificar que hay percolación
    void paso_sexto() {
        int dat = 0;
        for (int f = 0; f < vector_suma.length; f++) {
            for (int c = 0; c < vector_suma[f].length; c++) {
                System.out.println("fila: " + f + " Columna: " + c + " Resultados2: " + vector_suma[f][c]);
                dat += vector_suma[f][c];
            }
            vector[f] = dat;
            dat = 0;

        }
    }

    //visualizar los datos del vector para ver los valores sumados a cero
    void paso_septimo() {
        for (int f = 0; f < vector.length; f++) {

            System.out.println("casilla: " + f + " información: " + vector[f]);

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        NewClass percolacion = new NewClass();
        percolacion.paso_primero();
        percolacion.paso_segundo();
        percolacion.paso_tercero();
        percolacion.paso_cuarto();
        percolacion.paso_quinto();
        percolacion.paso_sexto();
        percolacion.paso_septimo();

    }

    boolean isopen(int c) {

        if (vector_pozo[c] == 1) {
            return true;
        } else {
            return false;
        }

    }

    void open(int c) {
        vector_pozo[c] = 0;
    }
}
