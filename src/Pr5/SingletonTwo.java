package Pr5;

public class SingletonTwo {

    private static SingletonTwo instance;
    private SingletonTwo(){
    }
    public static synchronized SingletonTwo getInstanceTwo(){
        if(instance == null){ // Проверяем, инициализирован ли экземпляр. Если нет, создаем его
            instance = new SingletonTwo();
        }
        return instance;
    }
}
