package org.atp.stream;

public class Child extends Parent {
    private final String name;
    private final Integer age;

    public Child(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
