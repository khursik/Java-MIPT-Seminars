package org.atp.generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static<E> E max(List<E> list, Comparator<E> comparator) {
        // E - работа с коллекциями
        // K, V - key, value
        // T -  если не подошло всё остальное
        E max = list.get(0);
        for (E current : list) {
            if (comparator.compare(max, current) < 0) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("A", 1),
                new Person("B", 2),
                new Person("C", 12)
        );
       Person max = max(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i !=0) return i;
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        System.out.println(max);

    }
}
