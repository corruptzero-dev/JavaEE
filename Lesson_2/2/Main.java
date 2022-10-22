package ru.corruptzero;

import java.util.Objects;

/*   TODO
     Пример upcast и downcast,
     реализовать equals и hashcode,
     перегрузку и переопределение методов,
     интерфейс от которого наследуется два класса,
     пример полиформизма (как ArrayList, LinkedList и List)
 */
class SomeParentClass implements SomeInterface {
    String name;

    void printData() {
        System.out.println("method of parent class");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeParentClass parentClass = (SomeParentClass) o;
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

class SomeChildClass extends SomeParentClass implements SomeInterface {
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
        SomeChildClass child = (SomeChildClass) o;
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
        SomeParentClass obj1 = new SomeChildClass();
        SomeParentClass obj2 = new SomeChildClass();
        obj2.printData();

        obj2 = new SomeParentClass();
        obj1.printData();
        obj2.printData();
        System.out.println("------");

        //Downcasting
        SomeParentClass p = new SomeChildClass();
        p.name = "parent";

        SomeChildClass c = (SomeChildClass) p;

        c.age = 18;
        System.out.println(c.name);
        System.out.println(c.age);
        c.printData();
    }
}
