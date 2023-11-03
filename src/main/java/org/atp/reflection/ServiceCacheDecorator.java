package org.atp.reflection;

import java.util.HashMap;
import java.util.Map;

public class ServiceCacheDecorator implements Service {
    private final Map<Integer, Double> cache = new HashMap<>();
    private final Service service;

    public ServiceCacheDecorator(Service service) {
        this.service = service;
    }
    @Override
    public double work(int arg) {
        return cache.computeIfAbsent(arg, service::work);
    }
}
