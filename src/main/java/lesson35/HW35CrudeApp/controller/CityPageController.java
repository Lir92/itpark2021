package lesson35.HW35CrudeApp.controller;

import lesson35.HW35CrudeApp.dto.CityDto;
import lesson35.HW35CrudeApp.dto.CityPageDto;
import lesson35.HW35CrudeApp.service.CityService;
import lesson35.validator.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
public class CityPageController {

    private final CityService cityService;

    @GetMapping("/cities")
    public String index(Model model,
                        @PositiveOrZero(originValue = 15) @RequestParam(required = false,defaultValue = "0") Integer page,
                        @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {
        CityPageDto allCities = cityService.getPage(PageRequest.of(page,size));
        model.addAttribute("cities", allCities);
        return "city/cities";
    }

    @GetMapping("/city/add")
    public String newCity(Model model) {
        return "city/city";
    }

    @GetMapping("/city/edit")
    public String currentCity(@RequestParam("ruName") String cityName, Model model) {
        CityDto currentCity = cityService.getByRuName(cityName)
                .orElseThrow(() -> new IllegalArgumentException("Non existed city"));
        model.addAttribute("city", currentCity);
        return "city/city";
    }

    @PostMapping("/city/save")
    public String saveCity(CityDto city) {
        cityService.save(city);
        return "redirect:/cities";
    }
}
