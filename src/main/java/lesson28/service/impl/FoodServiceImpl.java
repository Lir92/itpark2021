package lesson28.service.impl;

import lesson28.service.FoodService;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Override
    public void feed() {
        System.out.println("Здесь вас точно накормят");

    }
}
