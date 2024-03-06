package Pr2;


public class Main {
    public static void main(String[] args) {
        MyStream obj = new MyStream();
        System.out.println("Фильтрация по весу:");
        obj.filterWeight();
        System.out.println("Сортировка по 2 букве имени:");
        obj.sortName();
        System.out.println("Сортировка по произведению веса на возраст");
        obj.sortAge();
        System.out.println("Произведение всех весов:");
        obj.sum();
    }
}
