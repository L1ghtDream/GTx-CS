package dev.lightdream.gtxcs;

import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (head == null) {
            head = new Node<>(data);
            tail = head;
            size++;
            return;
        }

        Node<T> temp = head;
        Node<T> holder;
        for (int i = 0; i < index - 1 && temp.getNext() != null; i++) {
            temp = temp.getNext();
        }
        holder = temp.getNext();
        temp.setNext(new Node<>(data));
        temp.getNext()
                .setNext(holder);
        size++;

        //Update tail
        Node<T> current = head;
        for (int i = 0; i < size - 1; i++) {
            current = current.getNext();
        }
        tail = current;
    }

    @Override
    public T getAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            Node<T> output = head;
            head = head.getNext();
            size--;

            Node<T> current = head;
            for (int i = 0; i < size - 1; i++) {
                current = current.getNext();
            }
            tail = current;

            return output.getData();
        }

        Node<T> temp = head;
        for (int i = 0; i < index - 1 && temp.getNext() != null; i++) {
            temp = temp.getNext();
        }
        Node<T> output = temp.getNext();
        temp.setData(temp.getNext()
                .getNext()
                .getData());
        size--;

        //Update tail
        Node<T> current = head;
        for (int i = 0; i < size - 1; i++) {
            current = current.getNext();
        }
        tail = current;

        return output.getData();
    }

    @Override
    public T remove(T data) {
        boolean ok = false;

        for (int i = 0; i < size; i++) {
            if (getAtIndex(i).equals(data)) {
                removeAtIndex(i);
                ok = true;
            }
        }
        if(!ok){
            throw new NoSuchElementException();
        }
        size--;

        //Update tail
        Node<T> current = head;
        for (int i = 0; i < size - 1; i++) {
            current = current.getNext();
        }
        tail = current;

        return data;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
