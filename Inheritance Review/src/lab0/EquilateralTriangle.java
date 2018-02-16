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
public class EquilateralTriangle extends Triangle {

    private double s1;

    public EquilateralTriangle(String name) {
        super(name);
    }

    public void setDimensions(double s1) {
        this.s1 = s1;
    }

    @Override
    public void printDimensions() {
        System.out.printf("Side: %1.2f\n", s1);
    }

    @Override
    public double getArea() {
        return (Math.sqrt(3) / 4) * s1 * s1;
    }
}
