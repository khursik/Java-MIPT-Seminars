package org.atp.generics;

import java.util.ArrayList;
import java.util.List;

/*
������ ��� ����������. ��� ����� ����� ���� �� ���?
(����� ����������� ��������� -- ������� ClassCastException)
- ���.13 -- �� �������, ��� ����� � ���������� "o" ��� Integer,
��� �������� ��� String � �� ����� ���������� � ��� ��� ����������� ������ ��� ������.
���� ���������� � ���������: ���� ��� �������������, �� � runtime'e �� ������ ���� exception'��.
��� ��������� ������ ��� �������� ��. ���� ����� MainGenerics.
���� List � ������ createElements() (� � 17 ������ ����) ������������� Integer'��, ��
���������� ����� ������������ �� ������, � ������� �� ����� �������� ���, ��������
�� Integer'�. ����� �������, ��������� ���������, �� ���� ����������� �� ������ ����������
�� exception'�� � runtime'e
(����� ������������ ��� (35-49���) � �������, ��� ���������� � �������������
� ����������� ����� �������� �� ������ 26 � 30).
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