package model;

public class Concurso {
    private String nombre;
    private int idConcurso;
    private String fechaInicio;
    private String fechaFin;

    public Concurso(String nombre, int idConcurso, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.idConcurso = idConcurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }
}
