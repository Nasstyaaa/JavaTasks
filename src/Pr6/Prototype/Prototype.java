package Pr6.Prototype;

public class Prototype implements Cloneable {
    private String field;

    public Prototype(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    public void show() {
        System.out.println("Field: " + field);
    }
}

