package lesson20.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@XmlRootElement(name = "auto") // определяет объект, как атрибут корневого xml
@XmlAccessorType(XmlAccessType.FIELD) // определяет откуда считывать аннотации: с геттеров или с полей, не создавая геттеры
@XmlType(propOrder = {"model", "price" , "mark", "owner"})
public class Car {

    @XmlAttribute(name = "m")
    private String mark;

    @XmlAttribute(name = "ml")
    private String model;

    @XmlAttribute()
    private BigDecimal price;

    //@XmlTransient // данная аннотация исключает это поле и оно не будет сформировано в xml. !ВНИМАНИЕ: если навесить
    // данную аннотацию и создать xml, то выдаст ошибку, если в @XmlType(propOrder = {"model", "price" , "mark", "owner"})
    // будет указано исключённое поле
    @XmlElement(name = "driver")
    private /*transient*/ Owner owner;

//    @XmlElement(name = "m") // такие
//    public String getMark() {
//        return mark;
//    }
}
