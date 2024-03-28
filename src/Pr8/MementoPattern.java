package Pr8;

public class MementoPattern {

    // Внутренний класс Originator
    static class Originator {
        private String state;

        public Memento saveToMemento() {
            return new Memento(state);
        }

        public void restoreFromMemento(Memento memento) {
            state = memento.getState();
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    // Внутренний класс Memento
    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("State 1");
        System.out.println("Originator state: " + originator.getState());

        Memento memento = originator.saveToMemento();

        originator.setState("State 2");
        System.out.println("Originator state: " + originator.getState());

        originator.restoreFromMemento(memento);
        System.out.println("Originator state: " + originator.getState());
    }
}
