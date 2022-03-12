package lesson27.dto;

import lesson24.dto.Employee;

public interface EmployeeRepository {

    void save(Employee dto);
}
