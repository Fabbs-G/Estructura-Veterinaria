/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;
import javax.swing.JTextArea;

public class ArbolBinario {
    private Nodo raiz;

    public void agregar(String nombreMascota) {
        raiz = agregarRecursivo(raiz, nombreMascota);
    }

    private Nodo agregarRecursivo(Nodo actual, String nombreMascota) {
        if (actual == null) {
            return new Nodo(nombreMascota);
        }
        if (nombreMascota.compareTo(actual.nombreMascota) < 0) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, nombreMascota);
        } else if (nombreMascota.compareTo(actual.nombreMascota) > 0) {
            actual.derecho = agregarRecursivo(actual.derecho, nombreMascota);
        }
        return actual;
    }

    public void inOrden(JTextArea txtArea) {
        inOrdenRecursivo(raiz, txtArea);
    }

    private void inOrdenRecursivo(Nodo nodo, JTextArea txtArea) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo, txtArea);
            txtArea.append(nodo.nombreMascota + "\n");
            inOrdenRecursivo(nodo.derecho, txtArea);
        }
    }
}
