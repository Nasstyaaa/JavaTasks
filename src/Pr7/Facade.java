package Pr7;

public class Facade {

    // Класс подсистемы
    static class SubsystemA {
        public void operationA() {
            System.out.println("Subsystem A operation");
        }
    }

    static class SubsystemB {
        public void operationB() {
            System.out.println("Subsystem B operation");
        }
    }

    // Фасад
    static class FacadeEx {
        private SubsystemA subsystemA = new SubsystemA();
        private SubsystemB subsystemB = new SubsystemB();

        public void operation() {
            subsystemA.operationA();
            subsystemB.operationB();
        }
    }

    public static void main(String[] args) {
        FacadeEx facade = new FacadeEx();
        facade.operation();
    }
}
