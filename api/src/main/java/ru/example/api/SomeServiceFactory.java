package ru.example.api;

import ru.example.api.exception.SomeServiceFactoryException;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Фабрика сервиса
 */
public class SomeServiceFactory {

    private static volatile SomeService serviceInstance;

    /**
     * Возвращает экземпляр сервиса
     * <p>
     * Либо возвращает существующий экземпляр сервиса либо сначала пытается его загрузить при помощи SPI
     *
     * @param classLoader загрузчик классов для SPI
     * @return сервис
     */
    public SomeService getService(ClassLoader classLoader) throws SomeServiceFactoryException {
        SomeService service = serviceInstance;
        if (service == null) {
            synchronized (SomeServiceFactoryHolder.class) {
                service = serviceInstance;
                if (service == null) {
                    Iterator<SomeService> it = ServiceLoader.load(SomeService.class, classLoader).iterator();
                    while (it.hasNext()) {
                        serviceInstance = service = it.next();
                    }
                }
            }
        }
        if (service == null) {
            throw new SomeServiceFactoryException("Can not locate implementation of SomeService at class loader");
        }
        return service;
    }

    private SomeServiceFactory() {
    }

    public static SomeServiceFactory instance() {
        return SomeServiceFactoryHolder.INSTANCE;
    }

    static class SomeServiceFactoryHolder {
        static private SomeServiceFactory INSTANCE = new SomeServiceFactory();
    }
}
