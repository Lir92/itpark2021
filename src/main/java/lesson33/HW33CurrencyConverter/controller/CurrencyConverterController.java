package lesson33.HW33CurrencyConverter.controller;

import lesson33.HW33CurrencyConverter.dto.CurrencyConverterResultDto;
import lesson33.HW33CurrencyConverter.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencyConverter")
public class CurrencyConverterController {

//    @Value("${spring.application.name}}")
//    private String application;

    private final CurrencyConverterService converterService;

    @PostMapping("/convertCurrency")
    public CurrencyConverterResultDto convertCurrency(@RequestParam("name")String name, @RequestParam("qtty") int qtty){
        return new CurrencyConverterResultDto(converterService.getCurrencyName(name), converterService.convertCurrency(name, qtty));
    }

}
