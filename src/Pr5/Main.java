package Pr5;

public class Main {
    public static void main(String[] args) {

        // Тестирование 1-ой реализации Singleton
        SingletonOne instance1 = SingletonOne.getInstanceOne();
        SingletonOne instance2 = SingletonOne.getInstanceOne();

        // Проверяем, что оба экземпляра ссылаются на один и тот же объект
        if (instance1 == instance2) {
            System.out.println("Тест пройден: SingletonOne.getInstanceOne() возвращает один и тот же экземпляр.");
        } else {
            System.out.println("Тест не пройден: SingletonOne.getInstanceOne() возвращает разные экземпляры.");
        }

        // Тестирование 2-ой версии Singleton
        SingletonTwo instance3 = SingletonTwo.getInstanceTwo();
        SingletonTwo instance4 = SingletonTwo.getInstanceTwo();

        // Проверяем, что оба экземпляра ссылаются на один и тот же объект
        if (instance3 == instance4) {
            System.out.println("Тест пройден: SingletonTwo.getInstanceTwo() возвращает один и тот же экземпляр.");
        } else {
            System.out.println("Тест не пройден: SingletonTwo.getInstanceTwo() возвращает разные экземпляры.");
        }

        // Тестирование 3-ей версии Singleton
        SingletonThree instance5 = SingletonThree.getInstanceThree();
        SingletonThree instance6 = SingletonThree.getInstanceThree();

        // Проверяем, что оба экземпляра ссылаются на один и тот же объект
        if (instance5 == instance6) {
            System.out.println("Тест пройден: SingletonThree.getInstanceThree() возвращает один и тот же экземпляр.");
        } else {
            System.out.println("Тест не пройден: SingletonThree.getInstanceThree() возвращает разные экземпляры.");
        }
    }
}
