package by.training.reflection.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface Proxy {
    String invocationHandler();
}
