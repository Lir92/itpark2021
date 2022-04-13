package lesson35.HW35CrudeApp.dto;

import lombok.Data;

@Data
public class ResultDto {

    private boolean success;

    public ResultDto() {
        this.success = true;
    }
}
