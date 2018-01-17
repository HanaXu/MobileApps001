public class Circle extends Shape{
	private double radius;
	
	public Circle(String name){
		super(name);
	}
	
	public void setDimensions(double r){
		radius = r;
	}
	
	@Override
	public void printDimensions(){
		System.out.printf("Radius: %1.2f", radius);
	}
	
	@Override
	public double getArea(){
		return Math.PI*(radius*radius);
	}
}