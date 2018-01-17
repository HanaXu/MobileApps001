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
public class Square extends Shape {

    private double length;
    private double height;

    public Square(String name) {
        super(name);
    }

    public void setDimensions(double len, double h) {
        length = len;
        height = h;
    }

    @Override
    public void printDimensions() {
        System.out.printf("Length: %1.2f\t Height: %1.2f\n", length, height);
    }

    @Override
    public double getArea() {
        return length * height;
    }
}
