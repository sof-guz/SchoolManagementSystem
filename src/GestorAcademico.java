import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Curso> listaCursos;
    private HashMap<Curso, ArrayList<Estudiante>> estudiantesPorCurso;

    public GestorAcademico() {
        listaEstudiantes = new ArrayList<>();
        listaCursos = new ArrayList<>();
        estudiantesPorCurso = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        if (!listaEstudiantes.contains(estudiante)) {
            listaEstudiantes.add(estudiante);
        } else {
            throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) throws CursoYaExistenteException {
        if (!listaCursos.contains(curso)) {
            listaCursos.add(curso);
            estudiantesPorCurso.put(curso, new ArrayList<>());
        } else {
            throw new CursoYaExistenteException("El curso ya existe.");
        }
    }

    @Override
    public void inscribirEstudianteEnCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = buscarCursoPorId(idCurso);

        if (curso != null) {
            ArrayList<Estudiante> estudiantesInscritos = estudiantesPorCurso.get(curso);

            if (!estudiantesInscritos.contains(estudiante)) {
                estudiantesInscritos.add(estudiante);
                estudiantesPorCurso.put(curso, estudiantesInscritos);
            } else {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
            }
        }
    }

    @Override
    public void desinscribirEstudianteDeCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = buscarCursoPorId(idCurso);
        Estudiante estudiante = buscarEstudiantePorId(idEstudiante);

        if (curso != null && estudiante != null) {
            ArrayList<Estudiante> estudiantesInscritos = estudiantesPorCurso.get(curso);

            if (estudiantesInscritos.contains(estudiante)) {
                estudiantesInscritos.remove(estudiante);
                estudiantesPorCurso.put(curso, estudiantesInscritos);
            } else {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
            }
        }
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public Map<Curso, ArrayList<Estudiante>> getEstudiantesPorCurso() {
        return estudiantesPorCurso;
    }

    private Estudiante buscarEstudiantePorId(int idEstudiante) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getId() == idEstudiante) {
                return estudiante;
            }
        }
        return null;
    }

    private Curso buscarCursoPorId(int idCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getId() == idCurso) {
                return curso;
            }
        }
        return null;
    }
}
