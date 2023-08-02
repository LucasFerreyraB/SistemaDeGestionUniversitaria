package Entidades;

public class Usuario {
    private String user;
    private String pass;
    private Alumno alumno;
    private Profesor profesor;



    public boolean esEstudiante() {
        return alumno != null;
    }

    public boolean esProfesor() {
        return profesor != null;
    }


    public Usuario() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
