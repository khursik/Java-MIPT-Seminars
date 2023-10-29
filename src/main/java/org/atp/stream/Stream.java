package org.atp.stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream {
    private final Collection collection;
    public Stream(Collection collection) {
        this.collection = collection;
    }

    public static Stream of(Collection collection) {
        return null;
    }

    public Stream map(Function function) {
        return null;
    }

    public Stream filter(Predicate predicate) {
        return this;
    }

    public List toList() {
        return null;
    }

    public Map toMap(Function keyFunction, Function valueFunction) {
        return null;
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
