package org.mystream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream<T> {
    public Stream(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> Stream<T> of(Collection<T> collection) {
        return new Stream<T>(collection);
    }

    public <U> Stream<U> map(Function<? super T, U> function) {
        Collection<U> list = new ArrayList<>();
        for (T value : collection) {
            list.add(function.apply(value));
        }
        return of(list);
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        Collection<T> list = new ArrayList<>();
        for (T value : collection) {
            if (predicate.test(value)) {
                list.add(value);
            }
        }
        return of(list);
    }

    public List<T> toList() {
        List<T> list;
        if (collection instanceof List<? extends T>) {
            list = (List<T>) collection;
        }
        else {
            list = new ArrayList<>(collection);
        }
        return list;
    }

    public <U, V> Map<U, V> toMap(Function<? super T, U> keyFunction, Function<? super T, V> valueFunction) {
        Map<U, V> map = new HashMap<>();
        for (T value : collection) {
            map.put(keyFunction.apply(value), valueFunction.apply(value));
        }
        return map;
    }

    private final Collection<T> collection;
}
