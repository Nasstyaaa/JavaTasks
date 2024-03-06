package Pr4;

public class Main {
    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor(4);
        myExecutor.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Строка после первой");
        });
        myExecutor.submit(() -> System.out.println("Первая строка"));
        myExecutor.shutdown();
    }
}
