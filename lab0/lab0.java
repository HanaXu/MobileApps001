import java.util.Scanner;

public class lab0{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		Shape square = new Square("square");
		Shape circle = new Circle("circle");
		Shape triangle = new Triangle("triangle");
		Shape eqTriangle = new EquilateralTriangle("Equilateral Triangle");
		
		//square
		System.out.printf("Enter square length: ");
		double sLen = sc.nextDouble();
		System.out.printf("\nEnter square height: ");
		double sHeight = sc.nextDouble();
		square.setDimensions(sLen, sHeight);
		
		
		System.out.printf("Name: %s\n Area: %1.2f", square.getName(), square.getArea());
		square.printDimensions();
		
		//circle
		System.out.printf("Enter circle radius: ");
		double radius = sc.nextDouble();
		circle.setDimensions(radius);
		
		System.out.printf("Name: %s\n Area: %1.2f", circle.getName(), circle.getArea());
		circle.printDimensions();
		
		//triangle
		System.out.printf("Enter triangle side1: ");
		double tSide1 = sc.nextDouble();
		System.out.printf("\nEnter triangle side2: ");
		double tSide2 = sc.nextDouble();
		System.out.printf("\nEnter triangle side3: ");
		double tSide3 = sc.nextDouble();
		triangle.setDimensions(tSide1, tSide2, tSide3);
		
		System.out.printf("Name: %s\n Area: %1.2f", triangle.getName(), triangle.getArea());
		triangle.printDimensions();
		
		//eqTriangle
		System.out.printf("Enter equilateral triangle side: ");
		double eqSide1 = sc.nextDouble();
		eqTriangle.setDimensions(eqSide1);
		
		System.out.printf("Name: %s\n Area: %1.2f", eqtriangle.getName(), eqtriangle.getArea());
		eqtriangle.printDimensions();
	}
}