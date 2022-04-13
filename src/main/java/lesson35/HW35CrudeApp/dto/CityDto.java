package lesson35.HW35CrudeApp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CityDto {

    @NotNull
    @Size(min = 1, max = 100)
    private String ruName;

    @NotNull
    @Size(min = 1, max = 100)
    private String enName;

    @NotNull
    @Size(min = 1, max = 3)
    private Integer code;

    @Size(min = 1, max = 10)
    private Long population;

    public String getNameStr() {
        return String.format("city_%s", ruName);
    }
}
