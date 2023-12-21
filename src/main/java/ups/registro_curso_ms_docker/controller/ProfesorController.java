package ups.registro_curso_ms_docker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.registro_curso_ms_docker.model.Profesor;
import ups.registro_curso_ms_docker.services.ProfesorService;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/ms/profesor/")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/guardar")
    public ResponseEntity<Profesor> save(@RequestBody Profesor profesor) {
        Profesor temp = profesorService.create(profesor);

        try {
            return ResponseEntity.created(new URI("/ms/profesor/guardar" +temp.getCedula())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profesor>> listAll() {
        return ResponseEntity.ok(profesorService.listProfesores());
    }

    @GetMapping("/buscar")
    public ResponseEntity<Profesor> buscarProfesor(@RequestParam String cedula) {
        Optional<Profesor> profesorEncontrado = profesorService.buscarProfesor(cedula);
        return profesorEncontrado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
