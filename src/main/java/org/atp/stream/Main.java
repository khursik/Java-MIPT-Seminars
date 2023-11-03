package org.atp.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Main {
    public List<Child> collect1(List<Parent> parents) {
        return parents.stream()
                .map(Parent::getChild)
                .filter(c -> c.getAge() >= 18)
                .distinct()
                .collect(toList());
    }

    public List<Child> collect2(List<Parent> parents) {
        return parents.stream()
                .map(Parent::getChild)
                .filter(c -> c.getName().equals("Alex"))
                .distinct()
                .collect(toList());
    }

    public List<Child> collectChildrenFrom(List<Parent> parents, Predicate<Child> predicate) {
        return parents.stream()
                .map(Parent::getChild)
                .filter(c -> c.getAge() >= 18)
                .distinct()
                .collect(toList());
    }

    public void run() {
        List<Parent> parents = new ArrayList<>();

        collectChildrenFrom(parents, olderThan(12));
        collectChildrenFrom(parents, olderThan(8));
        collectChildrenFrom(parents, c -> c.getName().equals("Dima"));

        collectChildrenFrom(parents, withName("Dima"));
        collectChildrenFrom(parents, olderThan(18));
        collectChildrenFrom(parents, olderThan(78));
    }

    private static Predicate<Child> olderThan(Integer age) {
        return c -> c.getAge() >= age;
    }

    private static Predicate<Child> withName(String name) {
        return c -> c.getName().equals(name);
    }
}
