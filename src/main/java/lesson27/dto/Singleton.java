package lesson27.dto;

public class Singleton {
    // ниже пример того, как можно написать бин-синглтон.

    // Пример №1
//    public static Singleton INSTANCE;
//
//    private Singleton() {
//        INSTANCE = new Singleton();
//    }

    // Пример №2
    // В примере ниже новый синглтон создаётся только тогда, если его экземпляр ещё не был создан ранее. Иначе будет
    // использован уже существующий объект.
    private static Singleton INSTANCE; // в качестве типа указывается имя класса, в котором размещается синглтон
    private Singleton() {}
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            return new Singleton();// создаём новый объект, если такого ещё нет в системе.
        }
        return INSTANCE; // если такой объект уже существует, вернётся ранее созданный объект
    }
}
