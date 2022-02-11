package lesson20.HW20XMLEmployee;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Random;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    private int IDNumber;
    private String fullName;
    private String login;
    private Department department;
    private Vacancy capacity;

    public int setRandomID() {
        return new Random().nextInt(10000);
    }

    public String createFullName() {
        return new FullName().getName() + " " + new FullName().getSurname();
    }
}
