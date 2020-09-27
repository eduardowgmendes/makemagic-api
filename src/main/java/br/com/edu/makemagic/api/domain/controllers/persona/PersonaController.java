package br.com.edu.makemagic.api.domain.controllers.persona;

import br.com.edu.makemagic.api.domain.entities.Persona;
import br.com.edu.makemagic.api.domain.entities.datatransferobject.PersonaDTO;
import br.com.edu.makemagic.api.utils.URIUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableCircuitBreaker
@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @ApiOperation(value = "List all Personas. Can make query of houses with house parameter")
    @GetMapping
    public ResponseEntity<List<PersonaDTO>> allPersonas(@RequestParam(required = false) String house) {
        List<PersonaDTO> personas = service.findAll(house);
        return personas.isEmpty() ?
                ResponseEntity.noContent().build()
                : ResponseEntity.ok(personas);
    }

    /**
     * Query a Persona by your id value. If none Persona with given matching id be found,
     * returns 404 - NOT FOUND as Status Code
     *
     * @param id
     * @return Persona
     */
    @ApiOperation(value = "Query a Persona based on your id value")
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> findPersonaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Insert a Persona on database.
     *
     * @param persona
     * @return Insert a Persona on database
     */
    @ApiOperation(value = "Create a Persona")
    @PostMapping
    public ResponseEntity<PersonaDTO> create(@RequestBody Persona persona) {
        service.save(persona);
        return ResponseEntity.created(URIUtils.getURIOf(persona.getId(), "/{id}")).build();
    }

    @ApiOperation(value = "Update a Persona")
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable Long id, @RequestBody Persona persona) {
        persona.setId(id);
        PersonaDTO p = service.update(persona, id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    /**
     * Delete a Persona.
     *
     * @param id
     */
    @ApiOperation(value = "Delete a Persona")
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDTO> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
