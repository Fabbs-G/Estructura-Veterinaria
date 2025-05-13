package veterinaria;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private int diaUltimaVacunacion;
    private int mesUltimaVacunacion;
    private int anioUltimaVacunacion;
    private int intervaloVacunacionMeses;
    private int proximasFechasVacunacion;

    public Mascota(String nombre, String especie, int edad, int dia, int mes, int anio, int intervaloVacunacionMeses, int proximasFechasVacunacion) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.diaUltimaVacunacion = dia;
        this.mesUltimaVacunacion = mes;
        this.anioUltimaVacunacion = anio;
        this.intervaloVacunacionMeses = intervaloVacunacionMeses;
        this.proximasFechasVacunacion = proximasFechasVacunacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDiaUltimaVacunacion() {
        return diaUltimaVacunacion;
    }

    public void setDiaUltimaVacunacion(int diaUltimaVacunacion) {
        this.diaUltimaVacunacion = diaUltimaVacunacion;
    }

    public int getMesUltimaVacunacion() {
        return mesUltimaVacunacion;
    }

    public void setMesUltimaVacunacion(int mesUltimaVacunacion) {
        this.mesUltimaVacunacion = mesUltimaVacunacion;
    }

    public int getAnioUltimaVacunacion() {
        return anioUltimaVacunacion;
    }

    public void setAnioUltimaVacunacion(int anioUltimaVacunacion) {
        this.anioUltimaVacunacion = anioUltimaVacunacion;
    }

    public int getIntervaloVacunacionMeses() {
        return intervaloVacunacionMeses;
    }

    public void setIntervaloVacunacionMeses(int intervaloVacunacionMeses) {
        this.intervaloVacunacionMeses = intervaloVacunacionMeses;
    }

    public int getProximasFechasVacunacion() {
        return proximasFechasVacunacion;
    }

    public void setProximasFechasVacunacion(int proximasFechasVacunacion) {
        this.proximasFechasVacunacion = proximasFechasVacunacion;
    }


}
