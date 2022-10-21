package ru.corruptzero;

import java.util.Objects;

/*  TODO
     Пример upcast и downcast,
     реализовать equals и hashcode,
     перегрузку и переопределение методов,
     интерфейс от которого наследуется два класса,
     пример полиформизма (как ArrayList, LinkedList и List)
 */
class Parent implements SomeInterface {
    String name;

    void printData() {
        System.out.println("method of parent class");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(name, parent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void someMethod() {
        System.out.println("someMethod");
    }
}

class Child extends Parent implements SomeInterface {
    int age;

    @Override
    void printData() {
        System.out.println("method of child class");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Child child = (Child) o;
        return age == child.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }


    @Override
    public void someMethod() {
        System.out.println("someMethod");
    }
}

public class Main {
    public static void main(String[] args) {
        //Upcasting and polymorphism
        Parent obj1 = new Child();
        Parent obj2 = new Child();
        obj2.printData();

        obj2 = new Parent();
        obj1.printData();
        obj2.printData();
        System.out.println("------");

        //Downcasting
        Parent p = new Child();
        p.name = "parent";

        Child c = (Child) p;

        c.age = 18;
        System.out.println(c.name);
        System.out.println(c.age);
        c.printData();
    }
}