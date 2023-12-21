package ups.registro_curso_ms_docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.registro_curso_ms_docker.model.Curso;
import ups.registro_curso_ms_docker.services.CursoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ms/curso/")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping("/guardar")
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        Curso temp = cursoService.create(curso);

        try {
            return ResponseEntity.created(new URI("/ms/curso/guardar" + temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Curso>> listAll() {
        return ResponseEntity.ok(cursoService.listCursos());
    }
}
