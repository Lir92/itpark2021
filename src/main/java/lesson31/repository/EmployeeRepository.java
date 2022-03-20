package lesson31.repository;

import lesson25.entity.Employee;
import lesson31.dto.EmployeeDto;
import lesson31.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<lesson25.entity.Employee> findBySalary(BigDecimal salary); // ищем сотрудников с зп = salary.

    List<lesson25.entity.Employee> findBySalaryOOrEmpName(BigDecimal salary, String empName);

    @Query("select e from Employee e " +
            "where e.department.id = :depId")
    List<Employee> findEmployeeByDepartmentId(@Param("depId")Integer departmentId);

//    @Query("select new lesson31.dto.EmployeeDto(e.empName, e.salary) from Employee e " +
//            "where e.department.id = :depId")
//    List<EmployeeDto> findEmployeeByDepId(Integer departmentId);

    @Query("select e.empName as name, e.salary as salary from Employee e " +
            "where e.department.id = :depId")
    List<EmployeeProjection> findEmployeeByDepId(Integer departmentId);

    @Modifying //анотация, если происходят модификации
    @Query("update Employee e set e.salary = :salary " +
            "where e.id = :employeeId")
    void updateById(Integer employeeId, BigDecimal salary);
}
