package Pr2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class MyStream {
    //создание объектов класса Human
    Human obj1 = new Human(14, "Bob", "Beber", LocalDate.of(1999, 9, 23), 55);
    Human obj2 = new Human(18, "Masha", "Hgy", LocalDate.of(1967, 2, 20), 80);
    Human obj3 = new Human(21, "Darya", "Kftyd", LocalDate.of(1955, 5, 1), 43);
    Human obj4 = new Human(35, "Misha", "Lyft", LocalDate.of(1987, 11, 16), 67);
    Human obj5 = new Human(20, "Alice", "Mftrd", LocalDate.of(1989, 3, 4), 90);
    List<Human> mas = List.of(obj1, obj2, obj3, obj4, obj5); //объединение объектов в упорядоченную коллекцию


    public void sortName() { //сортировка объектов по 2 букве имени с помощью потока
        mas.stream().sorted(Comparator.comparingInt(x -> x.getName().charAt(1))).forEach(System.out::println);
    }

    public void filterWeight() { //фильтрация объектов по весу кратному 10 с помощью потока
        mas.stream().filter(x -> (x.getWeight() % 10 == 0)).forEach(System.out::println);
    }

    public void sortAge() { //сортировка объектов по произаедению веса с возрастом  с помощью потока
        mas.stream().sorted(Comparator.comparingInt(x -> (x.getWeight() * x.getAge()))).forEach(System.out::println);
    }

    public void sum() { //вычисление произведения всех весов объектов
        System.out.println(mas.stream().map(Human::getWeight).reduce((x, y) -> x * y).get());
    }
}
