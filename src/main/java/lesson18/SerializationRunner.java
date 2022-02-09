package lesson18;

import lesson18.dto.Person;
import lesson18.dto.Sex;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationRunner {

    @SneakyThrows
    public static void main(String[] args) { // для работы с Сериализацией, в классе, где создаются объекты необходимо
        // имплементировать интерфейс Serializable.
        Person kirill = new Person("Kirill Block", 30, Sex.MALE, 175);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\test\\person.dat"))){
            oos.writeObject(kirill);
        }
    }
}
