package by.training.reflection.beans;

import by.training.reflection.annotations.Equal;

public class Student {
    @Equal(compareBy = Equal.Compare.VALUE)
    private String name;
    private String address;
    @Equal(compareBy = Equal.Compare.VALUE)
    private double age;
    @Equal(compareBy = Equal.Compare.VALUE)
    private boolean isGone;

    public Student() {
    }

    public Student(String name, String address, double age, boolean isGone) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.isGone = isGone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isGone() {
        return isGone;
    }

    public void setGone(boolean gone) {
        isGone = gone;
    }
}
