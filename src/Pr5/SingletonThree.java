package Pr5;

public class SingletonThree {
    private static SingletonThree instance;

    private SingletonThree() {
    }

    public static SingletonThree getInstanceThree() {
        if (instance == null) {
            synchronized (SingletonThree.class){ // Блокировка на класс SingletonThree для синхронизации доступа к экземпляру.
                if (instance == null) // Повторная проверка на null, чтобы убедиться, что экземпляр создается только один раз.
                    instance = new SingletonThree();
            }
        }
        return instance;
    }
}
