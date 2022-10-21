package ru.corruptzero;
/*  TODO
     Класс, в котором будет показана работа и создание всех примитивов в Java.
     Пример работы с переменными по значению и по ссылке.
 */
public class Main {
    public static void main(String[] args) {
        byte bt = 1;
        short s = 1000;
        int i = 100000;
        long l;
        l = i;
        l += 100000000L;
        char c = 'h';
        char c1 = 'i';
        boolean bl = false;
        double d = 3.14;
        float f = 1.03f;
        System.out.print(c);
        System.out.println(c1);
        System.out.println(bt + s + i + l);
        System.out.println(!bl);
        System.out.println(d+f);
    }
}