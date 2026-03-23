package WK1.example_code;

public class ExceptionalCalculator2 {
	
  public static void main (String[] args) {
    Adder adder = new Adder();
    try {
      for (String arg : args) {
		adder.add(Integer.parseInt(arg));
      }
      System.out.println("Sum:" + adder.sum);
    } 
	catch (NumberFormatException e) {
		System.out.println(e.getMessage());
        System.out.println("Was that really an integer?");
		//e.printStackTrace();
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
        System.out.println("Something went wrong");
	}
} }

