package lesson25.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "employees")
@Entity // аннотация о том, что можно использовать фреймворком
@Table(name = "department") // указываем таблицу, которая будет использована в @Entity. В скобках указывается имя таблицы, которая будет создана.
@NoArgsConstructor
public class Department {

    @Id // для hibernate необходим первичный ключ, id - первичный ключ
    private Integer id;

    @Column(name = "name") // аннотация для указания имени колонки
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees; // связь по полю в классе Employee

    public Department(Integer departmentId, String departmentName) {
        this.id = departmentId;
        this.name = departmentName;
    }
}