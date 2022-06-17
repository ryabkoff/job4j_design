package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> oldHead = head;
        head = oldHead.next;
        T value = oldHead.value;
        oldHead.next = null;
        oldHead.value = null;
        return value;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public boolean revert() {
        boolean rsl = !isEmpty() && head.next != null;
        if (rsl) {
            Node<T> prev = null;
            Node<T> cur = head;
            Node<T> next;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head = prev;
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinked<Integer> fl = new ForwardLinked<>();
        fl.add(1);
        fl.add(2);
        fl.add(3);
        fl.add(4);
        fl.add(5);
        fl.revert();
    }
}