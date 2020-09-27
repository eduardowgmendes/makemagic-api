package br.com.edu.makemagic.api.domain.controllers.house;

import br.com.edu.makemagic.api.domain.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {
    
}
