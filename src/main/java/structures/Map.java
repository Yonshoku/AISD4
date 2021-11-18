package main.java.structures;

import java.util.Iterator;

public class Map <K extends Comparable<K>, V extends Comparable<V>> {
    private List<K> keys = new List<K>();
    private List<V> values = new List<V>();

    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
    }

    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys.get(i)) return values.get(i);
        }

        return null;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key.compareTo(keys.get(i)) == 0) return true;
        }

        return false;
    }

    public int size() {
        return keys.size();
    }

    public K getKeyByIndex(int index) { return keys.get(index); }
    public V getValueByIndex(int index) { return values.get(index); }
}

