package br.com.edu.makemagic.api;

import br.com.edu.makemagic.api.configuration.ExceptionHandling;
import br.com.edu.makemagic.api.domain.controllers.house.HouseService;
import br.com.edu.makemagic.api.domain.entities.datatransferobject.HouseDTO;
import br.com.edu.makemagic.api.exceptions.PropertyMismatchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTests {

    private final HouseService service = new HouseService();
    private final Logger log = LogManager.getLogger(Tests.class);

    @Test
    public List<HouseDTO> allHousesTest() {
        return service.findAllHouses();
    }

    @Test
    public void matchingHouseWith() {

        String ravenclaw = "5a05da69d45bd0a11bd5e06f";
        String hugglepuff = "5a05dc58d45bd0a11bd5e070";
        String slytherin = "5a05dc8cd45bd0a11bd5e071";
        String gryffindor = "5a05e2b252f721a3cf2ea33f";

        String issue = "5a05e2b252f721a3cf2ea33fds";

        String permittedHouseWith = match(ravenclaw);
        assertEquals(ravenclaw, permittedHouseWith);
    }


    @Test
    private String match(String houseId) {
        return service.findAllHouses()
                .stream()
                .filter(h -> h.getId().equals(houseId))
                .findFirst()
                .orElseThrow(() -> new PropertyMismatchException(ExceptionHandling.ERROR_HOUSE_NOT_EQUALS, houseId))
                .getId();
    }
}
