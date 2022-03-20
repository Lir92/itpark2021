package lesson31.service.impl;

import lesson25.entity.Employee;
import lesson31.repository.EmployeeRepository;
import lesson31.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findBySalary(BigDecimal salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findBySalaryAndName(BigDecimal salary, String name) {
        return employeeRepository.findBySalaryOOrEmpName(salary, name);
    }

    @Override
    public List<Employee> findByDepartmentId(Integer id) {
        return employeeRepository.findEmployeeByDepartmentId(id);
    }
}
