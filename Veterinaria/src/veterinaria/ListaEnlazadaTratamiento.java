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

class NodoTratamiento {
    Tratamiento tratamiento;
    NodoTratamiento siguiente;

    public NodoTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
        this.siguiente = null;
    }
}

public class ListaEnlazadaTratamiento {
    private NodoTratamiento cabeza;

    public void agregarTratamiento(Tratamiento tratamiento) {
        NodoTratamiento nuevo = new NodoTratamiento(tratamiento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoTratamiento temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    public void mostrarTratamientos(JTextArea txtArea) {
        NodoTratamiento temp = cabeza;
        if (temp == null) {
            txtArea.append("No hay tratamientos registrados.\n");
        } else {
            while (temp != null) {
                txtArea.append(temp.tratamiento.toString() + "\n");
                temp = temp.siguiente;
            }
        }
    }

    public Tratamiento buscarTratamiento(String nombreMascota) {
        NodoTratamiento temp = cabeza;
        while (temp != null) {
            if (temp.tratamiento.getNombreMascota().equalsIgnoreCase(nombreMascota)) {
                return temp.tratamiento;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    public boolean modificarTratamiento(String nombreMascota, String nuevaDescripcion, String nuevaFecha) {
        Tratamiento tratamiento = buscarTratamiento(nombreMascota);
        if (tratamiento != null) {
            tratamiento.setDescripcion(nuevaDescripcion);
            tratamiento.setFecha(nuevaFecha);
            return true;
        }
        return false;
    }
}