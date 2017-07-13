package by.training.reflection.impls;

import by.training.reflection.annotations.Equal;
import by.training.reflection.annotations.Proxy;
import by.training.reflection.interfaces.Car;

@Proxy(invocationHandler = "by.training.reflection.handlers.CarInvocationHandler")
public class CarImpl implements Car {
    @Equal(compareBy = Equal.Compare.VALUE)
    private String manufacturer;
    @Equal(compareBy = Equal.Compare.VALUE)
    private String model;
    @Equal(compareBy = Equal.Compare.VALUE)
    private int weight;

    public CarImpl() {
    }

    public CarImpl(String manufacturer, String model, int weight) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getInfo() {
        final String whitespace = " ";
        final String newLine = "\n";
        final String carWeight = ", weight is ";
        final String kg = " kg.";
        StringBuilder builder = new StringBuilder();
        builder.append(manufacturer)
                .append(whitespace)
                .append(model)
                .append(carWeight)
                .append(weight)
                .append(kg)
                .append(newLine);
        return builder.toString();
    }
}
