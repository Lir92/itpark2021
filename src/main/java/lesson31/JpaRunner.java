package lesson31;

import lesson31.repository.EmployeeRepository;
import lesson31.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@Slf4j
@EntityScan({"lesson31","lesson25.entity"}) // в этой аннотации мы указываем какие пакеты надо будет сканировать и брать
// значения. Указываем lesson 25, так как именно там находится сущность, указанная в EmployeeRepository.
@SpringBootApplication
public class JpaRunner {

    public static void main(String[] args) {

        final ConfigurableApplicationContext appContext = SpringApplication.run(JpaRunner.class, args);
        final EmployeeService bean = appContext.getBean(EmployeeService.class);

        final EmployeeRepository employeeRepository = appContext.getBean(EmployeeRepository.class);


        final BigDecimal salary = new BigDecimal("50000");
        final String name ="Block Kirill";
        final Integer id = 4;

        log.info("Сотрудники с зарплатой {} {}", salary, bean.findBySalary(salary));

        log.info("Сотрудники с зарплатой {} и фамилией {} {}", salary, name, bean.findBySalaryAndName(salary, name));

        log.info("Сотрудник с департамента {} и идентификатор которого равен {}", id, bean.findByDepartmentId(id));

        log.info("Сотрудники с департамента {} и равен {}", id, employeeRepository.findEmployeeByDepId(id));

        employeeRepository.findEmployeeByDepId(id).forEach(employeeProjection -> {
            log.info("Сотрудники с департамента {} и равен {}", id, employeeProjection.asString());
        });

        bean.resetSalary(4);
    }
}
