import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Конструктор по умолчанию
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // Конструктор, принимающий другую коллекцию
    public MyArrayList(Collection<? extends T> c) {
        this.elementData = c.toArray();
        this.size = c.size();
    }

    /**
     * Добавляет элемент в конец списка.
     */
    public void add(T element) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elementData[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     */
    public T remove(int index) {
        checkIndex(index);

        @SuppressWarnings("unchecked")
        T oldValue = (T) elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // Очищаем ссылку для сборщика мусора

        return oldValue;
    }

    /**
     * Добавляет все элементы из другой коллекции в конец этого списка.
     */
    public void addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew > elementData.length - size) {
            elementData = Arrays.copyOf(elementData, elementData.length + numNew);
        }
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
    }

    // --- ПРАВИЛЬНОЕ МЕСТО ДЛЯ МЕТОДА SET ---
    /**
     * Заменяет элемент в указанной позиции на новый.
     * @param index индекс элемента, который нужно заменить.
     * @param element новый элемент.
     */
    public void set(int index, T element) {
        checkIndex(index);
        elementData[index] = element;
    }
    // ------------------------------------

    /**
     * Возвращает количество элементов в списке.
     */
    public int size() {
        return size;
    }

    // Вспомогательный метод для увеличения размера внутреннего массива
    private void grow() {
        int newCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // Вспомогательный метод для проверки корректности индекса
    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i == size - 1) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
        return "[]";
    }

    // Этот метод нужен, чтобы можно было использовать список в цикле for-each
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) elementData[currentIndex++];
            }
        };
    }
}