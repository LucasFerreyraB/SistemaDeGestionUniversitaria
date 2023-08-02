package Servicios;

import Entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiciosAlumno {
    ServiciosCarrera carrera = new ServiciosCarrera();
    AsignaturaCursada asignatura = new AsignaturaCursada();
    ServiciosTramites tramites = new ServiciosTramites();
    Scanner sc = new Scanner(System.in);
    public Alumno crearAlumno() {//metodo necesario para crear nuestro alumno
        Alumno alumno = new Alumno();
        Matricula m = new Matricula();
        System.out.println("Ingrese el nombre del alumno");
        alumno.setNombre(sc.nextLine());
        System.out.println("Ingrese apellido del alumno");
        alumno.setApellido(sc.nextLine());
        System.out.println("Ingrese DNI del alumno");
        alumno.setDni(sc.nextLine());
        System.out.println("Ingrese edad del alumno");
        alumno.setEdad(sc.nextInt());
        System.out.println("Ingrese direccion del alumno");
        alumno.setDireccion(sc.nextLine());
        alumno.setMatricula(m);
        //System.out.println("La matricula del alumno es " + m.getNroMatricula());

        return alumno;
    }

    public void mostrarMenuEstudiante(Alumno alumno) {
        System.out.println("¡Bienvenido(a), " + alumno.getNombre() + " " + alumno.getApellido() + "!");
        System.out.println("Número de matrícula: " + alumno.getMatricula().getNroMatricula());

        List<Carrera> carrerasEnCurso = alumno.getMatricula().getCarrerasEnCurso();
        if (!carrerasEnCurso.isEmpty()) {
            System.out.println("Carrera en curso: " + carrerasEnCurso.get(0).getNombre());
        } else {
            System.out.println("Aún no estás inscripto en ninguna carrera.");
        }

        int opcion;
        do {
            System.out.println("\n--- Menú Estudiante ---");
            System.out.println("1. Iniciar trámite");
            System.out.println("2. Consultar estado de trámite");
            System.out.println("3. Consultar historial académico");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    iniciarTramite(alumno);
                    break;
                case 2:
                    consultarEstadoTramite();
                    break;
                case 3:
                    consultarHistorialAcademico(alumno.getMatricula().getNroMatricula());
                    break;
                case 4:
                    System.out.println("Saliendo del menú estudiante.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private void iniciarTramite(Alumno alumno) {
        int opcion;
        do {
            System.out.println("\n--- Iniciar Trámite ---");
            System.out.println("1. Darse de alta en una carrera");
            System.out.println("2. Darse de alta en una materia");
            System.out.println("3. Volver al menú estudiante");
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    darseDeAltaEnCarrera(alumno);
                    break;
                case 2:
                    darseDeAltaEnMateria(alumno);
                    break;
                case 3:
                    System.out.println("Volviendo al menú estudiante.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }



    private void darseDeAltaEnCarrera(Alumno alumno) {
        // Obtener lista de carreras desde ServiciosCarrera (si no lo has hecho ya)
        List<Carrera> listaDeCarreras = carrera.getListaDeCarreras();

        // Mostrar lista de carreras disponibles para que el estudiante elija una
        System.out.println("La lista de carreras disponibles es:");
        int index = 1;
        for (Carrera carrera : listaDeCarreras) {
            System.out.println(index++ + ". " + carrera.getNombre());
        }

        // Leer la opción seleccionada por el estudiante
        System.out.print("Ingrese el número de la carrera en la que desea inscribirse: ");
        int opcionCarrera = sc.nextInt();

        // Verificar si la opción ingresada es válida y agregar la carrera elegida
        String mensajeExito = "";
        if (opcionCarrera >= 1 && opcionCarrera <= listaDeCarreras.size()) {
            // Agregar la carrera elegida a la lista de carrerasEnCurso en el objeto Matricula del alumno
            Carrera carreraElegida = listaDeCarreras.get(opcionCarrera - 1);
            alumno.getMatricula().getCarrerasEnCurso().add(carreraElegida);

            // Generar un número de trámite único y asignarlo al objeto Tramite
            int numeroTramite = tramites.generarNumeroTramiteUnico();
            Tramites tramite = new Tramites(numeroTramite, true);
            alumno.getMatricula().getTramites().add(tramite);

            // Mostrar el plan de estudios de la carrera
            ServiciosPlanDeEstudios serviciosPlanDeEstudios = new ServiciosPlanDeEstudios();
            serviciosPlanDeEstudios.mostrarPlan(carreraElegida.getPlanDeEstudios(), carreraElegida);

            // Pedir confirmación al estudiante
            System.out.print("¿Desea confirmar la inscripción en esta carrera? (s/n): ");
            String confirmacion = sc.next();
            if (confirmacion.equalsIgnoreCase("s")) {
                mensajeExito = "¡Inscripción exitosa en la carrera " + carreraElegida.getNombre() + "!";
            } else {
                // Cambiar el estado del trámite a "cancelado"
                tramite.setEstado(false);
                mensajeExito = "Inscripción cancelada. No se ha inscrito en la carrera.";
            }
            System.out.println("Número de trámite: " + numeroTramite);
        } else {
            mensajeExito = "Opción no válida. Intente nuevamente.";
        }

        // Mostrar mensaje de éxito o error
        System.out.println(mensajeExito);

        System.out.println("\nPresione Enter para volver al Menú Estudiante...");
        sc.nextLine(); // Consumir el salto de línea pendiente
        sc.nextLine(); // Esperar a que el estudiante presione Enter

        return;
    }

    private void darseDeAltaEnMateria(Alumno alumno) {
        int intentos = 3;
        while (intentos > 0) {
            // Obtener número de matrícula del alumno
            System.out.print("Ingrese su número de matrícula (" + intentos + " intentos restantes): ");
            int numeroMatricula = sc.nextInt();

            // Verificar si el número de matrícula ingresado es válido
            if (alumno.getMatricula().getNroMatricula() == numeroMatricula) {
                // Leer el número de cuatrimestre actual si aún no ha sido establecido
                if (alumno.getMatricula().getCuatrimestreActual() == 0) {
                    System.out.print("Ingrese el número de cuatrimestre actual: ");
                    int cuatrimestreActual = sc.nextInt();
                    alumno.getMatricula().setCuatrimestreActual(cuatrimestreActual);
                }

                // Obtener cuatrimestre actual
                int cuatrimestreActual = alumno.getMatricula().getCuatrimestreActual();

                // Obtener asignaturas disponibles para el cuatrimestre actual
                ServiciosAsignatura serviciosAsignatura = new ServiciosAsignatura();
                List<Asignatura> asignaturasDisponibles = serviciosAsignatura.obtenerAsignaturasDisponibles(cuatrimestreActual, alumno);

                // Mostrar la lista de asignaturas disponibles para el cuatrimestre actual
                System.out.println("Asignaturas disponibles para el cuatrimestre " + cuatrimestreActual + ":");
                int index = 1;
                for (Asignatura asignatura : asignaturasDisponibles) {
                    System.out.println(index++ + ". " + asignatura.getNombre());
                }

                // Permitir al estudiante elegir una asignatura
                System.out.print("Ingrese el número de la asignatura en la que desea inscribirse: ");
                int opcionAsignatura = sc.nextInt();

                // Verificar si la opción ingresada es válida y crear el trámite correspondiente
                String mensajeExito = "";
                if (opcionAsignatura >= 1 && opcionAsignatura <= asignaturasDisponibles.size()) {
                    Asignatura asignaturaElegida = asignaturasDisponibles.get(opcionAsignatura - 1);

                    // Crear un nuevo objeto Tramite y asociarlo al alumno con el número de trámite generado automáticamente
                    int numeroTramite = tramites.generarNumeroTramiteUnico();
                    Tramites tramite = new Tramites(numeroTramite, true);
                    alumno.getMatricula().getTramites().add(tramite);

                    // Mostrar mensaje de éxito y el número de trámite generado
                    mensajeExito = "¡Inscripción exitosa en la asignatura " + asignaturaElegida.getNombre() + "!";
                    System.out.println("Número de trámite: " + numeroTramite);
                } else {
                    mensajeExito = "Opción no válida. Intente nuevamente.";
                }

                // Mostrar mensaje de éxito o error
                System.out.println(mensajeExito);
                return;
            } else {
                System.out.println("Número de matrícula incorrecto. Intente nuevamente.");
                intentos--;
            }
        }

        // Si se agotaron los intentos, mostrar mensaje de error y salir del sistema
        System.out.println("Ha superado el número máximo de intentos. Inténtelo nuevamente más tarde.");
        System.exit(0);
    }
    private void consultarEstadoTramite() {
        // Pedir al estudiante el número de trámite a consultar
        // Buscar el trámite por su número en la lista de trámites del alumno o en algún otro lugar donde los almacenes
        // Mostrar la descripción del trámite, si fue inscripción a una carrera o materia, y su estado (aprobado o no)
    }

    private void consultarHistorialAcademico(int nroMatricula) {
        // Pedir al estudiante el número de matrícula para buscar su historial académico
        // Buscar la matrícula por su número en la lista de matrículas de ServiciosAlumno o en algún otro lugar donde los almacenes
        // Mostrar el historial académico del alumno (lista de asignaturas cursadas con sus respectivas notas y estado)
    }
}
