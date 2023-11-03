package org.atp.reflection;

import java.util.Comparator;

import static org.atp.reflection.CacheHandler.cache;

public class Main {
    public static void main(String[] args) {
//        ElectricDevice device = new DeviceCacheDecorator(new Toaster());
        ElectricDevice device = cache(new Toaster());
        Comparator<Integer> i = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        Comparator<Integer> i2 = (o1, o2) -> Integer.compare(o1, o2);
//        ElectricDevice device1 = new Toaster();
//        ElectricDevice device2 = new Toaster2();
//        device2.run("efnw");

        System.out.println(device.run("Hello"));
        System.out.println(device.run("Mark!"));
        System.out.println(device.run("Greg"));
        System.out.println(device.run("Hello"));
        System.out.println(device.run("Hello"));
        System.out.println(device.run("Hello"));
//        device.run("Hello");
//        device.run("Hello");
    }
}
