package Main;

import Entidades.Alumno;
import Entidades.Profesor;
import Entidades.Usuario;
import Servicios.ServiciosAlumno;
import Servicios.ServiciosUsuario;

import java.util.Scanner;

public class Interfaz {
    private Scanner sc = new Scanner(System.in);
    private ServiciosUsuario serviciosUsuario = new ServiciosUsuario();
    private ServiciosAlumno serviciosAlumno = new ServiciosAlumno();
    private static final int MAX_INTENTOS_LOGIN = 3;

    public void mostrarMenuPrincipal() {
        int intentos = 0;
        while (intentos < MAX_INTENTOS_LOGIN) {
            System.out.println("¡Bienvenido(a) a la aplicación!");
            System.out.println("¿Es usted un usuario registrado? (s/n)");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                // Si es un usuario registrado
                Usuario usuario = serviciosUsuario.loguearUsuario();

                if (usuario != null) {
                    System.out.println("¡Bienvenido(a) de nuevo, " + usuario.getUser() + "!");

                    if (usuario.esEstudiante()) {
                        // Si es un estudiante registrado
                        Alumno alumno = usuario.getAlumno();
                        // Mostrar menú de estudiante
                        serviciosAlumno.mostrarMenuEstudiante(alumno);
                    } else if (usuario.esProfesor()) {
                        // Si es un profesor registrado
                        Profesor profesor = usuario.getProfesor();
                        // Mostrar menú de profesor
                        //mostrarMenuProfesor(profesor);
                    }
                    return; // Salimos del método si el inicio de sesión es exitoso
                } else {
                    intentos++;
                    System.out.println("Usuario o contraseña incorrectos. Intento " + intentos + " de " + MAX_INTENTOS_LOGIN);
                }
            } else if (respuesta.equalsIgnoreCase("n")) {
                // Si el usuario desea registrarse
                System.out.println("¡Bienvenido(a) al proceso de registro!");
                Usuario nuevoUsuario = serviciosUsuario.crearUsuario();

                if (nuevoUsuario.esEstudiante()) {
                    // Registro como estudiante
                    Alumno alumno = nuevoUsuario.getAlumno(); // Obtener el alumno asociado al nuevo usuario
                    System.out.println("¡Registro exitoso como estudiante!");
                    // Mostrar menú de estudiante
                    serviciosAlumno.mostrarMenuEstudiante(alumno);
                } else if (nuevoUsuario.esProfesor()) {
                    // Registro como profesor
                    // Profesor profesor = crearProfesor();
                    //nuevoUsuario.setProfesor(profesor); // Asocia el objeto profesor al usuario registrado

                    System.out.println("¡Registro exitoso como profesor!");
                    // Mostrar menú de profesor
                    //  mostrarMenuProfesor(profesor);
                } else {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }

        // Si se superan los tres intentos, mostramos el mensaje y terminamos la ejecución
        System.out.println("Por favor, inténtelo nuevamente más tarde.");
        System.exit(0);
    }
}