package lesson33.controller;

import lesson33.dto.ResultDto;
import lesson33.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class InputController {

    @Value("${spring.application.name}}")
    private String application;

    private final CalculatorService calculatorService;

//    @RequestMapping()
    @PostMapping("/sum")
    public ResultDto sum(@RequestParam("arg1") Integer a, @RequestParam("arg2") Integer b) {
        return new ResultDto(application, calculatorService.sum(a, b));
    }
}
