package com.company.lists;

import java.util.Arrays;

public class ArrayList<E> implements MyList<E> {
    /**
     *  Количество элементов в массиве
     */
    private int size = 0;
    /**
     *  Размер массива
     */
    private int capacity;
    /**
     *  Размер массива по умолчанию
     */
    private static final int CAPACITY = 16;
    /**
     *  Массив объектов
     */
    private Object[] array;

    public ArrayList() {
        this.capacity = CAPACITY;
        this.array = new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    @Override
    public MyIterator<E> iterator() {
        return null;
    }

    /**
     *  Добавление в конец массива
     */
    @Override
    public void add(E val) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size++] = val;
    }

    /**
     *  Удаление из массива
     */
    @Override
    public boolean remove(E val) {
        if (size == 0) {
            return false;
        }
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(val)) {
                break;
            }
        }
        if (i < size) {
            size--;
            if (size <= 0) {
                return false;
            }
            if (size != i) {
                System.arraycopy(array, i + 1, array, i, size - i);
            }
            array[size] = null;
        }
        return false;
    }

    /**
     *  Количество объектов в массиве
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *  Получить объект по индексу
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if ((index < size) && (index >= 0)) {
            return (E) array[index];
        }
        return null;
    }

    /**
     *  Увеличение размера массива
     */
    private void increaseCapacity() {
        capacity = capacity * 2;
        array = Arrays.copyOf(array, capacity);
    }
}
