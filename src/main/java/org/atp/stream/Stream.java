package org.atp.stream;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


public class Stream<T> {
    private final Collection<T> collection;

    public Stream(Collection<T> collection) {
        this.collection = collection;
    }

    public static <U> Stream<U> of(Collection<U> collection) {
        return new Stream<U>(collection);
    }

    public <R> Stream<R> map(Function<T, R> function) {
        Collection<R> newCollection = new ArrayList<>();
        for (T item: collection) {
            newCollection.add(function.apply(item));
        }
        return new Stream<>(newCollection);
    }

    public Stream<T> filter(Predicate<T> predicate) {
        Collection<T> newCollection = new ArrayList<>();
        for (T item: collection) {
            if (predicate.test(item)) {
                newCollection.add(item);
            }
        }
        return new Stream<>(newCollection);
    }

    public List<T> toList() {
        return new ArrayList<>(collection);
    }

    public <K, V> Map<K, V> toMap(Function<T, K> keyFunction, Function<T, V> valueFunction) {
        HashMap<K, V> res = new HashMap<>();
        for (T item: collection) {
            res.put(keyFunction.apply(item), valueFunction.apply(item));
        }
        return res;
    }


    //        "Stream" class usage example:
    public static void main(String[] args) {
        List<String> list = List.of("15743", "38972867", "26572");

        Stream<String> stream = Stream.of(list);

        Map<Integer, Boolean> map = stream
                .map(s -> s.replace("43", "@sberbank.ru"))
                .map(String::length)
                .filter(i -> i > 10)
                .toMap(i -> i + 10, i -> i % 2 == 0);

        System.out.println(map);
    }
}
