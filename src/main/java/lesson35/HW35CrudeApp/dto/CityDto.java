package lesson35.HW35CrudeApp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CityDto {

    @NotNull
    @Size(min = 1, max = 6)
    private String id;

    @NotNull
    @Size(min = 1, max = 100)
    private String ruName;

    @NotNull // аннотация ставится над коллекциями или над строками, не используется над Integer или Long
    @Size(min = 1, max = 100)
    private String enName;

    @Size(min = 1, max = 3)
    private Integer code;

    @Size(min = 1, max = 10)
    private Long population;

    public String getNameStr() {
        return String.format("city_%s", ruName);
    }
}
