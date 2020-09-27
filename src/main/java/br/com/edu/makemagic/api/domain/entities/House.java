package br.com.edu.makemagic.api.domain.entities;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class House implements Serializable {

    @Id
    @SerializedName(value = "_id")
    private String id;
    private String name;
    private String mascot;
    private String headOfHouse;
    private String houseGhost;
    private String founder;
    private String school;

}
