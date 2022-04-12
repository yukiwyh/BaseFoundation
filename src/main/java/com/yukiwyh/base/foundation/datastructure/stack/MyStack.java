package com.yukiwyh.base.foundation.datastructure.stack;

import java.util.Arrays;

public class MyStack {


    static class MyArrayStack {
        private int[] container;
        private int index;

        public MyArrayStack() {
            this.container = new int[15];
            this.index = 0;
        }

        public void push(int data) {
            if (index >= container.length) {
                expand();
            }
            this.container[index++] = data;
        }

        private void expand() {
            System.out.println("expand container...");
            this.container = Arrays.copyOf(container, (container.length << 1) - 1);
        }

        public int pop() {
            if (index <= 0) {
                throw new RuntimeException("stack is empty");
            }
            return this.container[--index];
        }

        public boolean isEmpty() {
            return index == 0;
        }

    }


    public static void main(String[] args) {
        MyArrayStack stack1 = new MyArrayStack();
        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }
        System.out.println("stack1 push finish");

        MyArrayStack stack2 = new MyArrayStack();
        for (int i = 0; i < 50; i++) {
            stack2.push(i);
            if (i % 3 == 0)
                continue;
            if (i == 10) {
                while (!stack2.isEmpty()) {
                    System.out.print(stack2.pop() + " -> ");
                }
                System.out.println();
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " -> ");
        }
        System.out.println();
    }
}
