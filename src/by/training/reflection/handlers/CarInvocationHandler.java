package by.training.reflection.handlers;

import by.training.reflection.interfaces.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarInvocationHandler implements InvocationHandler {
    private Car car;

    public CarInvocationHandler(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String getInfoMethod = "getInfo";
        final String methodName = method.getName();
        if (getInfoMethod.equals(methodName)) {
            System.out.print("(Proxy object)\nManufacturer and model is ");
        }
        return method.invoke(car, args);
    }
}
