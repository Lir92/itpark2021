package lesson20.HW20XMLEmployee;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FullName {

    private String name;
    private String surname;

    public String getName() {
        return name = new PersonCreator().getRandGName();
    }

    public String getSurname() {
        return surname = new PersonCreator().getRandFName();
    }
}
