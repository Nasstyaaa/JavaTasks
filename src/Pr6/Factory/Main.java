package Pr6.Factory;

public class Main {
    public static void main(String[] args) {
        Creator factoryA = new ConcreteCreator1();
        Product productA = factoryA.factoryMethod();
        productA.anOperation();

        Creator factoryB = new ConcreteCreator2();
        Product productB = factoryB.factoryMethod();
        productB.anOperation();
    }
}
