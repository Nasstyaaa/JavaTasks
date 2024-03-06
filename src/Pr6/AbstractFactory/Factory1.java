package Pr6.AbstractFactory;

public class Factory1 implements AbstractFactory {
    @Override
    public AbstractProduct createProductA() {
        return new ProductA();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ProductB();
    }
}
