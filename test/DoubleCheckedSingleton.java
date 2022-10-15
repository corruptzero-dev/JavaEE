package ru.corruptzero.pattern;

public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;
    static DoubleCheckedSingleton getInstance() {
        DoubleCheckedSingleton current = instance;
        if (current == null) {
            synchronized (DoubleCheckedSingleton.class) {
                current = instance;
                if (current == null) {
                    instance = current = new DoubleCheckedSingleton();
                }
            }
        }
        return current;
    }
}