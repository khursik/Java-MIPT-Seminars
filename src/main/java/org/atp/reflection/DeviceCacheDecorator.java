package org.atp.reflection;

import java.util.HashMap;
import java.util.Map;

public class DeviceCacheDecorator implements ElectricDevice {
    private final Map<String, Integer> cache = new HashMap<>();
    private final ElectricDevice device;

    public DeviceCacheDecorator(ElectricDevice device) {
        this.device = device;
    }

    @Override
    public int run(String arg) {
        return cache.computeIfAbsent(arg, device::run);
    }
}
