package Servicios;

import Entidades.Alumno;
import Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiciosUsuario {
    ServiciosAlumno sa = new ServiciosAlumno();
    private List<Usuario> usuarios = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public Usuario crearUsuario() {
        Usuario nuevoUsuario = new Usuario();

        System.out.println("Ingrese su nombre de usuario");
        String nuevoNombreUsuario = sc.nextLine();

        while (usuarioExiste(nuevoNombreUsuario)) {
            System.out.println("El nombre de usuario ya existe. Ingrese otro nombre de usuario:");
            nuevoNombreUsuario = sc.nextLine();
        }

        nuevoUsuario.setUser(nuevoNombreUsuario);

        // Validar la contraseña ingresada y repetir hasta que coincidan
        String contrasena1, contrasena2;
        do {
            System.out.println("Ingrese su contraseña");
            contrasena1 = sc.nextLine();
            System.out.println("Repita su contraseña");
            contrasena2 = sc.nextLine();

            if (!contrasena1.equals(contrasena2)) {
                System.out.println("Error: las contraseñas deben coincidir.");
            }
        } while (!contrasena1.equals(contrasena2));

        nuevoUsuario.setPass(contrasena1);

        System.out.println("¿Es usted estudiante o profesor? (e/p)");
        String tipoUsuario = sc.nextLine();

        if (tipoUsuario.equalsIgnoreCase("e")) {
            // Registro como estudiante
            Alumno alumno = sa.crearAlumno();
            nuevoUsuario.setAlumno(alumno); // Asocia el objeto alumno al usuario registrado
        } else if (tipoUsuario.equalsIgnoreCase("p")) {
            // Registro como profesor
         //------   Profesor profesor = serviciosProfesor.crearProfesor();
          //-------  nuevoUsuario.setProfesor(profesor); // Asocia el objeto profesor al usuario registrado
        } else {
            System.out.println("Opción no válida.");
        }

        // Agregar el nuevo usuario a la lista de usuarios
        usuarios.add(nuevoUsuario);

        return nuevoUsuario;
    }
    // Método para verificar si ya existe un usuario con el mismo nombre
    private boolean usuarioExiste(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    public Usuario loguearUsuario() {
        System.out.println("Ingrese su nombre de usuario");
        String usuario = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        String contrasena = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getUser().equals(usuario) && u.getPass().equals(contrasena)) {
                return u;
            }
        }

        return null;
    }
}