package lesson18.dto;

import lombok.SneakyThrows;

public class PersonRunner {

    @SneakyThrows // создаёт try-catch блок для обработки исключений:
            /*
            try {
                person.beOlder();
            } catch(Exception e) {
                throw e;
            }
             */
    public static void main(String[] args) {
        Person person = new Person("John");
        person.setAge(33);
        Person newPerson = new Person();
        Person Kirill = new Person("Kirill", 30, Sex.MALE, 175);
        person.beOlder();
    }
}
