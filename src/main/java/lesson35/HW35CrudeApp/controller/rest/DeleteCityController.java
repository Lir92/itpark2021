package lesson35.HW35CrudeApp.controller.rest;

import lesson35.HW35CrudeApp.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteCityController {

    private final CityService cityService;

    @DeleteMapping("/delete/{id}")
    public void deleteCity(@PathVariable("id") String id){
        cityService.deleteById(id);
    }
}