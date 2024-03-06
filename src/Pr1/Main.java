package Pr1;

import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        Function<Integer> function = (a, b) -> { //лямбда-функция
            while (!Objects.equals(a, b)) { //поиск НОД алгоритмом Евклида
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
            return a;
        };
        System.out.println("First test NOD(2,4): " + function.nod(2, 4)); //Вывод результатов
        System.out.println("Second test NOD(54, 24): " + function.nod(54, 24));
    }
}
