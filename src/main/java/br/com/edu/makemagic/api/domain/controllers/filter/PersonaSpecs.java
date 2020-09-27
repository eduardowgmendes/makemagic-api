package br.com.edu.makemagic.api.domain.controllers.filter;

import br.com.edu.makemagic.api.domain.entities.Persona;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class PersonaSpecs implements Specification<Persona> {

    private final Persona persona;

    public PersonaSpecs(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Predicate toPredicate(Root<Persona> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.conjunction();
        if (Objects.nonNull(this.persona.getHouse()) && Strings.isNotEmpty(this.persona.getHouse())) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("house"), this.persona.getHouse()));
        }
        return p;
    }
}
