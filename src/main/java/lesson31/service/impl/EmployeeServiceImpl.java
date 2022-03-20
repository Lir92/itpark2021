package lesson31.service.impl;

import lesson25.entity.Department;
import lesson25.entity.Employee;
import lesson31.repository.DepartmentRepository;
import lesson31.repository.EmployeeRepository;
import lesson31.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Setter(onMethod_ = {@Lazy, @Autowired})
    private EmployeeServiceImpl self;

    @Override
    public List<Employee> findBySalary(BigDecimal salary) {
        List<Employee> employees = employeeRepository.findBySalary(salary);
        employees.forEach(employee -> {
            final Department department = employee.getDepartment(); // обход аннотации @Lazy
        });
        return employees;
    }

    @Override
    public List<Employee> findBySalaryAndName(BigDecimal salary, String name) {
        return employeeRepository.findBySalaryOrEmpName(salary, name);
    }

    @Override
    public List<Employee> findByDepartmentId(Integer id) {
        return employeeRepository.findEmployeeByDepartmentId(id);
    }

    @Override
    @Transactional(noRollbackFor = IllegalStateException.class, rollbackFor = URISyntaxException.class) // такая анотация вешается над методом не на сервисе, а на имплементации
    public void resetSalary(Integer id) {
        employeeRepository.updateById(id, BigDecimal.ZERO);
        self.updateDepartment(id, 7); // только используя self правильно отработает метод, над которым развешаны
        //аннотации метода, иначе они будут проигнорированы(сброшены)
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateDepartment(Integer employeeId, Integer departmentId) {
        employeeRepository.updateDepartmentForEmployee(
                departmentRepository.getById(departmentId),
                employeeId
        );
    }
}
