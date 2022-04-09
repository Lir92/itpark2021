package lesson35;

public class Lecture35 {
    /*
    В классических приложения, в контроллерах всегда возращаемый тип String.

    ====== HTTP методы ====
    GET - получение данных на страницу. Все браузеры работают в режиме GET.

    POST - отправка пользователем каких-либо форм на сервер.
    =================

    Обычно для классических приложений в контроллерах ничего кроме GetMapping или PostMapping не используют.

    Контроллер в MVC возвращает имя View и ViewResolver выбирает соответствующий View

    Spring MVC поддерживает несколько технологий View (шаблонизаторов):
        JSP - аналог PHP на Java. JSP часто используется и имеет большие возможности, но техника стара. Один из основных
              недостатков JSP - не входит в режим embedded servlet container, из-за чего приходится разворачивать отдельно TomCat и использовать WAR.
              Не лучший шаблонизатор для использования.
        Thymeleaf - лучший View (шаблонизатор) для Spring Boot приложений. Он используется для рендеринга XML и обладает
                    схожим с JSP синтаксисом.
        Groovy Markup Templates
        Freemarker
        Velocity

    =======================
    Для работы с Thymeleaf необходимо в pom.xml добавить следующие зависимости:
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf<artifactId>
     </dependency>

     spring-boot-starter-thymeleaf с ним же подключается thymeleaf-spring5
     =====================

     Отличие @Controller от @RestController заключается в том, что @RestController возвращает JSON, а @Controller - View.

     */
}
