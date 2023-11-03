package org.atp.stream;

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
        return new Stream<>(collection);
    }

    public <V> Stream<V> map(Function<? super T, V> function) {
        Collection<V> result = new ArrayList<>();
        for (T element : collection) {
            result.add(function.apply(element));
        }
        return new Stream<>(result);
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        Collection<T> result = new ArrayList<>();
        for (T element : collection) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return new Stream<>(result);
    }

    public List<T> toList() {
        return List.copyOf(new ArrayList<>(collection));
    }

    public <K, V> Map<K, V> toMap(Function<? super T, K> keyFunction, Function<? super T, V> valueFunction) {
        Map<K, V> map = new HashMap<>();
        for (T element : collection) {
            map.put(keyFunction.apply(element), valueFunction.apply(element));
        }
        return map;
    }

/*
        "Stream" class usage example:

        public static void main(String[] args) {
            List<String> list = List.of("15743", "38972867", "26572");

            Stream<String> stream = Stream.of(list);

            Map<Integer, Boolean> map = stream
                    .map(s -> s.replace("43", "@sberbank.ru"))
                    .map(s -> s.length())
                    .filter(i -> i > 10)
                    .toMap(i -> i + 10, i -> i % 2 == 0);
    }*/
}
