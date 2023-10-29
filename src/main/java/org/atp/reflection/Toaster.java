package org.atp.reflection;

public class Toaster implements ElectricDevice {

    @Override
    public int run(String arg) {
        try {
            Thread.sleep(2_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return arg.hashCode();
    }
}
/*public class Toaster implements ElectricDevice {
    private final Map<String, Integer> cache = new HashMap<>();

    @Override
    public int run(String arg) {
        return cache.computeIfAbsent(arg, this::doRun);
    }

    private int doRun(String arg) {
        try {
            Thread.sleep(2_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return arg.hashCode();
    }
}*/
