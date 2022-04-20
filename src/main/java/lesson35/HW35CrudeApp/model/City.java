package lesson35.HW35CrudeApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CityDataBase")
public class City {

    @Id
    @NotEmpty
    @Column(name = "id")
    private String id;

    @NotEmpty
    @Column(name = "City_Name_Rus")
    private String ruName;

    @NotEmpty
    @Column(name = "City_Name_Eng")
    private String enName;

    @Column(name = "Code")
    private Integer code;

    @Column(name = "Population")
    private Long population;

}
