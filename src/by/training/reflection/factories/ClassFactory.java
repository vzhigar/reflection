package by.training.reflection.factories;

import by.training.reflection.annotations.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

public class ClassFactory {
    @SuppressWarnings("unchecked")
    public static <T> T getInstanceOf(final Class<?> clazz) {
        T object = null;
        try {
            object = (T) Class.forName(clazz.getName()).newInstance();
            if (object.getClass().isAnnotationPresent(Proxy.class)) {
                String handlerName = object.getClass().getAnnotation(Proxy.class).invocationHandler();
                Class handlerClass = Class.forName(handlerName);
                object = (T) java.lang.reflect.Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                        (InvocationHandler) handlerClass.getConstructor(clazz.getInterfaces()).newInstance(object));
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            return object;
        }
        return object;
    }
}
