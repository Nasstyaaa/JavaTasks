package Pr6.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory1 = new Factory1();
        AbstractProduct productA1 = factory1.createProductA();
        AbstractProduct productB1 = factory1.createProductB();
        productA1.anOperation();
        productB1.anOperation();

        AbstractFactory factory2 = new Factory2();
        AbstractProduct productA2 = factory2.createProductA();
        AbstractProduct productB2 = factory2.createProductB();
        productA2.anOperation();
        productB2.anOperation();
    }
}
