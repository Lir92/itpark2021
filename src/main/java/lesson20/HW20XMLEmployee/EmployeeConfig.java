package lesson20.HW20XMLEmployee;

import java.math.BigDecimal;
import java.util.Random;

public class EmployeeConfig {

    public int createID() {
        return new Random().nextInt(10000);
    }

    public String createName() {
        return new PersonCreator().getFullName();
    }

    public String createLogin() {
        return new PersonCreator().getRandFName() + "." + createID();
    }

    public String createDepartment() {
        String[] department = {"Finance", "Survey", "Management"};
        return department[new Random().nextInt(department.length)];
    }

    public String createCity() {
        String[] city = {"Novorossiysk", "Saint-Petersburg", "Vladivostok", "Taman"};
        return city[new Random().nextInt(city.length)];
    }

    public String createPosition() {
        String[] position = {"Surveyour", "Accountant", "Department Manager"};
        return position[new Random().nextInt(position.length)];
    }

    public BigDecimal setSalary() {
        switch (createPosition()) {
            case "Surveyour" -> new BigDecimal(70000);
            case "Accountant" -> new BigDecimal(50000);
            case "Department Manager" -> new BigDecimal(100000);
        }
        return setSalary();
    }

}
