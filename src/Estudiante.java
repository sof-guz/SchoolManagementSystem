public class Estudiante extends Persona {
    private String estado;

    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, String estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Estudiante{id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' + ", estado='" + estado + '\'' + '}';
    }
}