package com.company.lists;

public class LinkedList<E> implements MyList<E>, MyIterable<E>{
    /**
     *  Указатель на первый узел
     */
    private Node<E> first;
    /**
     * Размер коллекции
     */
    private int size = 0;

    @Override
    public MyIterator<E> iterator() {
        return new StraightForwardIterator<>(first);
    }

    /**
     *  Добавление в конец списка
     */
    @Override
    public void add(E val) {
        addLast(val);
    }

    /**
     *  Удаление из списка
     */
    @Override
    public boolean remove(E val) {
        if (first.value.equals(val)) {
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }

        Node<E> prev = first;
        Node<E> current = first.next;
        while(current != null) {
            if (current.value.equals(val)) {
                prev.setNext(current.next);
                current.next.setPrev(prev);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    /**
     *  Размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *  Получить значение из списка по индексу
     */
    @Override
    public E get(int index) {
        int i = 0;
        MyIterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if(i == index) {
                return iterator.next();
            }
            iterator.next();
            i++;
        }
        return null;
    }

    /**
     *  Класс узла коллекции
     */
    private static class Node<E> {
        /**
         *  Значение
         */
        E value;
        /**
         *  Указатель на следующий узел
         */
        Node<E> next;
        /**
         *  Указатель на предыдущий узел
         */
        Node<E> prev;

        public Node(Node<E> prev ,E value, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        public void setVal(E val) {
            this.value = val;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /**
     *  Класс обхода коллекции
     */
    public static class StraightForwardIterator<E> implements MyIterator<E>{
        private Node<E> current;

        public StraightForwardIterator(Node<E> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E val = current.value;
            current = current.next;
            return val;
        }

        @Override
        public E prev() {
            E val = current.value;
            current = current.prev;
            return val;
        }
    }

    /**
     *  Создание нового узла и добавление его в конец списка
     */
    private void addLast(E val) {
        if (first == null) {
            first = new Node<>(null, val, null);
        } else {
            add(first, val);
        }
        size++;
    }

    /**
     *  Создание нового узла и добавление его в конец списка.
     *  Если не самый первый элемент.
     */
    private void add(Node<E> current, E val) {
        if (current.next == null) {
            current.next = new Node<>(current, val, null);
            return;
        }
        add(current.next, val);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                '}';
    }
}
