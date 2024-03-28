package Pr8;

public class MediatorPattern {

    // Внутренний класс Colleague
    static class Colleague {
        private Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }

        public void send(String message) {
            mediator.notify(this, message);
        }

        public void receive(String message) {
            System.out.println("Received: " + message);
        }
    }

    // Внутренний класс Mediator
    static class Mediator {
        private Colleague colleague1;
        private Colleague colleague2;

        public void setColleague1(Colleague colleague1) {
            this.colleague1 = colleague1;
        }

        public void setColleague2(Colleague colleague2) {
            this.colleague2 = colleague2;
        }

        public void notify(Colleague sender, String message) {
            if (sender == colleague1) {
                colleague2.receive(message);
            } else if (sender == colleague2) {
                colleague1.receive(message);
            }
        }
    }

    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        Colleague colleague1 = new Colleague(mediator);
        Colleague colleague2 = new Colleague(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("Hello from Colleague 1");
        colleague2.send("Hello from Colleague 2");
    }
}
