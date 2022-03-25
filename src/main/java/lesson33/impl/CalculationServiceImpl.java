package lesson33.impl;

import lesson33.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculatorService {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
