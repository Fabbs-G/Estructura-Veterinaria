
package veterinaria;
public class Tratamiento {
    private String descripcion;
    private String fecha;
    private String nombreMascota;

    public Tratamiento(String nombreMascota, String descripcion, String fecha) {
        this.nombreMascota = nombreMascota;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mascota: " + nombreMascota + ", Fecha: " + fecha + ", Descripción: " + descripcion;
    }
}
    

