package org.atp.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class CacheHandler implements InvocationHandler {
    private final Map<List<Object>, Object> cache = new HashMap<>();
    private final Object device;

    public CacheHandler(Object device) {
        this.device = device;
    }

    public static<T> T cache(T delegate) {
        return (T) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheHandler(delegate)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> key = toKey(method, args);
        return cache.computeIfAbsent(key, k -> {
            try {
                return method.invoke(device, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static List<Object> toKey(Method method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method.getName());
        key.addAll(Arrays.asList(args));
        return key;
    }
}
