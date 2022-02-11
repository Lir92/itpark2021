package lesson20.HW20XMLEmployee;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeToXMLRunner {

    private static final String PATH = "D:\\test\\Employee.xml";

    @SneakyThrows
    public static void main(String[] args) {

        Employee employee_1 = new Employee();
        employee_1.setIDNumber(employee_1.setRandomID());
        employee_1.setFullName(new PersonCreator().getFullName());
        employee_1.setLogin("user" + "." + employee_1.getIDNumber());
        employee_1.setDepartment(new Department("Logistics", "Novorossiysk"));
        employee_1.setCapacity(new Vacancy("Agent", new BigDecimal(50000)));

        Employee employee_2 = new Employee();
        employee_2.setIDNumber(employee_2.setRandomID());
        employee_2.setFullName(employee_2.createFullName());
        employee_2.setLogin("user" + "." + employee_2.getIDNumber());
        employee_2.setDepartment(new Department("Finance", "Moscow"));
        employee_2.setCapacity(new Vacancy("Manager", new BigDecimal(100000)));

        EmployeesToList employeesToList = new EmployeesToList();
        employeesToList.setEmployees(Arrays.asList(employee_1, employee_2));
        String xmlOfEmployees = writeToXML(employeesToList);
        writeXMLToFile(xmlOfEmployees);

        Document document = getDocument(PATH);
        double avgSalary = countAverageSalary(document);
        System.out.println("Срездняя зп: " + avgSalary);

        List<String> name = searchEmployeeWithHigherThenAverageSalary(document, avgSalary);
        System.out.println("Сотрудник с зп выше среднего - " + name);

    }

    private static String writeToXML(EmployeesToList employee) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EmployeesToList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(employee, stringWriter);
        return String.valueOf(stringWriter);
    }

    public static void writeXMLToFile(String str) {
        try (FileWriter file = new FileWriter(PATH, false)) {
            String lineSeparator = System.getProperty("line.separator");
            file.write(str + lineSeparator);
            file.flush();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @SneakyThrows
    public static Document getDocument(String file) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(file);
    }

    @SneakyThrows
    public static Double countAverageSalary(Document document) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        return (Double) xPath.compile("sum(//capacity/salary) div count(//capacity/salary)").evaluate(document, XPathConstants.NUMBER);
    }

    public static List<String> searchEmployeeWithHigherThenAverageSalary(Document document, double avgSalary) throws XPathExpressionException {
        XPathFactory xPath = XPathFactory.newInstance();
        NodeList nodeList = (NodeList) xPath.newXPath()
                .compile("/employees/employee/capacity[salary >" + avgSalary + "]/ancestor::employee/fullName/text()")
                .evaluate(document, XPathConstants.NODESET);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            list.add(nodeList.item(i).getNodeValue());
        }
        return list;

    }
}