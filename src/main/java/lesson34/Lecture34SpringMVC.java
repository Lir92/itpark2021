package lesson34;

public class Lecture34SpringMVC {
    /*
============= Servlet
    Servlet - входная точка от фронт-энда, который передаёт запрос на бэк-энд.

    В Spring есть Front Controller, который является Сервлетом (Dispatcher Servlet). Он обрабатывает какой запрос куда
    должен быть отправлен для обработки.

    Из HttpServletRequest можно получать Cookies - getCookies (н-р клиентские настройки), параметры - getParameter,
    заголовки - getHeader, тип метода - getMethod.

    ======
    При использовании @ResponseEntity, если есть необходимость сменить фреймворк, то придётся переписывать все контроллеры.
    ======
    @RequestBody - todo: почитать про аннотации для параметров

     */
}
