package org.example;

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

    public static <T> Stream<T> of(Collection<T> collection) {
        return new Stream<T>(collection);
    }

    public <R> Stream<R> map(Function<? super T, R> function) {
        ArrayList<R> list = new ArrayList<>();
        for (T value : collection) {
            list.add(function.apply(value));
        }
        return of(list);
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        ArrayList<T> list = new ArrayList<>();
        for (T value : collection) {
            if (predicate.test(value)) {
                list.add(value);
            }
        }
        return of(list);
    }

    public List<T> toList() {
        List<T> list;
        if (collection instanceof List<? extends T>)
            list = (List<T>) collection;
        else
            list = new ArrayList<>(collection);
        return list;
    }

    public <K, V> Map<K, V> toMap(Function<? super T, K> keyFunction, Function<? super T, V> valueFunction) {
        Map<K, V> map = new HashMap<>();
        for (T value : collection) {
            map.put(keyFunction.apply(value), valueFunction.apply(value));
        }
        return map;
    }
}