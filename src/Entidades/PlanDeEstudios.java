package Entidades;

import java.util.ArrayList;
import java.util.List;

public class PlanDeEstudios {
    private String nombre;
    private List<Asignatura> listadoDeMaterias ;
    private int duracion;

    public PlanDeEstudios(String nombre, List<Asignatura> listadoDeMaterias, int duracion) {
        this.nombre = nombre;
        this.listadoDeMaterias = listadoDeMaterias;
        this.duracion = duracion;
    }

    public PlanDeEstudios() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura> getListadoDeMaterias() {
        return listadoDeMaterias;
    }

    public void setListadoDeMaterias(List<Asignatura> listadoDeMaterias) {
        this.listadoDeMaterias = new ArrayList<>();
    }

    public int getDuracion() {
        return duracion;
    }
}
