package lesson35.HW35CrudeApp.controller;

import lesson35.HW35CrudeApp.dto.CityDto;
import lesson35.HW35CrudeApp.dto.CityPageDto;
import lesson35.HW35CrudeApp.repository.CityRepository;
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
    private final CityRepository cityRepository;

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
    public String currentCity(@RequestParam("id") String id, Model model) {
        CityDto currentCity = cityService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Non existed city"));
        model.addAttribute("city", currentCity);
        return "city/city";
    }

//    @PutMapping("/{ruName}")
//    public /*ResponseEntity<City>*/ String updateCity(@PathVariable("ruName") Integer cityName,
//                                        @Valid @RequestBody City cityInfo) {
//        City currentCity = cityRepository.findById(cityName)
//                .orElseThrow(() -> new IllegalArgumentException("Employee not found for this id :: " + cityName));
//        currentCity.setRuName(cityInfo.getRuName());
//        currentCity.setEnName(cityInfo.getRuName());
//        currentCity.setCode(cityInfo.getCode());
//        currentCity.setPopulation(cityInfo.getPopulation());
//        final City updatedCity = cityRepository.save(currentCity);
//        ResponseEntity.ok(updatedCity);
//        return "redirect:/cities";
//    }

    @PostMapping("/city/save")
    public String saveCity(CityDto city) {
        cityService.save(city);
        return "redirect:/cities";
    }
}
