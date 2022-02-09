package lesson18.dto;

import lombok.*;

import java.io.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor // конструктор всех полей
//@RequiredArgsConstructor // анализирует все final поля. Не используется вместе с AllArgsConstructor и NoArgsConstructor
@Data // можно использовать вместо того, что указано выше, так как @Data включает их.
@EqualsAndHashCode(exclude = "height") //() - в скобках можно указать те поля, которые необходимо обработать или исключить, н-р: (exclude = "height")

public class Person implements Serializable {

//    @Serial
//    private static final long serialVersionUID = 1L; // если serialVersionUID у сериализованного
//    // объекта и десериализованного объекта разные, то может выдать ошибку и файлы не считаются



    private String name;
    private int age;
    private Sex sex;
    private double height;

    public Person(String name) {
        this.name = name;
    }

    public void beOlder() throws Exception {
        this.age++;
    }
}