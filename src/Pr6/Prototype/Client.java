package Pr6.Prototype;

public class Client {
    public static void main(String[] args) {
        Prototype prototype = new Prototype("Original");
        prototype.show();

        Prototype clone = prototype.clone();
        clone.show();
    }
}
