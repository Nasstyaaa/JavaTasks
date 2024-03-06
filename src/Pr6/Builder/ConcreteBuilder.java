package Pr6.Builder;

public class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart() {
        product.setPart("ConcreteBuilder Part");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
