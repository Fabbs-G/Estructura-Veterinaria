/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

/**
 *
 * @author Eddier
 */
    public class Nodo {
        String nombreMascota;
        Nodo izquierdo, derecho;

        public Nodo(String nombreMascota) {
            this.nombreMascota = nombreMascota;
            izquierdo = derecho = null;
        }
    }
    

