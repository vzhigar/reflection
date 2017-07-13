package by.training.reflection;

import by.training.reflection.analyzers.ObjectsAnalyzer;
import by.training.reflection.beans.Student;
import by.training.reflection.factories.ClassFactory;
import by.training.reflection.impls.CarImpl;
import by.training.reflection.interfaces.Car;

public class Runner {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Car car = ClassFactory.getInstanceOf(CarImpl.class);
        car.setModel("M3");
        car.setManufacturer("BMW");
        car.setWeight(1834);
        System.out.println(car.getInfo());
        Car car1 = new CarImpl("Audi", "A4", 1673);
        Car car2 = new CarImpl("Audi", "A4", 1673);
        boolean b = ObjectsAnalyzer.equalObjects(car1, car2);
        System.out.println(b);
        Student student = new Student("aaa", "bbb", 19.5, true);
        Student student1 = new Student("aaa", "bbb", 19.5, true);
        System.out.println(ObjectsAnalyzer.equalObjects(student, student1));

    }

}
