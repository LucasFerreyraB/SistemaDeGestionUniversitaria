package Entidades;

import java.util.List;

public class Profesor extends Persona{
    private String departamento;
    private List<Asignatura> asignaturasImpartidas;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Asignatura> getAsignaturasImpartidas() {
        return asignaturasImpartidas;
    }

    public void setAsignaturasImpartidas(List<Asignatura> asignaturasImpartidas) {
        this.asignaturasImpartidas = asignaturasImpartidas;
    }
}
