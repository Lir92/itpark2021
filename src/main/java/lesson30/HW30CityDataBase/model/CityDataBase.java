package lesson30.HW30CityDataBase.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CityDataBase")
public class CityDataBase {

    @Id
    @Column(name = "Code")
    private Integer code;

    @Column(name = "City_Name_Rus")
    private String cityNameRus;

    @Column(name = "City_Name_Eng")
    private String cityNameEng;

    @Nullable
    @Column(name = "Population")
    private Long population;

    public CityDataBase(Integer code, String cityNameRus, String cityNameEng, long population) {
        this.cityNameRus = cityNameRus;
        this.cityNameEng = cityNameEng;
        this.code = code;
        this.population = population;
    }
}
