package org.atp.stream;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Carry {
    public int sum(int x, int y, int z) {
        return x + y + z;
    }

    public IntFunction<IntFunction<IntUnaryOperator>> carry() {
        return x -> y -> z -> sum(x, y, z);
    }

    void run() {
        IntFunction<IntUnaryOperator> apply = carry().apply(10);
        IntUnaryOperator apply1 = apply.apply(2);
        int i = apply1.applyAsInt(1);
    }
}


