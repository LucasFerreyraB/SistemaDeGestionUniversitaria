package Main;

import Servicios.ServiciosAlumno;
import Servicios.ServiciosPlanDeEstudios;
import Servicios.ServiciosProfesor;
import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Carrera;
import Entidades.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();

        interfaz.mostrarMenuPrincipal();
    }
}

