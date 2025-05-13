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
import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<String> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public void encolar(String nombreMascota, String cita) {
        cola.add("Mascota: " + nombreMascota + ", Cita: " + cita);
    }

    public String desencolar() {
        return cola.poll(); // Devuelve y elimina el primer elemento, o null si está vacía
    }

    public void mostrar(JTextArea txtArea) {
        if (cola.isEmpty()) {
            txtArea.append("La cola está vacía.\n");
        } else {
            for (String dato : cola) {
                txtArea.append(dato + "\n");
            }
        }
    }
}

