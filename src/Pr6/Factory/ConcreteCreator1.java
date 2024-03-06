package Pr6.Factory;

public class ConcreteCreator1 extends Creator{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
