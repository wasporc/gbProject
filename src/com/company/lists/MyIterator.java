package com.company.lists;

public interface MyIterator<E> {
    boolean hasNext();
    E next();
    E prev();
}
