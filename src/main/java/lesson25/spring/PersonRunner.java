package lesson25.spring;

import lesson25.spring.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        PersonService personService = (PersonService) classPathXmlApplicationContext.getBean("newPersonService"); // получаем бин по имени, который мы обязаны явно кастовать к нужному типу
//        PersonService personService = classPathXmlApplicationContext.getBean(PersonService.class); // получение бина при помощи ссылки на класс
        personService.print();
    }
}
