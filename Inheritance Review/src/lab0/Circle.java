/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab0;

/**
 *
 * @author tug11775
 */
public class Circle extends Shape {

    private double radius;

    public Circle(String name) {
        super(name);
    }

    public void setDimensions(double r) {
        radius = r;
    }

    @Override
    public void printDimensions() {
        System.out.printf("Radius: %1.2f\n", radius);
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }
}
