package ru.job4j.collection;

import java.util.Iterator;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    @Override
    public void add(E value) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}