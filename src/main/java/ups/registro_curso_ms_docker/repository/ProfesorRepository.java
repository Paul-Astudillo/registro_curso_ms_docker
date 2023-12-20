package ups.registro_curso_ms_docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.registro_curso_ms_docker.model.Profesor;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findByCedulaIgnoreCase(String cedula);
}
