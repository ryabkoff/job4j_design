package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> last;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        Node<E> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            last.next = node;
        }
        last = node;
        modCount++;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> point = head;
        for (int i = 0; i < index; i++) {
            point = point.next;
        }
        return point.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> point = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = point.value;
                point = point.next;
                return value;
            }
        };
    }

    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}