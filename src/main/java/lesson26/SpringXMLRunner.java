package lesson26;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");

        BeanA bean = classPathXmlApplicationContext.getBean(BeanA.class);
        bean.print();
    }
}
