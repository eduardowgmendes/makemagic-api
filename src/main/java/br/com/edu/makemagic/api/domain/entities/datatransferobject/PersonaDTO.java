package br.com.edu.makemagic.api.domain.entities.datatransferobject;

import br.com.edu.makemagic.api.domain.entities.Persona;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
public class PersonaDTO implements Serializable {

    private Long id;
    private String name;
    private String role;
    private String school;
    private String house;
    private String patronus;

    public static PersonaDTO create(Persona persona) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(persona, PersonaDTO.class);
    }

}
