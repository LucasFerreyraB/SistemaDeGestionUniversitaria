package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private static int nroMatriculaActual = 1000;
    private Alumno alumnoMatriculado;
    private int nroMatricula;
    private List<Carrera> carrerasEnCurso;
    private List<Asignatura> asignaturasEnCurso;
    private List<AsignaturaCursada> asignaturasCursadas;
    private List<Tramites> tramites;
    private boolean estado;
    private int cuatrimestreActual;

    public Matricula() {
        this.tramites = new ArrayList<>();
        this.carrerasEnCurso = new ArrayList<>();
    }

    public Alumno getAlumnoMatriculado() {
        return alumnoMatriculado;
    }

    public void setAlumnoMatriculado(Alumno alumnoMatriculado) {
        this.alumnoMatriculado = alumnoMatriculado;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public List<Carrera> getCarrerasEnCurso() {
        return carrerasEnCurso;
    }

    public void setCarrerasEnCurso(List<Carrera> carrerasEnCurso) {
        this.carrerasEnCurso = carrerasEnCurso;
    }

    public List<Asignatura> getAsignaturasEnCurso() {
        return asignaturasEnCurso;
    }

    public void setAsignaturasEnCurso(List<Asignatura> asignaturasEnCurso) {
        this.asignaturasEnCurso = asignaturasEnCurso;
    }

    public List<AsignaturaCursada> getAsignaturasCursadas() {
        return asignaturasCursadas;
    }

    public void setAsignaturasCursadas(List<AsignaturaCursada> asignaturasCursadas) {
        this.asignaturasCursadas = asignaturasCursadas;
    }

    public List<Tramites> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramites> tramites) {
        this.tramites = tramites;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int generarNumeroMatriculaUnico() {
        return nroMatriculaActual++;
    }



    public int getCuatrimestreActual() {
        return cuatrimestreActual;
    }

    public void setCuatrimestreActual(int cuatrimestreActual) {
        this.cuatrimestreActual = cuatrimestreActual;
    }
}
