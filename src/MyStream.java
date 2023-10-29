import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    private final Collection<T> collection;

    public MyStream(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> MyStream of(Collection<T> collection) {
        return new MyStream<T>(collection);
    }

    public <E> MyStream<E> map(Function<T, E> function) {
        Collection<E> res = new ArrayList<>();
        for (T t : collection) {
            res.add(function.apply(t));
        }
        return new MyStream<>(res);
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        Collection<T> res = new ArrayList<>();
        for (T t : collection) {
            if (predicate.test(t)) {
                res.add(t);
            }
        }
        return new MyStream<T>(res);
    }

    public List toList() {
        return new ArrayList<>(collection);
    }

    public <K, V> Map<K, V> toMap(Function<T, K> keyFunction, Function<T, V> valueFunction) {
        HashMap<K, V> res = new HashMap<>();
        for (T t : collection) {
            res.put(keyFunction.apply(t), valueFunction.apply(t));
        }
        return res;
    }
}
