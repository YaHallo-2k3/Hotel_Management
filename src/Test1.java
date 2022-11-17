

import java.lang.reflect.Field;

public class Test1 {
	
	public String testVar;
	
	void start() throws NoSuchFieldException, SecurityException {
		Test1 newObject = new Test1();
		Class newClassObject = newObject.getClass();
		Field variable = newClassObject.getField("testVar");
		System.out.println("The name of the variable is: " + variable.getName());
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		new Test1().start();

	}

}