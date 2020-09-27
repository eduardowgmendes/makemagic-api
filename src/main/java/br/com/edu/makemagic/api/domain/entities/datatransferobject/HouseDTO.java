package br.com.edu.makemagic.api.domain.entities.datatransferobject;

import br.com.edu.makemagic.api.domain.entities.House;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
public class HouseDTO implements Serializable {

    @SerializedName("_id")
    private String id;
    private String name;

    public static HouseDTO create(House house) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(house, HouseDTO.class);
    }
}
