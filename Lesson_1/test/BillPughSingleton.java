package ru.corruptzero.pattern;

public class BillPughSingleton {

    private BillPughSingleton(){}   // Приватный конструктор
    
    private static class SingletonHelper {    // Приватный статический класс, который загружается в память только при вызове getInstance
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
