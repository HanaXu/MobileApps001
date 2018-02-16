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
public class Triangle extends Shape {

    private double s1, s2, s3;
    private double perimeter;

    public Triangle(String name) {
        super(name);
    }

    public void setDimensions(double s1, double s2, double s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        perimeter = s1 + s2 + s3;
    }

    @Override
    public void printDimensions() {
        System.out.printf("Side 1: %1.2f\t Side 2: %1.2f\t Side 3: %1.2f\n", s1, s2, s3);
    }

    @Override
    public double getArea() {
        double s = perimeter*0.5;
        return Math.sqrt(s * ((s - s1) * (s - s2) * (s - s3)));
    }
}
