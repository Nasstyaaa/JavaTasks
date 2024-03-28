package Pr7;


public class Decorator {

    interface Component {
        String operation();
    }

    static class ConcreteComponent implements Component {
        @Override
        public String operation() {
            return "ConcreteComponent";
        }
    }

    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        // Создание декоратора внутри класса компонента
        Component decorator = new Component() {
            @Override
            public String operation() {
                return "Decorator(" + component.operation() + ")";
            }
        };

        System.out.println(decorator.operation());
    }
}
