/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

/**
 *
 * @author Eddier
 */

import javax.swing.JTextArea;

public class Grafo {
    private int n;
    private int mat[][];
    private String[] nombres;

    public Grafo(int n) {
        this.n = n;
        mat = new int[this.n][this.n];
        nombres = new String[this.n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }
    }

    public void asignarNombre(int nodo, String nombre) {
        nombres[nodo] = nombre;
    }

    public void agregar(int i, int j) {
        mat[i][j] = 1;
    }

    public void remover(int i, int j) {
        mat[i][j] = 0;
    }

    public void imprimir(JTextArea txtArea) {
        txtArea.setText("Matriz de Adyacencia:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txtArea.append(mat[i][j] + " ");
            }
            txtArea.append("\n");
        }
        txtArea.append("\nLugares (Nodos):\n");
        for (int i = 0; i < n; i++) {
            txtArea.append(i + " = " + nombres[i] + "\n");
        }
    }

    public void mostrarRutas(int origen, JTextArea txtArea) {
        txtArea.append("\nRutas desde el nodo " + nombres[origen] + ":\n");
        for (int destino = 0; destino < n; destino++) {
            if (mat[origen][destino] == 1) {
                txtArea.append("Ruta directa de " + nombres[origen] + " a " + nombres[destino] + "\n");
            }
        }
    }
}