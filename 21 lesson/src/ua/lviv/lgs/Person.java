package ua.lviv.lgs;

public class Person {
    @MyAnnotation(value = "Name")
    String name;

    int age;

    @MyAnnotation(value = "Age")
    public void setAge(int age) {
        this.age = age;
    }
}
