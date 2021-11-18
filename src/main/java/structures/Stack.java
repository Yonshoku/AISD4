package main.java.structures;

public class Stack <T extends Comparable<T>> {
    LinkedList<T> items = new LinkedList<T>();

    public void push (T value) {
        items.push_back(value);
    }

    public void pop () {
        items.pop_back();
    }

    public T peek () {
        return items.getLast();
    }

    public int size() {
        return items.get_size();
    }

    @Override
    public String toString() {
        String str = "[";

        for (int i = 0; i < items.get_size(); i++) {
            if (items.getFirst() instanceof String) {
                str += (String) items.at(i) + ", ";
            } else if (items.getFirst() instanceof Integer) {
                str += items.at(i).toString() + ", ";
            }
        }

        if (str.length() >= 2) {
            str = str.substring(0, str.length() - ", ".length());
        }
        str += "]";

        return str;
    }

}
