public class EquilateralTriangle extends Triangle{
	private double s1;
	
	public EquilateralTriangle(String name){
		super(name);
	}
	
	public void setDimensions(double s1){
		this.s1 = s1;
	}
	
	@Override
	public void printDimensions(){
		System.out.printf("Side 1: %1.2f", s1);
	}
	
	@Override
	public double getArea(){
		return (Math.sqrt(3)/4)*s1*s1;
	}
}