package ups.registro_curso_ms_docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.registro_curso_ms_docker.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
