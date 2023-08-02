package Servicios;

import Entidades.Tramites;

import java.util.ArrayList;
import java.util.List;

public class ServiciosTramites {
    private static int contadorTramites = 00000;
    // Lista para almacenar los trámites
    private List<Tramites> listaDeTramites;

    public ServiciosTramites() {
        listaDeTramites = new ArrayList<>();
    }

    // Método para agregar un nuevo trámite y generar el número de trámite único
    public void agregarTramite(Tramites tramite) {
        tramite.setNro(generarNumeroTramiteUnico());
        listaDeTramites.add(tramite);
    }

    // Método para buscar un trámite por su número
    public Tramites buscarTramitePorNumero(int numeroTramite) {
        for (Tramites tramite : listaDeTramites) {
            if (tramite.getNro() == numeroTramite) {
                return tramite;
            }
        }
        return null; // Si no se encuentra el trámite, se devuelve null
    }

    // Método para actualizar el estado de un trámite
    public void actualizarEstadoTramite(int numeroTramite, boolean nuevoEstado) {
        Tramites tramite = buscarTramitePorNumero(numeroTramite);
        if (tramite != null) {
            tramite.setEstado(nuevoEstado);
        } else {
            System.out.println("El trámite con número " + numeroTramite + " no existe.");
        }
    }

    // Método para generar un número de trámite único
    public int generarNumeroTramiteUnico() {
        contadorTramites++;
        return contadorTramites;
    }

    // Otros métodos relacionados con trámites, si los necesitas

    // Getter para obtener la lista de trámites (si necesitas mostrarla o trabajar con ella desde fuera de la clase)
    public List<Tramites> getListaDeTramites() {
        return listaDeTramites;
    }
}