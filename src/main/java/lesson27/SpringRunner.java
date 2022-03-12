package lesson27;

import lesson24.dto.Employee;
import lesson27.config.AppConfig;
import lesson27.dao.DepartmentRepository;
import lesson27.dto.EmployeeRepository;
import lesson27.dto.impl.EmployeeRepositoryImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class SpringRunner {

    public static void main(String[] args) throws SQLException {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        employeeRepository.save(new Employee());

        final DepartmentRepository departmentRepository = applicationContext.getBean(DepartmentRepository.class);
        try(final Connection connection = departmentRepository.getConnection()) {
            // TODO: посмотреть почему при работе со спрингом всё обозначается final???
        }
    }
}
