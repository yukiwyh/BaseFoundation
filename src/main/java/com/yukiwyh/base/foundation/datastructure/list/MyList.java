package com.yukiwyh.base.foundation.datastructure.list;

import java.util.Iterator;

public class MyList {

    private static class LinkList<E> implements Iterable<E> {

        private Node<E> head;
        private Node<E> tail;
        private int size = 0;

        public LinkList() {
        }

        public void add(E e) {
            Node<E> node = new Node<>(e, null);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
            size++;
        }

        public void remove(int index) {
            if (index >= size) {
                throw new RuntimeException("out of index");
            }
            int countIndex = 0;
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                if (index == countIndex) {
                    iterator.remove();
                    size--;
                    break;
                }
                iterator.next();
                countIndex++;
            }
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<>() {
                private Node<E> prev;
                private Node<E> index = head;

                @Override
                public boolean hasNext() {
                    return index != null;
                }

                @Override
                public E next() {
                    prev = index;
                    index = index.next;
                    return prev.val;
                }

                @Override
                public void remove() {
                    if (index == head) {
                        head = head.next;
                    } else {
                        prev.next = index.next;
                    }
                }
            };
        }
    }

    private static class Node<E> {
        private final E val;
        private Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        for (Integer i : linkList) {
            System.out.print(i + " -> ");
        }
        System.out.println();

        linkList.remove(0);

        for (Integer i : linkList) {
            System.out.print(i + " -> ");
        }
        System.out.println();

        linkList.remove(5);

        for (Integer i : linkList) {
            System.out.print(i + " -> ");
        }
        System.out.println();

    }
}
