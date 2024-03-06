package Pr6.Factory;

public class ConcreteCreator2 extends Creator{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
