package Pr5;

public class SingletonOne {
    private SingletonOne(){ // приватный конструктор, чтобы предотвратить создание экземпляра класса извне
    }
    private static class SingletonInternal{ // внутренний статический класс
        private final static SingletonOne instance = new SingletonOne(); // экземпляр SingletonOne, который инициализируется при загрузке класса SingletonInternal
    }
    public static SingletonOne getInstanceOne(){ // метод для получения единственного экземпляра SingletonOne
        return SingletonInternal.instance;
    }
}
