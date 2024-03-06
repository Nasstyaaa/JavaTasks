package Pr3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование testSet:");
        testSet mySet = new testSet();

        mySet.add("Apple");
        mySet.add("Banana");
        mySet.add("Cherry");
        mySet.add("Apple");

        System.out.println("Размер множества: " + mySet.size());
        System.out.println("Содержит 'Apple'? " + mySet.contains("Apple"));
        mySet.remove("Banana");
        System.out.println("Размер множества после удаления: " + mySet.size());
        System.out.println("Содержит 'Banana'? " + mySet.contains("Banana"));
        mySet.clear();
        System.out.println("Размер множества после очистки: " + mySet.size() +"\n");

        System.out.println("Тестирование testMap:");
        testMap map = new testMap();
        if (map.isEmpty()) {
            System.out.println("Размер множества: " + map.size());
            map.put("key1", "value1");
            System.out.println("Размер множества после добавления: " + map.size());
            if (map.containsKey("key1") && map.containsValue("value1")) {
                System.out.println("Множество заполнено");
            }

            map.remove("key1");
            System.out.println("Размер множества после очистки: " + map.size());
            if (!map.containsKey("key1") && !map.containsValue("value1")) {
                System.out.println("Множество очищено");
            }
        }
    }
}

