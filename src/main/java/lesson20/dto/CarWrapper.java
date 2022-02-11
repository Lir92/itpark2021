package lesson20.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "cars") // общий тег, в котором будут содеражться все теги.
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWrapper {

    @XmlElement(name = "car")
    private List<Car> cars; // в данном случае коллекция тегов будет представлена в "списком"
}
