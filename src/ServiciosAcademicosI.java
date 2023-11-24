public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException;
    void agregarCurso(Curso curso) throws CursoYaExistenteException;
    void inscribirEstudianteEnCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteDeCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
