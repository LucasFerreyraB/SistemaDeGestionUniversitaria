package Servicios;

import Entidades.Asignatura;
import Entidades.Carrera;
import Entidades.PlanDeEstudios;
import Servicios.ServiciosAsignatura;

import java.util.ArrayList;
import java.util.List;

public class ServiciosPlanDeEstudios {
    private PlanDeEstudios planAbogacia;
    private PlanDeEstudios planEscribania;
    private PlanDeEstudios planMedicina;
    private PlanDeEstudios planEnfermeria;

    ServiciosAsignatura as = new ServiciosAsignatura();
    public ServiciosPlanDeEstudios() {
        planAbogacia = new PlanDeEstudios("Plan de Estudios de abogacia",as.getMateriasAbogacia(),4);
        planEscribania = new PlanDeEstudios("Plan de Estudios de escribania",as.getMateriasEscribania(),4);
        planMedicina = new PlanDeEstudios("Plan de Estudios de Medicina",as.getMateriasMedicina(),4);
        planEnfermeria = new PlanDeEstudios("Plan de Estudios de enfermeria",as.getMateriasEnfermeria(),4);
    }

    public PlanDeEstudios getPlanAbogacia() {
        return planAbogacia;
    }

    public PlanDeEstudios getPlanEscribania() {
        return planEscribania;
    }

    public PlanDeEstudios getPlanMedicina() {
        return planMedicina;
    }

    public PlanDeEstudios getPlanEnfermeria() {
        return planEnfermeria;
    }

    public void mostrarPlan(PlanDeEstudios plan, Carrera carrera) {
        System.out.println("La sede de la carrera de " + carrera.getNombre() + " es: " + carrera.getSede());
        System.out.println("Duración total de la carrera: " + plan.getDuracion() + " cuatrimestres");
        System.out.println("Y su plan de estudios es:");

        // Obtener la lista de asignaturas del plan de estudios
        List<Asignatura> asignaturas = plan.getListadoDeMaterias();

        // Mostrar las asignaturas y detalles del plan de estudios
        for (Asignatura asignatura : asignaturas) {
            System.out.println("Asignatura: " + asignatura.getNombre());
            System.out.println("Cuatrimestre: " + asignatura.getCuatrimestre());

            System.out.println("--------");
        }
    }
}