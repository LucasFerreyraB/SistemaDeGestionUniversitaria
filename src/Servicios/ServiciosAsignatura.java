package Servicios;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Carrera;

import java.util.ArrayList;
import java.util.List;

public class ServiciosAsignatura {
    private List<Asignatura> materiasAbogacia = new ArrayList<>();
    private List<Asignatura> materiasEscribania = new ArrayList<>();
    private List<Asignatura> materiasMedicina = new ArrayList<>();
    private List<Asignatura> materiasEnfermeria = new ArrayList<>();


    //en esta clase se crean las asignaturas de cada carrera
    // Carrera: Abogacía

    public ServiciosAsignatura() {
    Asignatura derechoCivilI = new Asignatura("Derecho Civil I", 60, 1);
    Asignatura derechoPenalI = new Asignatura("Derecho Penal I", 60, 1);
    Asignatura derechoAdministrativo = new Asignatura("Derecho Administrativo", 60, 2);
    Asignatura derechoLaboral = new Asignatura("Derecho Laboral", 60, 2);
    Asignatura derechoProcesal = new Asignatura("Derecho Procesal", 60, 3);
    Asignatura derechoConstitucional = new Asignatura("Derecho Constitucional", 60, 3);

    materiasAbogacia.add(derechoCivilI);
    materiasAbogacia.add(derechoPenalI);
    materiasAbogacia.add(derechoAdministrativo);
    materiasAbogacia.add(derechoLaboral);
    materiasAbogacia.add(derechoProcesal);
    materiasAbogacia.add(derechoConstitucional);


    // Carrera: Escribanía
    Asignatura derechoNotarialI = new Asignatura("Derecho Notarial I", 60, 1);
    Asignatura derechoRegistralI = new Asignatura("Derecho Registral I", 60, 1);
    Asignatura derechoNotarialII = new Asignatura("Derecho Notarial II", 60, 2);
    Asignatura derechoRegistralII = new Asignatura("Derecho Registral II", 60, 2);
    Asignatura actosNotariales = new Asignatura("Actos Notariales", 60, 3);
    Asignatura derechoCivilEscribania = new Asignatura("Derecho Civil", 60, 3);

    materiasEscribania.add(derechoNotarialI);
    materiasEscribania.add(derechoRegistralI);
    materiasEscribania.add(derechoNotarialII);
    materiasEscribania.add(derechoRegistralII);
    materiasEscribania.add(actosNotariales);
    materiasEscribania.add(derechoCivilEscribania);


    // Carrera: Medicina
    Asignatura anatomiaHumanaI = new Asignatura("Anatomía Humana I", 90, 1);
    Asignatura bioquimicaMedica = new Asignatura("Bioquímica Médica", 60, 1);
    Asignatura fisiologiaHumana = new Asignatura("Fisiología Humana", 90, 2);
    Asignatura histologiaEmbriologia = new Asignatura("Histología y Embriología", 60, 2);
    Asignatura patologiaGeneral = new Asignatura("Patología General", 90, 3);
    Asignatura farmacologia = new Asignatura("Farmacología", 60, 3);

    materiasMedicina.add(anatomiaHumanaI);
    materiasMedicina.add(bioquimicaMedica);
    materiasMedicina.add(fisiologiaHumana);
    materiasMedicina.add(histologiaEmbriologia);
    materiasMedicina.add(patologiaGeneral);
    materiasMedicina.add(farmacologia);

    // Carrera: Enfermería
    Asignatura anatomiaFisiologiaHumana = new Asignatura("Anatomía y Fisiología Humana", 90, 1);
    Asignatura fundamentosEnfermeria = new Asignatura("Fundamentos de Enfermería", 60, 1);
    Asignatura cuidadosBasicosEnfermeria = new Asignatura("Cuidados Básicos de Enfermería", 90, 2);
    Asignatura farmacologiaEnfermeria = new Asignatura("Farmacología Aplicada a Enfermería", 60, 2);
    Asignatura enfermeriaMaternoInfantil = new Asignatura("Enfermería Materno-Infantil", 90, 3);
    Asignatura enfermeriaGeriatrica = new Asignatura("Enfermería Geriátrica", 60, 3);

    materiasEnfermeria.add(anatomiaFisiologiaHumana);
    materiasEnfermeria.add(fundamentosEnfermeria);
    materiasEnfermeria.add(cuidadosBasicosEnfermeria);
    materiasEnfermeria.add(farmacologiaEnfermeria);
    materiasEnfermeria.add(enfermeriaMaternoInfantil);
    materiasEnfermeria.add(enfermeriaGeriatrica);

}

    public List<Asignatura> getMateriasAbogacia() {
        return materiasAbogacia;
    }

    public void setMateriasAbogacia(List<Asignatura> materiasAbogacia) {
        this.materiasAbogacia = materiasAbogacia;
    }

    public List<Asignatura> getMateriasEscribania() {
        return materiasEscribania;
    }

    public void setMateriasEscribania(List<Asignatura> materiasEscribania) {
        this.materiasEscribania = materiasEscribania;
    }

    public List<Asignatura> getMateriasMedicina() {
        return materiasMedicina;
    }

    public void setMateriasMedicina(List<Asignatura> materiasMedicina) {
        this.materiasMedicina = materiasMedicina;
    }

    public List<Asignatura> getMateriasEnfermeria() {
        return materiasEnfermeria;
    }

    public void setMateriasEnfermeria(List<Asignatura> materiasEnfermeria) {
        this.materiasEnfermeria = materiasEnfermeria;
    }

    public List<Asignatura> obtenerAsignaturasDisponibles(int cuatrimestre, Alumno alumno) {
        // Obtener la carrera actual del alumno
        Carrera carreraActual = alumno.getMatricula().getCarrerasEnCurso().get(0);
        List<Asignatura> asignaturasDisponibles = new ArrayList<>();

        // Agregar solo las asignaturas del cuatrimestre especificado y de la carrera actual
        asignaturasDisponibles.addAll(obtenerAsignaturasPorCuatrimestre(carreraActual.getPlanDeEstudios().getListadoDeMaterias(), cuatrimestre));

        return asignaturasDisponibles;
    }

    // Método auxiliar para obtener las asignaturas de una lista correspondientes a un cuatrimestre
    private List<Asignatura> obtenerAsignaturasPorCuatrimestre(List<Asignatura> asignaturas, int cuatrimestre) {
        List<Asignatura> asignaturasPorCuatrimestre = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCuatrimestre() == cuatrimestre) {
                asignaturasPorCuatrimestre.add(asignatura);
            }
        }
        return asignaturasPorCuatrimestre;
    }
}

