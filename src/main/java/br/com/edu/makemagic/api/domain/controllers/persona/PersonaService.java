package br.com.edu.makemagic.api.domain.controllers.persona;

import br.com.edu.makemagic.api.configuration.ExceptionHandling;
import br.com.edu.makemagic.api.domain.controllers.filter.PersonaSpecs;
import br.com.edu.makemagic.api.domain.controllers.house.HouseService;
import br.com.edu.makemagic.api.domain.entities.Persona;
import br.com.edu.makemagic.api.domain.entities.datatransferobject.PersonaDTO;
import br.com.edu.makemagic.api.exceptions.ObjectNotFoundException;
import br.com.edu.makemagic.api.exceptions.PropertyMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    private HouseService houseService;

    /**
     * Returns a list of all stored Personas.
     * Returns only Personas with a defined House
     * if the house be passed as argument.
     *
     * @param house
     */
    @Caching(evict = {@CacheEvict(value = "persona", allEntries = true, condition = "#house != null && not #house.isEmpty() && not #house.isBlank()", beforeInvocation = true)}, cacheable = {@Cacheable(value = "persona", condition = "#house == null", key = "#root.method.name")})
    public List<PersonaDTO> findAll(String house) {
        return repository.findAll(new PersonaSpecs(new Persona(house)))
                .stream()
                .map(PersonaDTO::create)
                .collect(Collectors.toList());
    }

    /**
     * Returns a stored Persona based on your id
     *
     * @param id
     */
    @Cacheable(value = "persona", key = "#root.method.name")
    public PersonaDTO findById(Long id) {
        return repository.findById(id)
                .map(PersonaDTO::create)
                .orElseThrow(() -> new ObjectNotFoundException(ExceptionHandling.ERROR_NOT_FOUND));
    }

    /**
     * Save a Persona
     *
     * @param persona
     */
    @CacheEvict(value = "persona", allEntries = true)
    public PersonaDTO save(Persona persona) {
        Assert.isNull(persona.getId(), ExceptionHandling.ERROR_CREATE_MESSAGE);
        persona.setHouse(getPermittedHouseWith(persona.getHouse()));
        repository.save(persona);
        return PersonaDTO.create(persona);
    }

    /**
     * Update a Persona with a new Persona and and id.
     * The id value is used to find the register stored
     * and returns a Optional that contains the old registry
     * to be updated.
     *
     * @param persona
     * @param id
     */
    @CacheEvict(value = "persona", allEntries = true)
    public PersonaDTO update(Persona persona, Long id) {
        Assert.notNull(id, ExceptionHandling.ERROR_UPDATE_MESSAGE);

        Optional<Persona> optional = repository.findById(id);

        if (optional.isPresent()) {
            Persona personaFromDatabase = optional.get();

            personaFromDatabase.setName(persona.getName());
            personaFromDatabase.setRole(persona.getRole());
            personaFromDatabase.setSchool(persona.getSchool());
            personaFromDatabase.setHouse(getPermittedHouseWith(persona.getHouse()));
            personaFromDatabase.setPatronus(persona.getPatronus());

            repository.save(personaFromDatabase);

            return PersonaDTO.create(personaFromDatabase);
        } else {
            return null;
        }
    }

    /**
     * Deletes a stored Persona
     *
     * @param id
     */
    @CacheEvict(value = "persona", allEntries = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Returns a String with the permitted matching House id
     * to be used to save or update a Persona comparing with
     * permitted values retrieved from PotterAPI.
     * If the argument is an House id invalid a
     * PropertyMismatchException will be thrown.
     *
     * @param houseId
     */
    private String getPermittedHouseWith(String houseId) {
        return houseService.findAllHouses()
                .stream()
                .filter(h -> h.getId().equals(houseId))
                .findFirst()
                .orElseThrow(() -> new PropertyMismatchException(ExceptionHandling.ERROR_HOUSE_NOT_EQUALS, houseId))
                .getId();
    }

}
