package cs523.finalproject.kafka;

import java.io.Serializable;

public class MyClass
{
	public String firstName;
	public String lastName;
	
	public MyClass()
	{
		
	}
	
	public MyClass(String a, String b)
	{
		firstName = a;
		lastName =b;
	}

	@Override
	public String toString() {
		return "MyClass [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
	
}

