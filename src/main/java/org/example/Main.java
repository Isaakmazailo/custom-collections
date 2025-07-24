import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- 1. Создание и наполнение списка ---");

        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(5);
        myList.add(1);
        myList.add(8);
        myList.add(3);
        myList.add(2);

        System.out.println("Неотсортированный список: " + myList);
        System.out.println("Размер списка: " + myList.size());

        System.out.println("\n--- 2. Сортировка списка ---");
        MyCollections.bubbleSort(myList);
        System.out.println("Отсортированный список: " + myList);

        System.out.println("\n--- 3. Проверка удаления и получения элемента ---");
        Integer element = myList.get(2);
        System.out.println("Элемент по индексу 2: " + element);

        myList.remove(2);
        System.out.println("Список после удаления элемента с индексом 2: " + myList);

        System.out.println("\n--- 4. Проверка конструктора, принимающего коллекцию ---");
        List<Integer> standardList = List.of(100, 200, 300);
        MyArrayList<Integer> listFromAnotherCollection = new MyArrayList<>(standardList);
        System.out.println("Список, созданный из другой коллекции: " + listFromAnotherCollection);
    }
}
