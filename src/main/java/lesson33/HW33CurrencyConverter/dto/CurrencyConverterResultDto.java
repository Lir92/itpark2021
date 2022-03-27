package lesson33.HW33CurrencyConverter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterResultDto {

    private String name;
    private BigDecimal value;
}
