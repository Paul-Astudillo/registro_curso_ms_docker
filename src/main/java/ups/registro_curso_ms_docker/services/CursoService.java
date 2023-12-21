package ups.registro_curso_ms_docker.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.registro_curso_ms_docker.model.Curso;
import ups.registro_curso_ms_docker.repository.CursoRepository;
import java.util.List;

public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listCursos() {
        return cursoRepository.findAll();
    }

    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }
}
