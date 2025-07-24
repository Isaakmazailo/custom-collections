public final class MyCollections {

    // Приватный конструктор, чтобы нельзя было создать экземпляр этого класса
    private MyCollections() {}
    public static <T extends Comparable<? super T>> void bubbleSort(MyArrayList<T> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Сравниваем два соседних элемента
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // Меняем их местами
                    T temp = list.get(j);
                    // Здесь нужен метод set, которого у нас нет. Давайте добавим его в MyArrayList!
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // Если на внутреннем цикле не было ни одной замены, значит массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }
}