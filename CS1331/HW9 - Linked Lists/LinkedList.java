/*I worked on the homework assignment alone, using only course materials*/
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 *Linked List Class
 *@author JhaDeya Rhymes
 *@version 1.0
 *@param <T> linkedlist datatype
 **/
public class LinkedList<T> {
    private Node<T> head;
    private int size;
    /**
     *Made a constructor
     **/
    public LinkedList() {
        head = null;
        size = 0;
    }
    /**
     *Method adds to list at index
     *@param data data to adds
     *@param index index to add
     **/
    public void  addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds.");
        } else {
            if (index == 0) {
                head = new Node<T>(data, head);
                size = size + 1;
            } else {
                Node<T> cursor = head;
                for (int i = 0; i < (index - 1); i++) {
                    cursor = cursor.getNext();
                }
                Node<T> temporary = cursor.getNext();
                cursor.setNext(new Node<T>(data, temporary));
                size = size + 1;
            }
        }
    }
    /**
     *Method removes at Index
     *@param index index to remove
     *@return removed node
     **/
    public T removeFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        T removedData = null;
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            size = size - 1;
            return removedData;
        }
        Node<T> cursor = head;
        for (int i = 0; i < (index - 1); i++) {
            cursor = cursor.getNext();
        }
        size = size - 1;
        removedData = cursor.getNext().getData();
        cursor.setNext(cursor.getNext().getNext());
        return removedData;
    }
    /**
     *Method to clear list
     **/
    public void clear() {
        if (head == null) {
            throw new NoSuchElementException("The list is already clear.");
        }
        head = null;
        size = 0;

    }
    /**
     *Getter Method
     *@param index index to get
     *@return data
     **/
    public T get(int index) {
        Node<T> cursor = head;
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds.");
        } else {
            if (index == 0) {
                return head.getData();
            }
            for (int i = 0; i < (index); i++) {
                cursor = cursor.getNext();
            }
            return cursor.getData();
        }
    }
    /**
     *Method checks if isEmpty
     *@return boolean
     **/
    public boolean isEmpty() {
        return (head == null);
    }
    /**
     *Method converts linkedlist to arraylist
     *@return arraylist
     **/
    public ArrayList<T> toArrayList() {
        Node<T> cursor = head;
        ArrayList<T> arr = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            arr.add(cursor.getData());
            cursor = cursor.getNext();
        }
        return arr;
    }
    /**
     *Method creates new LinkedList of Strings
     *@return LinkedList
     **/
    public LinkedList<String> fizzBuzzLinkedList() {
        Node<T> cursor = head;
        int num = 0;
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < size; i++) {
            num = i + 1;
            String nts = Integer.toString(num);
            if (num % 3 == 0 && num % 5 != 0) {
                list.addAtIndex("Fizz", i);
                cursor = cursor.getNext();
            } else if (num % 3 != 0 && num % 5 == 0) {
                list.addAtIndex("Buzz", i);
                cursor = cursor.getNext();
            } else if (num % 3 == 0 && num % 5 == 0) {
                list.addAtIndex("FizzBuzz", i);
                cursor = cursor.getNext();
            } else {
                list.addAtIndex(nts + ": " + cursor.getData() , i);
                cursor = cursor.getNext();
            }
        }
        return list;
    }
}
