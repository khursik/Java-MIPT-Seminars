package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("15743", "38972867", "26572");

        Stream<String> stream = Stream.of(list);

        Map<Integer, Boolean> map = stream
                .map(s -> s.replace("43", "@sberbank.ru"))
                .map(s -> s.length())
                .filter(i -> i > 10)
                .toMap(i -> i + 10, i -> i % 2 == 0);
        System.out.println(map.toString());
    }
}