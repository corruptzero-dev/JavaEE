package ru.corruptzero.pattern;

public class Main {
    public static void main(String[] args) {
        BillPughSingleton singleton1 = BillPughSingleton.getInstance();
        BillPughSingleton singleton2 = BillPughSingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
        LazyInitializedSingleton singleton3 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton singleton4 = LazyInitializedSingleton.getInstance();
        System.out.println(singleton3.equals(singleton4));
        DoubleCheckedSingleton singleton5 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton singleton6 = DoubleCheckedSingleton.getInstance();
        System.out.println(singleton5.equals(singleton6));
    }
}
