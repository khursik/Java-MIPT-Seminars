import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("15743", "38972867", "26572");

        MyStream<String> stream = MyStream.of(list);

        Map<Integer, String> map = stream
                .map(s -> s.replace("43", "@sberbank.ru"))
                .map(s -> s.length())
                .filter(i -> i > 10)
                .toMap(i -> i + 10, i -> "Correct!");

        for (String val : map.values()) {
            System.out.println(val);
        }

        System.out.println(map.get(25));
    }
}

