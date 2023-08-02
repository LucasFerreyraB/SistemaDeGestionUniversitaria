package Servicios;

import Entidades.Asignatura;
import Entidades.Carrera;
import Servicios.ServiciosPlanDeEstudios;

import java.util.ArrayList;
import java.util.List;

public class ServiciosCarrera {
    ServiciosPlanDeEstudios plan = new ServiciosPlanDeEstudios();
    private List<Carrera> listaDeCarreras = new ArrayList<>();
    public ServiciosCarrera() {
        Carrera abogacia = new Carrera("Abogacia","Capital", plan.getPlanAbogacia());
        Carrera medicina = new Carrera("Medicina","Interior",plan.getPlanMedicina());
        Carrera enfermeria = new Carrera ("Enfermeria","Interior",plan.getPlanEnfermeria());
        Carrera escribania = new Carrera ("Escribania","Capital",plan.getPlanEscribania());
        listaDeCarreras.add(abogacia);
        listaDeCarreras.add(medicina);
        listaDeCarreras.add(enfermeria);
        listaDeCarreras.add(escribania);

    }

    public List<Carrera> getListaDeCarreras() {
        return listaDeCarreras;
    }
}

