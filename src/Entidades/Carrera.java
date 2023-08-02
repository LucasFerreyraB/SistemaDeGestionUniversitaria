package Entidades;

import java.util.List;

public class Carrera {
    private String nombre;
    private String sede;
    private PlanDeEstudios planDeEstudios;

    public Carrera(String nombre, String sede, PlanDeEstudios planDeEstudios) {
        this.nombre = nombre;
        this.sede = sede;
        this.planDeEstudios = planDeEstudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public PlanDeEstudios getPlanDeEstudios() {
        return planDeEstudios;
    }

    public void setPlanDeEstudios(PlanDeEstudios planDeEstudios) {

    }

}
