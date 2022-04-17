package lesson35.HW35CrudeApp.controller;

import lesson35.HW35CrudeApp.service.CityService;
import lesson35.dto.ResultDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@Data
public class DeleteCityController {

    private CityService cityService;

//    @DeleteMapping("/cities/{ruName}")
//    public ResponseEntity<?> deleteCity(@PathVariable("ruName") String ruName){
//        cityService.deleteByName(ruName);
//        return ResponseEntity.ok(new ResultDto());
//    }

    @DeleteMapping("/delete/{ruName}")
    public void deleteCity(@PathVariable("ruName") String ruName){
        cityService.deleteByName(ruName);
    }
}