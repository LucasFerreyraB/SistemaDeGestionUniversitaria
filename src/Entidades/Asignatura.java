package Entidades;

public class Asignatura {
    private String nombre;
    private int horasCatedra;
    private int cuatrimestre;

    public Asignatura(String nombre, int horasCatedra, int cuatrimestre) {
        this.nombre = nombre;
        this.horasCatedra = horasCatedra;
        this.cuatrimestre = cuatrimestre;}

        public String getNombre () {
            return nombre;
        }

        public void setNombre (String nombre){
            this.nombre = nombre;
        }

        public int getHorasCatedra () {
            return horasCatedra;
        }

        public void setHorasCatedra ( int horasCatedra){
            this.horasCatedra = horasCatedra;
        }

        public int getCuatrimestre () {
            return cuatrimestre;
        }

        public void setCuatrimestre ( int cuatrimestre){
            this.cuatrimestre = cuatrimestre;
        }

    }

