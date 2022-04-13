package lesson35.HW35CrudeApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CityPageDto {

    private List<CityDto> data;
    private int currentPage;
    private int totalPage;
    private boolean hasNext;
    private boolean hasPrevious;
}
