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
import java.util.Scanner;
public class Lab0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Square square = new Square("square");
        Circle circle = new Circle("circle");
        Triangle triangle = new Triangle("triangle");
        EquilateralTriangle eqTriangle = new EquilateralTriangle("Equilateral Triangle");

        //square
        System.out.printf("Enter square length: ");
        double sLen = sc.nextDouble();
        System.out.printf("Enter square height: ");
        double sHeight = sc.nextDouble();
        square.setDimensions(sLen, sHeight);

        System.out.printf("\nName: %s\nArea: %1.2f\t", square.getName(), square.getArea());
        square.printDimensions();

        //circle
        System.out.printf("\nEnter circle radius: ");
        double radius = sc.nextDouble();
        circle.setDimensions(radius);

        System.out.printf("\nName: %s\nArea: %1.2f\t\n", circle.getName(), circle.getArea());
        circle.printDimensions();

        //triangle
        System.out.printf("\nEnter triangle side 1: ");
        double tSide1 = sc.nextDouble();
        System.out.printf("Enter triangle side 2: ");
        double tSide2 = sc.nextDouble();
        System.out.printf("Enter triangle side 3: ");
        double tSide3 = sc.nextDouble();
        triangle.setDimensions(tSide1, tSide2, tSide3);

        System.out.printf("\nName: %s\nArea: %1.2f\t\n", triangle.getName(), triangle.getArea());
        triangle.printDimensions();

        //eqTriangle
        System.out.printf("\nEnter equilateral triangle side: ");
        double eqSide1 = sc.nextDouble();
        eqTriangle.setDimensions(eqSide1);

        System.out.printf("\nName: %s\nArea: %1.2f\t\n", eqTriangle.getName(), eqTriangle.getArea());
        eqTriangle.printDimensions();
    }
    
}
