package com.company.lists;

public interface MyList<E> extends MyIterable<E>{
    void add(E val);
    boolean remove(E val);
    int size();
    E get(int index);
}
