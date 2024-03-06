package Pr6.Builder;

public class Product {
    private String part;

    public void setPart(String part) {
        this.part = part;
    }

    public void show() {
        System.out.println("Product Part: " + part);
    }
}