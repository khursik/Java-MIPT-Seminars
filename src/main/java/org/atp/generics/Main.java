package org.atp.generics;

import java.util.ArrayList;
import java.util.List;

/*
Пример без дженериков. Что здесь может быть не так?
(Можно попробовать запустить -- словите ClassCastException)
- стр.13 -- мы ожидаем, что придёт в переменную "o" тип Integer,
нам приходит тип String и на этапе компиляции у нас нет возможности убрать эти ошибки.
Суть дженериков в следующем: если код компилируется, то в runtime'e не должно быть exception'ов.
Как дженерики решают эту проблему см. ниже класс MainGenerics.
Если List в методе createElements() (и в 17 строке тоже) параметризуем Integer'ом, то
компилятор будет подчеркивать те строки, в которые мы хотим добавить тип, отличный
от Integer'а. Таким образом, используя дженерики, мы себя обезопасили на стадии компиляции
от exception'ов в runtime'e
(Можно раскоментить код (35-49стр) и увидеть, что компилятор в случаепримера
с дженериками будет ругаться на строки 26 и 30).
 */
public class Main {
    public static void main(String[] args) {
        List elements = createElements();
        Integer o = (Integer) elements.get(0);
    }
    private static List createElements() {
        List list = new ArrayList();
        list.add("1");
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1.d);
        return list;
    }
}

//public class MainGenerics {
//    public static void main(String[] args) {
//        List<Integer> elements = createElements();
//        Integer o = (Integer) elements.get(0);
//    }
//    private static List<Integer> createElements() {
//        List<Integer> list = new ArrayList<>();
//        list.add("1");
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1.d);
//        return list;
//    }
//}