public class Main {
    public static void main(String[] args) {
        // Crear instancias de Estudiante y Curso
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", "01/01/2000", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Maria", "Lopez", "02/02/2001", "matriculado");

        Curso curso1 = new Curso(101, "Programación Java", "Curso introductorio de Java", 3, "1.0");
        Curso curso2 = new Curso(102, "Base de Datos", "Curso de bases de datos", 4, "2.0");

        // Instanciar GestorAcademico
        GestorAcademico gestor = new GestorAcademico();

        try {
            // Probar la inscripción de estudiantes
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            // Probar la creación de cursos
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            // Probar la inscripción de estudiantes en cursos
            gestor.inscribirEstudianteEnCurso(estudiante1, 101);
            gestor.inscribirEstudianteEnCurso(estudiante2, 101);
            gestor.inscribirEstudianteEnCurso(estudiante1, 102);

            // Probar la desinscripción de estudiantes de cursos
            gestor.desinscribirEstudianteDeCurso(1, 101);

            // Imprimir información para verificar el funcionamiento
            System.out.println("Lista de estudiantes matriculados: " + gestor.getListaEstudiantes().toString());
            System.out.println("Lista de cursos disponibles: " + gestor.getListaCursos());
            System.out.println("Estudiantes inscritos en cada curso: " + gestor.getEstudiantesPorCurso().toString());
        } catch (EstudianteYaInscritoException | CursoYaExistenteException | EstudianteNoInscritoEnCursoException e) {
            e.printStackTrace();
        }
    }
}
