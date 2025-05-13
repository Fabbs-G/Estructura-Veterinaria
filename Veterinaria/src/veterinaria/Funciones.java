/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eddier
 */
public class Funciones {
    private JTextArea txtArea;
    private ListaEnlazadaTratamiento tratamientos;
    private Cola cola;
    private ArbolBinario arbolBinario;
    private List<Mascota> listaMascotas;

    public Funciones(JTextArea txtArea) {
        this.txtArea = txtArea;
        this.tratamientos = new ListaEnlazadaTratamiento();
        this.cola = new Cola();
        this.arbolBinario = new ArbolBinario();
        this.listaMascotas = new ArrayList<>();
        
    }
 
   public void agregarTratamiento() {
        try {
            String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del tratamiento:");
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha del tratamiento (dd/MM/yyyy):");

            if (nombreMascota == null || nombreMascota.trim().isEmpty() || descripcion == null || descripcion.trim().isEmpty() || fecha == null || fecha.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los datos del tratamiento no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Tratamiento tratamiento = new Tratamiento(nombreMascota, descripcion, fecha);
            tratamientos.agregarTratamiento(tratamiento);
            JOptionPane.showMessageDialog(null, "Tratamiento agregado exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el tratamiento. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarTratamiento() {
        try {
            String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota cuyo tratamiento desea modificar:");
            if (nombreMascota == null || nombreMascota.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre de la mascota no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del tratamiento:");
            String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha del tratamiento (dd/MM/yyyy):");

            if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty() || nuevaFecha == null || nuevaFecha.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los datos nuevos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean modificado = tratamientos.modificarTratamiento(nombreMascota, nuevaDescripcion, nuevaFecha);
            if (modificado) {
                JOptionPane.showMessageDialog(null, "Tratamiento modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un tratamiento para la mascota especificada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el tratamiento. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarTratamientos() {
        txtArea.setText("Historial de Tratamientos:\n");
        tratamientos.mostrarTratamientos(txtArea);
    }
    
    public void buscarTratamiento() {
    String criterio = JOptionPane.showInputDialog("Ingrese el nombre de la mascota o la descripción del tratamiento a buscar:");
    if (criterio == null || criterio.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El criterio de búsqueda no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    Tratamiento tratamiento = tratamientos.buscarTratamiento(criterio);
    if (tratamiento != null) {
        JOptionPane.showMessageDialog(null, "Tratamiento encontrado:\n" + tratamiento.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró ningún tratamiento con ese criterio.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

    public void agregarMascota() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,"El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));

            int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de la última vacunación:"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la última vacunación:"));
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de la última vacunación:"));

            int intervalo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el intervalo de vacunación en meses:"));
            int limite = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de próximas fechas a calcular:"));

            // Crear la mascota y agregar al árbol
            Mascota mascota = new Mascota(nombre, especie, edad, dia, mes, anio, intervalo, limite);
            listaMascotas.add(mascota);
            arbolBinario.agregar(mascota.getNombre());

            JOptionPane.showMessageDialog(null, "Mascota agregada exitosamente: " + nombre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarArbolBinario() {
        txtArea.setText("Mascotas ordenadas (Árbol Binario - InOrden):\n");
        arbolBinario.inOrden(txtArea);
    }

    public void mostrarMascotas() {
        txtArea.setText("Listado de Mascotas y Próximas Vacunas:\n");
        for (Mascota mascota : listaMascotas) {
            txtArea.append("\nMascota: " + mascota.getNombre() + "\n");
            txtArea.append("Especie: " + mascota.getEspecie() + "\n");
            txtArea.append("Edad: " + mascota.getEdad() + " años\n");
            txtArea.append("Próximas fechas de vacunación:\n");

            StringBuilder resultado = new StringBuilder();
            calcularProximasVacunasConResultado(
                    mascota.getDiaUltimaVacunacion(),
                    mascota.getMesUltimaVacunacion(),
                    mascota.getAnioUltimaVacunacion(),
                    mascota.getProximasFechasVacunacion(),
                    mascota.getIntervaloVacunacionMeses(),
                    resultado
            );
            txtArea.append(resultado.toString() + "\n");
        }
    }


    public void agregarCola() {
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota para la cita:");
        String cita = JOptionPane.showInputDialog("Ingrese los detalles de la cita:");
        if (nombreMascota != null && !nombreMascota.trim().isEmpty() && cita != null && !cita.trim().isEmpty()) {
            cola.encolar(nombreMascota, cita);
            JOptionPane.showMessageDialog(null, "Cita agregada para la mascota: " + nombreMascota);
        } else {
            JOptionPane.showMessageDialog(null, "Los datos de la cita no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarCola() {
        txtArea.setText("Citas en la Cola:\n");
        cola.mostrar(txtArea);
    }

    public void desencolar() {
        String desencolado = cola.desencolar();
        if (desencolado != null) {
            JOptionPane.showMessageDialog(null, "Se atendió la cita: " + desencolado);
        } else {
            JOptionPane.showMessageDialog(null, "La cola está vacía.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void calcularProximasVacunasConResultado(int dia, int mes, int anio, int limite, int intervalo, StringBuilder resultado) {
        if (limite == 0) {
            return;
        }

        mes += intervalo;
        while (mes > 12) {
            mes -= 12;
            anio++;
        }

        resultado.append(String.format("%02d/%02d/%04d\n", dia, mes, anio));
        calcularProximasVacunasConResultado(dia, mes, anio, limite - 1, intervalo, resultado);
    }
}

