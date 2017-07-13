package by.training.reflection.analyzers;

import by.training.reflection.annotations.Equal;

import java.lang.reflect.Field;

public class ObjectsAnalyzer {
    public static boolean equalObjects(final Object obj1, final Object obj2) throws  IllegalAccessException {

        Field[] fieldsObj1 = obj1.getClass().getDeclaredFields();
        Field[] fieldsObj2 = obj2.getClass().getDeclaredFields();
        int obj1FieldsCount = fieldsObj1.length;
        int obj2FieldsCount = fieldsObj2.length;
        int annotationsCounter = 0;
        if (obj1FieldsCount != obj2FieldsCount | obj1FieldsCount == 0 | obj2FieldsCount == 0) {
            return false;
        }
        for (Field firstField : fieldsObj1) {
            firstField.setAccessible(true);
            for (Field secondField : fieldsObj2) {
                secondField.setAccessible(true);
                if (firstField.equals(secondField) && firstField.isAnnotationPresent(Equal.class)
                        && secondField.isAnnotationPresent(Equal.class)) {
                    annotationsCounter++;
                    Equal.Compare first = firstField.getAnnotation(Equal.class).compareBy();
                    Equal.Compare second = secondField.getAnnotation(Equal.class).compareBy();
                    if (first.equals(second)) {
                        Object o = firstField.get(obj1);
                        Object o1 = secondField.get(obj2);
                        if (first.name().equalsIgnoreCase("value")) {
                            if (!o.equals(o1)) {
                                return false;
                            }
                        }
                        if (first.name().equalsIgnoreCase("reference")) {
                            boolean eq = primitivesCompare(o, o1);
                            if (!eq) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (annotationsCounter == 0) {
            return false;
        }
        return true;
    }

    private static boolean primitivesCompare(final Object o1, final Object o2) {
        boolean eq;
        final String className = o1.getClass().getName();
        switch (className) {
            case "java.lang.Byte":
                byte a1;
                byte b1;
                a1 = (byte) o1;
                b1 = (byte) o2;
                eq = (a1 == b1);
                break;
            case "java.lang.Short":
                short a2;
                short b2;
                a2 = (short) o1;
                b2 = (short) o2;
                eq = (a2 == b2);
                break;
            case "java.lang.Character":
                char a3;
                char b3;
                a3 = (char) o1;
                b3 = (char) o2;
                eq = (a3 == b3);
                break;
            case "java.lang.Integer":
                int a4;
                int b4;
                a4 = (int) o1;
                b4 = (int) o2;
                eq = (a4 == b4);
                break;
            case "java.lang.Long":
                long a5;
                long b5;
                a5 = (long) o1;
                b5 = (long) o2;
                eq = (a5 == b5);
                break;
            case "java.lang.Float":
                float a6;
                float b6;
                a6 = (float) o1;
                b6 = (float) o2;
                eq = (a6 == b6);
                break;
            case "java.lang.Double":
                double a7;
                double b7;
                a7 = (double) o1;
                b7 = (double) o2;
                eq = (a7 == b7);
                break;
            case "java.lang.Boolean":
                boolean a8;
                boolean b8;
                a8 = (boolean) o1;
                b8 = (boolean) o2;
                eq = (a8 == b8);
                break;
            default:
                eq = (o1 == o2);
        }
        return eq;
    }

}
