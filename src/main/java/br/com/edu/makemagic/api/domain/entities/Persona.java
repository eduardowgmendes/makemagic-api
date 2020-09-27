package br.com.edu.makemagic.api.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is Mandatory")
    @NotEmpty(message = "Name is Mandatory")
    @NotBlank(message = "Name is Mandatory")
    private String name;

    @NotNull(message = "Role is Mandatory")
    @NotEmpty(message = "Role is Mandatory")
    @NotBlank(message = "Role is Mandatory")
    private String role;

    @NotNull(message = "School is Mandatory")
    @NotEmpty(message = "School is Mandatory")
    @NotBlank(message = "School is Mandatory")
    private String school;

    @NotNull(message = "House is Mandatory")
    @NotEmpty(message = "House is Mandatory")
    @NotBlank(message = "House is Mandatory")
    private String house;

    @NotNull(message = "Patronus is Mandatory")
    @NotEmpty(message = "Patronus is Mandatory")
    @NotBlank(message = "Patronus is Mandatory")
    private String patronus;

    public Persona(String house) {
        this.house = house;
    }

    public Persona(@NotNull(message = "Name is Mandatory") @NotEmpty(message = "Name is Mandatory") @NotBlank(message = "Name is Mandatory") String name, @NotNull(message = "Role is Mandatory") @NotEmpty(message = "Role is Mandatory") @NotBlank(message = "Role is Mandatory") String role, @NotNull(message = "School is Mandatory") @NotEmpty(message = "School is Mandatory") @NotBlank(message = "School is Mandatory") String school, @NotNull(message = "House is Mandatory") @NotEmpty(message = "House is Mandatory") @NotBlank(message = "House is Mandatory") String house, @NotNull(message = "Patronus is Mandatory") @NotEmpty(message = "Patronus is Mandatory") @NotBlank(message = "Patronus is Mandatory") String patronus) {
        this.name = name;
        this.role = role;
        this.school = school;
        this.house = house;
        this.patronus = patronus;
    }
}
